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

import br.com.caelum.stella.nfe.Estados;
import br.com.caelum.stella.nfe.JaxBHelper;
import br.com.caelum.stella.nfe.SOAPLoggingHandler;
import br.com.caelum.stella.nfe.VersaoNFE;
import br.com.caelum.stella.nfe.config.NFEProperties;
import br.com.caelum.stella.nfe.security.TokenAlgorithm;
import br.com.caelum.stella.nfe.security.TokenKeyStoreForWindows;
import br.com.caelum.stella.nfe.ws.sp.recepcao.NfeCabecMsg;
import br.com.caelum.stella.nfe.ws.sp.recepcao.NfeDadosMsg;
import br.com.caelum.stella.nfe.ws.sp.recepcao.NfeRecepcao2;
import br.com.caelum.stella.nfe.ws.sp.recepcao.NfeRecepcao2Soap12;
import br.com.caelum.stella.nfe.ws.sp.recepcao.ObjectFactory;
import br.com.caelum.stella.nfe.ws.sp.status.ConsultaStatusSaoPauloHomolog;
import br.com.caelum.stella.nfe.ws.sp.status.NfeStatusServicoNF2Result;
import br.com.caelum.stella.nfe.ws.sp.status.StatusServico;
import br.com.caelum.stella.nfe.xsd.recepcao.TEnviNFe;
import br.com.caelum.stella.nfe.xsd.recepcao.TNFe;
import br.com.caelum.stella.nfe.xsd.recepcao.TNFe.InfNFe;
import br.com.caelum.stella.nfe.xsd.recepcao.TNFe.InfNFe.Ide;
import br.com.caelum.stella.nfe.xsd.status.TRetConsStatServ;

public class NFeRecepcaoWSTest {
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

			ObjectFactory factoryWS = new ObjectFactory();
			br.com.caelum.stella.nfe.xsd.recepcao.ObjectFactory factoryXSD = new br.com.caelum.stella.nfe.xsd.recepcao.ObjectFactory();
		
			NfeRecepcao2Soap12 envioLote = new NfeRecepcao2().getNfeRecepcao2Soap12();
			
			NfeCabecMsg cabecMsg = factoryWS.createNfeCabecMsg();
			cabecMsg.setCUF(Estados.SP.name());
			cabecMsg.setVersaoDados(VersaoNFE.V_2_00.getVersao());

			NfeDadosMsg dadosMsg = factoryWS.createNfeDadosMsg();
			
			//lote de nfe
			TEnviNFe enviNFe = factoryXSD.createTEnviNFe();
			
			enviNFe.setIdLote("1");
			enviNFe.setVersao(VersaoNFE.V_2_00.getVersao());

			//um wrapper de nota do lote...
			TNFe tnFe = factoryXSD.createTNFe();
			
			//uma nota do lote...
			InfNFe infNFe = factoryXSD.createTNFeInfNFe();
			
			Ide ide = factoryXSD.createTNFeInfNFeIde();
			
			// 3 cnpj (14)
			// 4 modelo (2)
			// 5 serie (3)
			// 6 numero nfe (9) 
			// 7 forma de emissão (1)
			// 8 codigo numerico (8)
			
			ide.setCUF(Estados.SP.getCodigo()); //dv 1 (2)
			ide.setCNF("00000001");
			ide.setNatOp("venda");
			ide.setIndPag("0"); 
			ide.setMod("55");
			ide.setSerie("0");
			ide.setNNF("1");
			ide.setDEmi("2012-05-09"); //dv2 (4-AAMM)
//			ide.setDSaiEnt("2012-05-09");
//			ide.setHSaiEnt("00:00:00");
			ide.setTpNF("1");
			ide.setCMunFG("3550308");
			ide.setTpImp("1");
			ide.setTpEmis("1");
			ide.setCDV(""); // dv...
			
			
			
			
			
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
