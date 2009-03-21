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
	
	public String getUrlParaComponenteDeAutorizacaoDoVisa(){
		return getProperty("visa.urlComponenteDeAutorizacao");
	}
	
	public String getUrlParaComponenteDeCapturaDoVisa(){
		return getProperty("visa.urlComponenteDeCaptura");
	}
	
	public String getUrlParaComponenteDeCancelamentoDoVisa(){
		return getProperty("visa.urlComponenteDeCancelamento");
	}	
	
	public String getUrlParaComponenteDeConsultaDoVisa(){
		return getProperty("visa.urlComponenteDeConsulta");
	}	
	
	public String getNumeroDeFiliacaoDoVisa(){
		return getProperty("visa.numeroDeFiliacao");
	}
	
	public String getNomeDoArquivoDeConfiguracaoDoVisa(){
		return getProperty("visa.nomeDoArquivoDeConfiguracao");
	}
	
	public String getUrlParaComponenteDeAutorizacaoDaRedeCard(){
		return getProperty("redecard.urlComponenteDeAutorizacao");
	}	
	
	public String getNumeroDeFiliacaoDaRedecard(){
		return getProperty("redecard.numeroDeFiliacaoFornecedor");
	}
	
	public String getNumeroDeFiliacaoDoDistribuidorDaRedecard(){
		return getProperty("redecard.numeroDeFiliacaoDistribuidor");
	}		
	
	public String getUrlRetornoTransacaoRedecard(){
		return getProperty("redecard.urlDeRetornoDaTransacao");
	}
	
	public String getUrlConfirmacaoTransacaoRedecard(){
		return getProperty("redecard.urlConfirmacaoTransacao");
	}
}
