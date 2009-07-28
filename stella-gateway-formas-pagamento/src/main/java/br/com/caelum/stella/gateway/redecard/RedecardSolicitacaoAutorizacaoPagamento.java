package br.com.caelum.stella.gateway.redecard;

import br.com.caelum.stella.gateway.core.IntegrationHandler;

/**
 * Classe responsável por criar o objeto, cujo os atributos devem ser enviados
 * via formulario para o master.
 * 
 * @author Alberto Pc
 * 
 */
public class RedecardSolicitacaoAutorizacaoPagamento implements
		IntegrationHandler<RedecardDadosAutorizacaoPagamento> {

	private RedecardCheckout checkout;
	private String ipComprador;
	private RedecardDadosConfiguracao dadosConfiguracao;

	public RedecardSolicitacaoAutorizacaoPagamento(RedecardCheckout checkout,
			String ipComprador, RedecardDadosConfiguracao dadosConfiguracao) {
		super();
		this.checkout = checkout;
		this.ipComprador = ipComprador;
		this.dadosConfiguracao = dadosConfiguracao;
	}

	public RedecardSolicitacaoAutorizacaoPagamento(RedecardCheckout checkout,
			String ipComprador) {
		this(checkout, ipComprador, new RedecardDadosConfiguracao());
	}

	/**
	 * Retorna um objeto contendo tudo que precisa ser enviado para o ambiente
	 * da redecard. O post para a url tem que ser feito direto via browser.
	 * 
	 * @return
	 */
	public RedecardDadosAutorizacaoPagamento handle() {
		// TODO Auto-generated method stub
		return new RedecardDadosAutorizacaoPagamento(checkout,
				new RedecardDadosFiliacao(dadosConfiguracao.getNumeroFiliacaoFornecedor(),
				dadosConfiguracao.getNumeroFiliacaoDistribuidor()), CodVer
						.calculaCodigoVerificacao(String.valueOf(dadosConfiguracao.getNumeroFiliacaoFornecedor()), checkout
								.getTotalComDuasCasasDecimais().toString(),
								ipComprador),dadosConfiguracao.getUrlRetornoTransacao(), null, null);
	}

}
