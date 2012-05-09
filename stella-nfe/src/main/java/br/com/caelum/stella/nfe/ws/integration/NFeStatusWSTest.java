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

import br.com.caelum.stella.nfe.JaxBHelper;
import br.com.caelum.stella.nfe.SOAPLoggingHandler;
import br.com.caelum.stella.nfe.VersaoNFE;
import br.com.caelum.stella.nfe.config.NFEProperties;
import br.com.caelum.stella.nfe.security.TokenAlgorithm;
import br.com.caelum.stella.nfe.security.TokenKeyStoreForWindows;
import br.com.caelum.stella.nfe.ws.sp.status.ConsultaStatusSaoPauloHomolog;
import br.com.caelum.stella.nfe.ws.sp.status.NfeStatusServicoNF2Result;
import br.com.caelum.stella.nfe.ws.sp.status.StatusServico;
import br.com.caelum.stella.nfe.xsd.status.TRetConsStatServ;

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

			TokenKeyStoreForWindows ks = new TokenKeyStoreForWindows(tokenConfigFile, TokenAlgorithm.PKCS11,
					senhaDoCertificado);
			ks.getCertificateFor(alias).enableSSLForServer();

			StatusServico consulta = new ConsultaStatusSaoPauloHomolog(VersaoNFE.V_2_00).consulta();

			System.out.println("Serviço ativo: " + consulta.isAtivo());
			System.out.println(new JaxBHelper().toXML(consulta.getResponse()));

		} catch (Exception e) {
			e.printStackTrace();
		}

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
