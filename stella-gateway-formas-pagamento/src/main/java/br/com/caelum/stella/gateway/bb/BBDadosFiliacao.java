package br.com.caelum.stella.gateway.bb;

public class BBDadosFiliacao {

	private int idConv;
	private Integer codigoConvenioCobranca;
	
	
	
	public BBDadosFiliacao(int idConv, Integer codigoConvenioCobranca) {
		super();
		this.idConv = idConv;
		this.codigoConvenioCobranca = codigoConvenioCobranca;
	}
	
	
	
	public BBDadosFiliacao(int idConv) {
		super();
		this.idConv = idConv;
	}



	public int getIdConv() {
		return idConv;
	}
	public Integer getCodigoConvenioCobranca() {
		return codigoConvenioCobranca;
	}
	
	
}
