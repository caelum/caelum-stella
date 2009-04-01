package br.com.caelum.stella.gateway.bb.integration;

public class BBBasicDataReturn {

	private final String idConv;
	private final String refTran;
	
	
	
	public BBBasicDataReturn(final String idConv, final String refTran) {		
		this.idConv = idConv;
		this.refTran = refTran;
	}

	public String getIdConv() {
		return idConv;
	}

	public String getRefTran() {
		return refTran;
	}

	
	
}
