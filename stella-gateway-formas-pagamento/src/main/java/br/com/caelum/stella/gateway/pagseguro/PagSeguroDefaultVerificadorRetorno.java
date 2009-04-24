package br.com.caelum.stella.gateway.pagseguro;

import org.apache.commons.httpclient.methods.PostMethod;

import br.com.caelum.stella.gateway.core.HttpIntegrationRequester;


public class PagSeguroDefaultVerificadorRetorno implements PagSeguroVerificadorRetorno {
						
	/* (non-Javadoc)
	 * @see br.com.caelum.stella.gateway.uolpagueseguro.PagSeguroVerificadorRetorno#verificaSeRetornoFoiEnviadoPelaPagSeguro(br.com.caelum.stella.gateway.uolpagueseguro.PagSeguroDadosConfiguracao)
	 */
	public boolean verificaSeRetornoFoiEnviadoPelaPagSeguro(PagSeguroDadosConfiguracao dadosConfiguracao){
		PostMethod method = new PostMethod(dadosConfiguracao.getUrlVerificacaoToken());
		method.addParameter("Comando","validar");
		method.addParameter("Token",dadosConfiguracao.getToken());
		String resultado = new HttpIntegrationRequester(method).makeRequest();
		return "VERIFICADO".equals(resultado);		
	}
}