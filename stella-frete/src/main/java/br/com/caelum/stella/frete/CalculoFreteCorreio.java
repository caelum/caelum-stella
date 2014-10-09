package br.com.caelum.stella.frete;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import br.com.caelum.stella.frete.entity.Encomenda;
import br.com.caelum.stella.frete.entity.Frete;
import br.com.caelum.stella.frete.enums.Servico;
import br.com.caelum.stella.frete.exception.CorreiosException;
import br.com.caelum.stella.frete.ws.CorreiosService;


public class CalculoFreteCorreio {  

	public static Frete calcularFrete( Encomenda encomenda, Servico tipoFrete) throws CorreiosException {  
		Properties parameters = new Properties(); 

		parameters.setProperty("nCdEmpresa", encomenda.getCodigoEmpresa());  
		parameters.setProperty("sDsSenha", encomenda.getSenha());  
		parameters.setProperty("nCdServico", tipoFrete.toString());  
		parameters.setProperty("sCepOrigem", encomenda.getCepOrigem());  
		parameters.setProperty("sCepDestino", encomenda.getCepDestino());  
		parameters.setProperty("nVlPeso", encomenda.getPeso());  
		parameters.setProperty("nCdFormato", encomenda.getFormato().toString());  
		parameters.setProperty("nVlComprimento", encomenda.getComprimento());  
		parameters.setProperty("nVlAltura", encomenda.getAltura());  
		parameters.setProperty("nVlLargura", encomenda.getLargura());  
		parameters.setProperty("nVlDiametro", encomenda.getDiametro());  
		parameters.setProperty("sCdMaoPropria", encomenda.getMaoPropria());  
		parameters.setProperty("nVlValorDeclarado", encomenda.getValorDeclarado());  
		parameters.setProperty("sCdAvisoRecebimento", encomenda.getAvisoRecebimento());  
		parameters.setProperty("StrRetorno", "xml");

		InputSource is = new InputSource();  	
		DocumentBuilder db;
		Document doc = null;
		try {
			db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			is.setCharacterStream(new StringReader(CorreiosService.sendRequest(parameters))); 
			doc = db.parse(is);
			Node servicos = doc.getFirstChild();
			JAXBContext jc = JAXBContext.newInstance(Frete.class);
			Unmarshaller u = jc.createUnmarshaller();
			Frete frete = u.unmarshal( servicos.getFirstChild(), Frete.class).getValue();
			if (frete.getErro()!= 0){
				throw new CorreiosException(frete.getErro(), frete.getMensagemErro());
			}
			return frete;

		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
		return null;
	}  
}  