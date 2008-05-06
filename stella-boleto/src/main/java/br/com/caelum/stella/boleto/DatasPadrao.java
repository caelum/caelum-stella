package br.com.caelum.stella.boleto;

import java.util.Calendar;

public class DatasPadrao implements Datas {
	private Calendar documento;
	private Calendar processamento;
	private Calendar vencimento;
	
	private DatasPadrao() {
	}
	
	public static DatasPadrao newDatas() {
		return new DatasPadrao();
	}

	public Calendar getDocumento() {
		return this.documento;
	}
	
	public DatasPadrao comDocumento(Calendar documento) {
		this.documento = documento;
		return this;
	}

	public Calendar getProcessamento() {
		return this.processamento;
	}
	
	public DatasPadrao comProcessamento(Calendar processamento) {
		this.processamento = processamento;
		return this;
	}

	public Calendar getVencimento() {
		return this.vencimento;
	}

	public DatasPadrao comVencimento(Calendar vencimento) {
		this.vencimento = vencimento;
		return this;
	}

}
