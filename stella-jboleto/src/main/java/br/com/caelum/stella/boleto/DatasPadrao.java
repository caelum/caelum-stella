package br.com.caelum.stella.boleto;

import java.util.Calendar;

public class DatasPadrao implements Datas {
	private Calendar documento;
	private Calendar processamento;
	private Calendar vencimento;

	public Calendar getDataDocumento() {
		return this.documento;
	}
	
	public DatasPadrao comDataDocumento(Calendar documento) {
		this.documento = documento;
		return this;
	}

	public Calendar getDataProcessamento() {
		return this.processamento;
	}

	public Calendar getDataVencimento() {
		return this.vencimento;
	}

}
