package br.com.caelum.stella.gateway.pagseguro;

import br.com.caelum.stella.gateway.core.IntegrationHandler;

public class PagSeguroSolicitaAutorizacaoPagamento implements IntegrationHandler<PagSeguroDadosAutorizacaoPagamento> {

	private PagSeguroDadosConfiguracao dadosConfiguracao;
	private PagSeguroCheckout checkout;

	public PagSeguroSolicitaAutorizacaoPagamento(
			PagSeguroDadosConfiguracao dadosConfiguracao,
			PagSeguroCheckout checkout) {		
		this.dadosConfiguracao = dadosConfiguracao;
		this.checkout = checkout;
	}

	public PagSeguroSolicitaAutorizacaoPagamento(PagSeguroCheckout checkout) {
		this(new PagSeguroDadosConfiguracao(),checkout);
	}

	public PagSeguroDadosAutorizacaoPagamento handle() {
		// TODO Auto-generated method stub
		return new PagSeguroDadosAutorizacaoPagamento(checkout,dadosConfiguracao);
	}
	
	

}
