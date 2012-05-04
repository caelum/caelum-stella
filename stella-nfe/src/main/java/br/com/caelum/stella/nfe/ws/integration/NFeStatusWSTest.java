package br.com.caelum.stella.nfe.ws.integration;

import java.io.File;
import java.io.StringWriter;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;

import org.w3c.dom.Node;

import br.com.caelum.stella.nfe.SOAPLoggingHandler;
import br.com.caelum.stella.nfe.VersaoNFE;
import br.com.caelum.stella.nfe.config.NFEProperties;
import br.com.caelum.stella.nfe.security.TokenAlgorithm;
import br.com.caelum.stella.nfe.security.TokenKeyStoreForWindows;
import br.com.caelum.stella.nfe.ws.sp.ConsultaStatusSaoPauloHomolog;
import br.com.caelum.stella.nfe.ws.sp.NfeStatusServicoNF2Result;
import br.com.caelum.stella.nfe.xsd.schema.generated.TRetConsStatServ;


public class NFeStatusWSTest {
	private static final boolean DEBUG_ENABLE = true;
	private static final boolean LOG_ENABLE = true;

	private static String tokenConfigFile = null;
	private static String senhaDoCertificado = null;
	private static String alias = null;

	public static void main(String[] args) {
		try {

			NFEProperties prop = new NFEProperties();

			tokenConfigFile = prop.getProperty("arquivo.config.token");
			
			senhaDoCertificado = prop.getProperty("certificado.senha");
			alias = prop.getProperty("certificado.alias");

			TokenKeyStoreForWindows ks = new TokenKeyStoreForWindows(tokenConfigFile, TokenAlgorithm.PKCS11, senhaDoCertificado);
			ks.getCertificateFor(alias).enableSSLForServer();

			NfeStatusServicoNF2Result consulta = new ConsultaStatusSaoPauloHomolog(VersaoNFE.V_2_00).consulta();
			System.out.println(printXML(consulta));
			// Element element = (Element) consulta.getContent().get(0);

			Object content = consulta.getContent().get(0);
			System.out.println(content.getClass());

			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			File schemaFile = new File("\\\\psf\\Home\\dev\\workspace\\nfe-test\\xsds\\PL_006j\\retConsStatServ_v2.00.xsd");
			System.out.println(schemaFile.exists());
			Schema schema = sf.newSchema(schemaFile);

			JAXBContext context = JAXBContext.newInstance(TRetConsStatServ.class);
			Unmarshaller um = context.createUnmarshaller();
			um.setSchema(schema);
			um.setEventHandler(new MyValidationEventHandler());

			JAXBElement<TRetConsStatServ> response = um.unmarshal((Node) content, TRetConsStatServ.class);
			System.out.println("response: " + response.getValue());

			// System.out.println(element.);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static String printXML(Object dados) throws PropertyException, JAXBException {
		Marshaller marshaller = getMarshallerFor(dados.getClass());
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		StringWriter stringWriter = new StringWriter();
		marshaller.marshal(dados, stringWriter);
		return stringWriter.getBuffer().toString();
	}

	private static Marshaller getMarshallerFor(Class<?> klass) throws JAXBException, PropertyException {
		JAXBContext jaxContext = JAXBContext.newInstance(klass);
		Marshaller marshaller = jaxContext.createMarshaller();
		return marshaller;
	}

	private static void configureLoggiing(BindingProvider bp) {
		if (LOG_ENABLE) {
			List<Handler> handlerChain = bp.getBinding().getHandlerChain();
			handlerChain.add(new SOAPLoggingHandler());
			bp.getBinding().setHandlerChain(handlerChain);
		}
	}

	private static void configureDebug() {
		if (DEBUG_ENABLE) {
			System.setProperty("javax.net.debug", "all");
			System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
		}
	}
}

class MyValidationEventHandler implements ValidationEventHandler {

	public boolean handleEvent(ValidationEvent event) {
		System.out.println("\nEVENT");
		System.out.println("SEVERITY:  " + event.getSeverity());
		System.out.println("MESSAGE:  " + event.getMessage());
		System.out.println("LINKED EXCEPTION:  " + event.getLinkedException());
		System.out.println("LOCATOR");
		System.out.println("    LINE NUMBER:  " + event.getLocator().getLineNumber());
		System.out.println("    COLUMN NUMBER:  " + event.getLocator().getColumnNumber());
		System.out.println("    OFFSET:  " + event.getLocator().getOffset());
		System.out.println("    OBJECT:  " + event.getLocator().getObject());
		System.out.println("    NODE:  " + event.getLocator().getNode());
		System.out.println("    URL:  " + event.getLocator().getURL());
		return true;
	}

}
