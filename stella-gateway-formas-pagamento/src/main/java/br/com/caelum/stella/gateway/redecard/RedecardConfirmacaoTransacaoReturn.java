package br.com.caelum.stella.gateway.redecard;

public class RedecardConfirmacaoTransacaoReturn {
	
	private int codigoRetorno;
	private String mensagemRetorno;
	
	

	public RedecardConfirmacaoTransacaoReturn(int codigoRetorno,
			String mensagemRetorno) {
		super();
		this.codigoRetorno = codigoRetorno;
		this.mensagemRetorno = mensagemRetorno;
	}



	public int getCodigoRetorno() {
		return codigoRetorno;
	}



	public void setCodigoRetorno(int codigoRetorno) {
		this.codigoRetorno = codigoRetorno;
	}



	public String getMensagemRetorno() {
		return mensagemRetorno;
	}



	public void setMensagemRetorno(String mensagemRetorno) {
		this.mensagemRetorno = mensagemRetorno;
	}

	
}
