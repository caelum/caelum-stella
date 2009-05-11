package br.com.caelum.stella.gateway.visa;


public class VISADadosAutorizacao {

	private VISACheckout checkout;
	private VISADadosConfiguracao dadosConfiguracao;
	private String tid;
	
	
	VISADadosAutorizacao(VISACheckout checkout,
			VISADadosConfiguracao dadosConfiguracao,String tid) {
		super();
		this.checkout = checkout;
		this.dadosConfiguracao = dadosConfiguracao;
		this.tid = tid;
		
	}


	public VISAFormaPagamento getFormaPagamento() {
		return checkout.getFormaPagamento();
	}

	public String getFree() {
		return checkout.getFree();
	}

	public String getOrder() {
		return checkout.getOrder();
	}

	public String getOrderId() {
		return checkout.getOrderId();
	}

	public String getValorFormatado() {
		return checkout.getValorFormatado();
	}
	
	public String getTid(){
		return this.tid;
	}

	public String getNomeArquivoConfiguracao() {
		return dadosConfiguracao.getNomeArquivoConfiguracao();
	}

	public String getUrlComponenteAutorizacao() {
		return dadosConfiguracao.getUrlComponenteAutorizacao();
	}


	
	
}
