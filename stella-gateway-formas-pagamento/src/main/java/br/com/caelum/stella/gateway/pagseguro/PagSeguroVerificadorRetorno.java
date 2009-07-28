package br.com.caelum.stella.gateway.pagseguro;

public interface PagSeguroVerificadorRetorno {

	/**
	 * Verificar se o acesso está sendo feito de fato pelo ambiente do PagSeguro
	 * 
	 * @param dadosConfiguracao
	 * @return true caso o acesso seja feito pelo PagSeguro.
	 */
	public boolean verificaSeRetornoFoiEnviadoPelaPagSeguro(PagSeguroDadosConfiguracao dadosConfiguracao);

}