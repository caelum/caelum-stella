package br.com.caelum.stella.gateway.pagseguro;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collection;

public class PagSeguroAutorizacaoReturn {

	private PagSeguroDadosConfiguracao dadosConfiguracao;
	private String transacaoId;
	private PagSeguroCheckout checkout;
	private BigDecimal valorTotalFrete;
	private String anotacao;
	private Calendar dataTransacao;
	private PagSeguroTipoPagamento tipoPagamento;
	private PagSeguroStatusTransacao statusTransacao;	

	public PagSeguroAutorizacaoReturn(
			PagSeguroDadosConfiguracao dadosConfiguracao, String transacaoId,
			PagSeguroCheckout checkout, BigDecimal valorTotalFrete,
			String anotacao, Calendar dataTransacao, PagSeguroTipoPagamento tipoPagamento,
			PagSeguroStatusTransacao statusTransacao) {
		super();
		this.dadosConfiguracao = dadosConfiguracao;
		this.transacaoId = transacaoId;
		this.checkout = checkout;
		this.valorTotalFrete = valorTotalFrete;
		this.anotacao = anotacao;
		this.dataTransacao = dataTransacao;
		this.tipoPagamento = tipoPagamento;
		this.statusTransacao = statusTransacao;
	}

	public String getTransacaoId() {
		return transacaoId;
	}

	/**
	 * 
	 * @return valor total do frete retornado pelo PagSeguro.
	 */
	public BigDecimal getValorTotalFrete() {
		return valorTotalFrete;
	}

	public String getAnotacao() {
		return anotacao;
	}

	public Calendar getDataTransacao() {
		return dataTransacao;
	}

	public PagSeguroTipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public PagSeguroStatusTransacao getStatusTransacao() {
		return statusTransacao;
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

	public String getNome() {
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

	public PagSeguroTipoFrete getTipoFrete() {
		return checkout.getTipoFrete();
	}

	public String getEmailCobranca() {
		return dadosConfiguracao.getEmailCobranca();
	}

	public BigDecimal getValorTotalItens() {
		return checkout.getValorTotalItens();
	}

	/**
	 * 
	 * @return o valor total do frete atribuido aos itens do checkout
	 */
	public BigDecimal getValorTotalFreteCheckout(){
		return checkout.getValorTotalFrete();
	}
	
}
