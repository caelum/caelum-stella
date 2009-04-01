package br.com.caelum.stella.gateway.bb;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.caelum.stella.gateway.core.DadosComprador;

public class Checkout {

	private BigDecimal valor;
	private Calendar dataVencimento;
	private TipoTransacao tipoTransacao;
	private DadosComprador dadosComprador;
	private String mensagemLoja;
	private String numeroDoPedido;
	
	
	public Checkout(BigDecimal valor, Calendar dataVencimento,
			TipoTransacao tipoPagamento, DadosComprador dadosComprador,
			String mensagemLoja, String numeroDoPedido) {
		super();
		this.valor = valor;
		this.dataVencimento = dataVencimento;
		this.tipoTransacao = tipoPagamento;
		this.dadosComprador = dadosComprador;
		this.mensagemLoja = mensagemLoja;
		this.numeroDoPedido = numeroDoPedido;
	}


	public BigDecimal getValor() {
		return valor;
	}


	public Calendar getDataVencimento() {
		return dataVencimento;
	}


	public TipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}


	public String getMensagemLoja() {
		return mensagemLoja;
	}


	public String getCep() {
		return dadosComprador.getCep();
	}


	public String getCidade() {
		return dadosComprador.getCidade();
	}


	public String getEndereco() {
		return dadosComprador.getEndereco();
	}


	public String getEstado() {
		return dadosComprador.getEstado();
	}


	public String getNome() {
		return dadosComprador.getNome();
	}


	public String getNumeroDoPedido() {
		return numeroDoPedido;
	}
	
	
	
}
