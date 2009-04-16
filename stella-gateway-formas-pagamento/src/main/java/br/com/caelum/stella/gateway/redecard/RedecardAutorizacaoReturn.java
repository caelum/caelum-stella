package br.com.caelum.stella.gateway.redecard;

import java.util.Calendar;

public class RedecardAutorizacaoReturn{

	private int codigoRetorno;
	private String mensagemRetorno;
	private Calendar data;
	private String numPedido;
	private String nrCartao;
	private String origemBin;
	private String numAutor;
	private String numCV;
	private String numAutent;
	private String numSQN;
	private RedecardIdiomaOperacao idiomaOperacao;
	

	RedecardAutorizacaoReturn(int codigoRetorno, String mensagemRetorno,
			String numPedido) {
		super();
		this.codigoRetorno = codigoRetorno;
		this.mensagemRetorno = mensagemRetorno;
		this.numPedido = numPedido;
	}

	public RedecardAutorizacaoReturn(int codigoRetorno, String mensagemRetorno,
			Calendar data, String numPedido, String nrCartao, String origemBin,
			String numAutor, String numCV, String numAutent, String numSQN,RedecardIdiomaOperacao idiomaOperacao) {
		super();
		this.codigoRetorno = codigoRetorno;
		this.mensagemRetorno = mensagemRetorno;
		this.data = data;
		this.numPedido = numPedido;
		this.nrCartao = nrCartao;
		this.origemBin = origemBin;
		this.numAutor = numAutor;
		this.numCV = numCV;
		this.numAutent = numAutent;
		this.numSQN = numSQN;
		this.idiomaOperacao = idiomaOperacao;
	}

	public int getCodigoRetorno() {
		return codigoRetorno;
	}

	public String getMensagemRetorno() {
		return mensagemRetorno;
	}

	public Calendar getData() {
		return data;
	}

	public String getNumPedido() {
		return numPedido;
	}

	public String getNrCartao() {
		return nrCartao;
	}

	public String getOrigemBin() {
		return origemBin;
	}

	public String getNumAutor() {
		return numAutor;
	}

	public String getNumCV() {
		return numCV;
	}

	public String getNumAutent() {
		return numAutent;
	}

	public String getNumSQN() {
		return numSQN;
	}
	
	public String getDataFormatada(){
		return String.format("%1$tY%1$tm%1$te",data);
	}

	public RedecardIdiomaOperacao getIdiomaOperacao() {
		return idiomaOperacao;
	}
	
	
}
