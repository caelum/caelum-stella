package br.com.caelum.stella.gateway.bb;

import java.text.MessageFormat;

import br.com.caelum.stella.gateway.core.IntegrationHandler;

public class BBSolicitaAutorizacaoPagamento implements
		IntegrationHandler<BBDadosAutorizacaoPagamento> {

	private BBCheckout checkout;	
	private String numeroASerAnexadoAoCodigoDeConvenio;
	private Object[] urlRetornoParams;
	private Object[] urlInformaParams;
	private BBDadosConfiguracao dadosConfiguracao;

	public BBSolicitaAutorizacaoPagamento(BBCheckout checkout,
			String numeroASerAnexadoAoCodigoDeConvenio) {
		this(checkout, new BBDadosConfiguracao(),
				numeroASerAnexadoAoCodigoDeConvenio, new Object[] {},
				new Object[] {});
	}

	public BBSolicitaAutorizacaoPagamento(BBCheckout checkout,
			String numeroASerAnexadoAoCodigoDeConvenio,
			Object[] urlRetornoParams, Object[] urlInformaParams) {
		this(checkout, new BBDadosConfiguracao(),
				numeroASerAnexadoAoCodigoDeConvenio, urlRetornoParams,
				urlInformaParams);
	}

	public BBSolicitaAutorizacaoPagamento(BBCheckout checkout,
			BBDadosConfiguracao dadosConfiguracao,
			String numeroASerAnexadoAoCodigoDeConvenio) {
		this(checkout, dadosConfiguracao, numeroASerAnexadoAoCodigoDeConvenio,
				new Object[] {}, new Object[] {});
	}

	public BBSolicitaAutorizacaoPagamento(BBCheckout checkout,
			BBDadosConfiguracao dadosConfiguracao,
			String numeroASerAnexadoAoCodigoDeConvenio,
			Object[] urlRetornoParams, Object[] urlInformaParams) {
		this.checkout = checkout;
		this.dadosConfiguracao = dadosConfiguracao;
		this.numeroASerAnexadoAoCodigoDeConvenio = numeroASerAnexadoAoCodigoDeConvenio;
		this.urlRetornoParams = urlInformaParams;
		this.urlInformaParams = urlInformaParams;
	}

	public BBDadosAutorizacaoPagamento handle() {
		// TODO Auto-generated method stub
		return new BBDadosAutorizacaoPagamento(checkout,new BBBasicDataReturn(dadosConfiguracao.getIdConv(),
				new RefTranGenerator().geraRefTran(dadosConfiguracao.getCodigoConvenioCobranca(),
						numeroASerAnexadoAoCodigoDeConvenio)), MessageFormat
						.format(dadosConfiguracao.getUrlRetorno(),
								urlRetornoParams), MessageFormat.format(
						dadosConfiguracao.getUrlInforma(), urlInformaParams));
	}

}
