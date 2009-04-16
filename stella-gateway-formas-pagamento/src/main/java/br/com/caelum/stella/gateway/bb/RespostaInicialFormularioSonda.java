package br.com.caelum.stella.gateway.bb;


/**
 * Classe para poder parsear o xml de entrada do formulario sonda  e servir de base para criar a BBFormularioSondaReturn  
 * @author Alberto Pc
 *
 */

class RespostaInicialFormularioSonda {

	
	private String refTran;
	
	private String valor;
	
	private String idConv;
	
	private String tpPagamento;
	
	private String situacao;
	
	private String dataPagamento;
	
	
	
	
	public RespostaInicialFormularioSonda(String refTran, String valor,
			String idConv, String tpPagamento, String situacao,
			String dataPagamento) {
		super();
		this.refTran = refTran;
		this.valor = valor;
		this.idConv = idConv;
		this.tpPagamento = tpPagamento;
		this.situacao = situacao;
		this.dataPagamento = dataPagamento;
	}
	public RespostaInicialFormularioSonda() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getRefTran() {
		return refTran;
	}
	public void setRefTran(String refTran) {
		this.refTran = refTran;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getIdConv() {
		return idConv;
	}
	public void setIdConv(String idConv) {
		this.idConv = idConv;
	}
	public String getTpPagamento() {
		return tpPagamento;
	}
	public void setTpPagamento(String tpPagamento) {
		this.tpPagamento = tpPagamento;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(String dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
}
