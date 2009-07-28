package br.com.caelum.stella.gateway.visa;

import java.util.Calendar;

import br.com.caelum.stella.gateway.core.IntegrationHandler;

/**
 * Classe responsável por gerar o objeto que deve ser usado
 * para mandar as informações para o VISA.
 * 
 * @author Alberto Pc
 * 
 */
public class VISASolicitaAutorizacaoPagamentoViaHttp implements
		IntegrationHandler<VISADadosAutorizacao> {

	private VISACheckout checkout;
	private VISADadosConfiguracao dadosConfiguracao;
	

	public VISASolicitaAutorizacaoPagamentoViaHttp(VISACheckout checkout) {
		this(checkout,new VISADadosConfiguracao());		
	}
	
	

	public VISASolicitaAutorizacaoPagamentoViaHttp(VISACheckout checkout,
			VISADadosConfiguracao dadosConfiguracao) {
		super();
		this.checkout = checkout;
		this.dadosConfiguracao = dadosConfiguracao;		
	}



	public VISADadosAutorizacao handle() {
		// TODO Auto-generated method stub
		return new VISADadosAutorizacao(checkout,dadosConfiguracao,new TIDGenerator().getTid(checkout.getFormaPagamento(),Calendar.getInstance(),dadosConfiguracao.getNumeroFiliacao()));
	}

}
