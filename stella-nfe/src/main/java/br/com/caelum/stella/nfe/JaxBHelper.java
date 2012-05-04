package br.com.caelum.stella.nfe;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.w3c.dom.Node;

public class JaxBHelper {

	public <T> T unmarshalNode(Object object, Class<T> NodeClass) {

		try {
			Unmarshaller unmarshaller = getUnMarshallerFor(NodeClass);
			JAXBElement<T> jaxBElement = unmarshaller.unmarshal((Node) object, NodeClass);
			return jaxBElement.getValue();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public Unmarshaller getUnMarshallerFor(Class<?> klass) {
		try {
			JAXBContext context = JAXBContext.newInstance(klass);
			return context.createUnmarshaller();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public String toXML(Object dados) {
		Marshaller marshaller = getMarshallerFor(dados.getClass());
		StringWriter stringWriter = new StringWriter();
		try {
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(dados, stringWriter);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return stringWriter.getBuffer().toString();
	}
	

	public Marshaller getMarshallerFor(Class<?> klass) {
		try {
			JAXBContext jaxContext = JAXBContext.newInstance(klass);
			Marshaller marshaller = jaxContext.createMarshaller();
			return marshaller;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
