package br.com.caelum.stella.feriado.util;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import br.com.caelum.stella.feriado.enums.Lugares;
import br.com.caelum.stella.feriado.listener.DataListener;

public class XMLUtil {


	public static <T extends Object> T xmlToObject(Class<T> type,int ano,Lugares lugar){
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(type);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			jaxbUnmarshaller.setListener(new DataListener(ano));
			return  type.cast(jaxbUnmarshaller.unmarshal(File.class.getResourceAsStream("/{nome}.xml".replace("{nome}", lugar.toString()))));
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}
}
