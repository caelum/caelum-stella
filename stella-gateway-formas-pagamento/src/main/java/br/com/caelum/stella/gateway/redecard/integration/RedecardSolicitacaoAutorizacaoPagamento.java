package br.com.caelum.stella.gateway.redecard.integration;

import br.com.caelum.stella.gateway.core.GatewaysConf;
import br.com.caelum.stella.gateway.core.IntegrationHandler;
import br.com.caelum.stella.gateway.redecard.Checkout;

/**
 * Classe responsável por criar o objeto, cujo os atributos devem ser enviados
 * via formulario para o master.
 * 
 * @author Alberto Pc
 * 
 */
public class RedecardSolicitacaoAutorizacaoPagamento implements
		IntegrationHandler<RedecardDadosAutorizacaoPagamento> {

	private final Checkout checkout;
	private final GatewaysConf gatewaysConf = new GatewaysConf();
	private final String ipComprador;

	public RedecardSolicitacaoAutorizacaoPagamento(final Checkout checkout,
			final String ipComprador) {
		super();
		this.checkout = checkout;
		this.ipComprador = ipComprador;
	}

	/**
	 * Retorna um objeto contendo tudo que precisa ser enviado para o ambiente
	 * da redecard. O post para a url tem que ser feito direto via browser.
	 * 
	 * @return
	 */
	public RedecardDadosAutorizacaoPagamento handle() {
		// TODO Auto-generated method stub
		return new RedecardDadosAutorizacaoPagamento(checkout, gatewaysConf
				.getRedeCardNumeroDeFiliacao(), gatewaysConf
				.getRedeCardNumeroDeFiliacaoDoDistribuidor(),
				CodVer
						.calculaCodigoVerificacao(gatewaysConf
								.getRedeCardNumeroDeFiliacao(), checkout
								.getTotalComDuasCasasDecimais().toString(),
								ipComprador), gatewaysConf
						.getRedeCardUrlConfirmacaoTransacao(), null, null);
	}

}
