package br.com.caelum.stella.gateway.amex;

import br.com.caelum.stella.gateway.core.IntegrationHandler;

/**
 * Constroi o objeto que deve ser utilizado para realizar a integração em 3 partes
 * 
 * @author Alberto Pc
 * 
 */
public class AmexSolicitaAutorizacaoPagamento implements
		IntegrationHandler<AmexDadosAutorizacaoPagamento> {

	private  AmexCheckout checkout;
	private  AmexDadosConfiguracao dadosConfiguracao;

	public AmexSolicitaAutorizacaoPagamento( AmexCheckout checkout,
			 AmexDadosConfiguracao dadosConfiguracao) {
		super();
		this.checkout = checkout;
		this.dadosConfiguracao = dadosConfiguracao;
	}

	public AmexSolicitaAutorizacaoPagamento(AmexCheckout checkout) {
		super();
		this.checkout = checkout;
		this.dadosConfiguracao = new AmexDadosConfiguracao();
	}

	public AmexDadosAutorizacaoPagamento handle() {
		// TODO Auto-generated method stub
		return new AmexDadosAutorizacaoPagamento(checkout, dadosConfiguracao);
	}

}
