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
	
	/**
	 * Busca o valor da respectiva chave no properties de configuração.
	 * @param key
	 * @return
	 */
	public String getProperty(String key){			
		return gatewaysProperties.getProperty(key).trim();
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
		return getProperty("visa.numeroDeFiliacao");
	}
	
	public String getVISANomeDoArquivoDeConfiguracao(){
		return getProperty("visa.nomeDoArquivoDeConfiguracao");
	}
	
	public String getRedeCardUrlParaComponenteDeAutorizacao(){
		return getProperty("redecard.urlComponenteDeAutorizacao");
	}	
	
	public String getRedeCardNumeroDeFiliacao(){
		return getProperty("redecard.numeroDeFiliacaoFornecedor");
	}
	
	public String getRedeCardNumeroDeFiliacaoDoDistribuidor(){
		return getProperty("redecard.numeroDeFiliacaoDistribuidor");
	}		
	
	public String getRedeCardUrlRetornoTransacao(){
		return getProperty("redecard.urlDeRetornoDaTransacao");
	}
	
	public String getRedeCardUrlConfirmacaoTransacao(){
		return getProperty("redecard.urlConfirmacaoTransacao");
	}
	
	public String getBBIdConv(){
		return getProperty("bb.idConv");
	}
	
	public String getBBCodigoConvenioDeCobranca(){
		return getProperty("bb.codigoConvenioDeCobranca");
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
	
	public String getAmexVpcVersion(){
		return getProperty("amex_vpc_Version");
	}
	
	public String getAmexVpcCommand(){
		return getProperty("amex_vpc_Command");
	}
	
	public String getAmexVpcAccesCode(){
		return getProperty("amex_vpc_AccesCode");
	}
	
	public String getAmexVpcLocale(){
		return getProperty("amex_vpc_Locale");
	}
	
	public String getAmexVpcReturnUrl(){
		return getProperty("amex_vpc_ReturnUrl");
	}
	
	public String getAmexUrlComponenteDeAutorizacao(){
		return getProperty("amex_urlComponenteDeAutorizacao");
	}
	
	public String getAmexVpcCard(){
		return getProperty("amex_vpc_Card");
	}
	
	public String getAmexMerchantId(){
		return getProperty("amex_merchantId");
	}
	
	public String getPagSeguroUrlComponenteDeAutorizacao(){
		return getProperty("uolPagSeguro.urlComponenteDeAutorizacao");
	}
	
	public String getPagSeguroToken(){
		return getProperty("uolPagSeguro.token");
	}	
	
	public String getPagSeguroEmailCobranca(){
		return getProperty("uolPagSeguro.emailCobranca");
	}
	
	public String getPagSeguroUrlVerificacaoToken(){
		return getProperty("uolPagSeguro.urlVerificacaoToken");
	}	
	
	
}
