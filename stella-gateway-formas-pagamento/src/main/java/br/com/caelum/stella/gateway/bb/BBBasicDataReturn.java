package br.com.caelum.stella.gateway.bb;

/**
 * Classe que contem atributos que sempre são retornados nas integrações
 * @author Alberto Pc
 *
 */
public class BBBasicDataReturn {

	private int idConv;
	private String refTran;

	public BBBasicDataReturn(int idConv, String refTran) {
		this.idConv = idConv;
		this.refTran = refTran;
	}

	public int getIdConv() {
		return idConv;
	}

	public String getRefTran() {
		return refTran;
	}

}
