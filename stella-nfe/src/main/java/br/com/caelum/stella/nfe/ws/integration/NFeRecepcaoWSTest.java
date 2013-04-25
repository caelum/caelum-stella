package br.com.caelum.stella.nfe.ws.integration;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;

import org.apache.commons.lang.StringUtils;

import br.com.caelum.stella.nfe.Estados;
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
import br.com.caelum.stella.nfe.xsd.recepcao.TEnviNFe;
import br.com.caelum.stella.nfe.xsd.recepcao.TNFe;
import br.com.caelum.stella.nfe.xsd.recepcao.TNFe.InfNFe;
import br.com.caelum.stella.nfe.xsd.recepcao.TNFe.InfNFe.Ide;

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
			
			//dados do emitente / nota
			SimpleDateFormat dfAmerican = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat dfAnooMes = new SimpleDateFormat("yyMM");
			Calendar dataEmissao = Calendar.getInstance();
			String cnpj = "09661762000103";
			
			ide.setCUF(Estados.SP.getCodigo());
			ide.setCNF("00000001");
			ide.setNatOp("venda");
			ide.setIndPag("0"); 
			ide.setMod("55");
			ide.setSerie("0");
			ide.setNNF("1");
			ide.setDEmi(dfAmerican.format(dataEmissao.getTime())); 
//			ide.setDSaiEnt("2012-05-09");
//			ide.setHSaiEnt("00:00:00");
			ide.setTpNF("1");
			ide.setCMunFG("3550308");
			ide.setTpImp("1");
			ide.setTpEmis("1");
			ide.setTpAmb("2"); // ambiente
			ide.setFinNFe("1");
			ide.setProcEmi("0");
			ide.setVerProc(VersaoNFE.V_2_00.getVersao());

			String baseCdv = ide.getCUF()
					+ dfAnooMes.format(dataEmissao.getTime())
					+ cnpj
					+ StringUtils.leftPad(ide.getMod(), 2, '0')    
					+ StringUtils.leftPad(ide.getSerie(), 3, '0')    
					+ StringUtils.leftPad(ide.getNNF(), 9, '0')    
					+ StringUtils.leftPad(ide.getNNF(), 9, '0')
					+ ide.getTpEmis()
					+ StringUtils.leftPad(ide.getCNF(), 8, '0');
			
//			ValidadorDeDv mod = new ValidadorDeDV(new DigitoVerificadorInfo(null, null, null, null, null))
			
			
//			ide.setCDV(cdv); 
			/*
			cUF - Código da UF do emitente do Documento Fiscal
			• AAMM - Ano e Mês de emissão da NF-e
			• CNPJ - CNPJ do emitente
			• mod - Modelo do Documento Fiscal
			• serie - Série do Documento Fiscal
			• nNF - Número do Documento Fiscal
			• tpEmis – forma de emissão da NF-e
			• cNF - Código Numérico que compõe a Chave de Acesso
			• cDV - Dígito Verificador da Chave de Acesso
			*/
			
			infNFe.setIde(ide);
			
			
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
