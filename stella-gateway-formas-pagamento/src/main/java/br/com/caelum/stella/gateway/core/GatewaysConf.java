package br.com.caelum.stella.gateway.core;

import java.io.IOException;
import java.util.Properties;

/**
 * Classe no estilo helper que carrega as configurações que não devem estar no código
 * para acessar os gateways. 
 * @author Alberto Pc
 *
 */
public class GatewaysConf {

	private static Properties gatewaysProperties;	
	
	static{
		gatewaysProperties = new Properties();
		try {
			gatewaysProperties.load(GatewaysConf.class.getResourceAsStream("/gateways.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Não foi possivel carregar o arquivo de configuração dos gateways",e);
		}
	}
	
	
	private String getProperty(String key){			
		return gatewaysProperties.getProperty(key);
	}
	
	public String getVISAUrlParaComponenteDeAutorizacao(){
		return getProperty("visa.urlComponenteDeAutorizacao");
	}
	
	public String getVISAUrlParaComponenteDeCaptura(){
		return getProperty("visa.urlComponenteDeCaptura");
	}
	
	public String getVISAUrlParaComponenteDeCancelamento(){
		return getProperty("visa.urlComponenteDeCancelamento");
	}	
	
	public String getVISAUrlParaComponenteDeConsulta(){
		return getProperty("visa.urlComponenteDeConsulta");
	}	
	
	public String getVISANumeroDeFiliacao(){
		return getProperty("visa.numeroDeFiliacao").trim();
	}
	
	public String getVISANomeDoArquivoDeConfiguracao(){
		return getProperty("visa.nomeDoArquivoDeConfiguracao");
	}
	
	public String getRedeCardUrlParaComponenteDeAutorizacao(){
		return getProperty("redecard.urlComponenteDeAutorizacao");
	}	
	
	public String getRedeCardNumeroDeFiliacao(){
		return getProperty("redecard.numeroDeFiliacaoFornecedor").trim();
	}
	
	public String getRedeCardNumeroDeFiliacaoDoDistribuidor(){
		return getProperty("redecard.numeroDeFiliacaoDistribuidor").trim();
	}		
	
	public String getRedeCardUrlRetornoTransacao(){
		return getProperty("redecard.urlDeRetornoDaTransacao");
	}
	
	public String getRedeCardUrlConfirmacaoTransacao(){
		return getProperty("redecard.urlConfirmacaoTransacao");
	}
	
	public String getBBIdConv(){
		return getProperty("bb.idConv").trim();
	}
	
	public String getBBCodigoConvenioDeCobranca(){
		return getProperty("bb.codigoConvenioDeCobranca").trim();
	}
	
	public String getBBUrlInforma(){
		return getProperty("bb.urlInforma");
	}
	
	public String getBBUrlRetorno(){
		return getProperty("bb.urlRetorno");
	}
	
	public String getBBUrlComponenteDeAutorizacao(){
		return getProperty("bb.urlComponenteDeAutorizacao");
	}
	
	public String getBBUrlSonda(){
		return getProperty("bb.urlSonda");
	}
}
