package br.com.caelum.stella.gateway.pagseguro;

import java.util.Collection;

public class PagSeguroDadosAutorizacaoPagamento {

	private PagSeguroCheckout checkout;
	private PagSeguroDadosConfiguracao dadosConfiguracao;

	public PagSeguroDadosAutorizacaoPagamento(PagSeguroCheckout checkout,
			PagSeguroDadosConfiguracao dadosConfiguracao) {
		super();
		this.checkout = checkout;
		this.dadosConfiguracao = dadosConfiguracao;
	}

	public String getBairro() {
		return checkout.getBairro();
	}

	public String getCep() {
		return checkout.getCep();
	}

	public String getCidade() {
		return checkout.getCidade();
	}

	public String getComplemento() {
		return checkout.getComplemento();
	}

	public String getDdd() {
		return checkout.getDdd();
	}

	public String getEmail() {
		return checkout.getEmail();
	}

	public String getEndereco() {
		return checkout.getEndereco();
	}

	public String getEstado() {
		return checkout.getEstado();
	}

	public Collection<PagSeguroItem> getItens() {
		return checkout.getItens();
	}

	public PagSeguroMoeda getMoeda() {
		return checkout.getMoeda();
	}

	public String getNomeCliente() {
		return checkout.getNome();
	}

	public String getNumero() {
		return checkout.getNumero();
	}

	public String getPais() {
		return checkout.getPais();
	}

	public String getRefTransacao() {
		return checkout.getRefTransacao();
	}

	public String getTelefone() {
		return checkout.getTelefone();
	}

	public String getTipo() {
		return checkout.getTipo();
	}

	public PagSeguroTipoFrete getTipoFrete() {
		return checkout.getTipoFrete();
	}

	public String getUrlBotaoSubmit() {
		return checkout.getUrlBotaoSubmit();
	}

	public String getEmailCobranca() {
		return dadosConfiguracao.getEmailCobranca();
	}

	public String getUrlComponenteAutorizacao() {
		return dadosConfiguracao.getUrlComponenteAutorizacao();
	}

	public boolean hasDadosDoCliente() {
		return checkout.hasDadosDoCliente();
	}


}
