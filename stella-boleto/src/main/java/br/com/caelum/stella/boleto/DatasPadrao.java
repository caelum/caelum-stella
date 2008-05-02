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

	public Calendar getDataDoDocumento() {
		return this.documento;
	}
	
	public DatasPadrao comDataDeDocumento(Calendar documento) {
		this.documento = documento;
		return this;
	}

	public Calendar getDataDoProcessamento() {
		return this.processamento;
	}
	
	public DatasPadrao comDataDeProcessamento(Calendar processamento) {
		this.processamento = processamento;
		return this;
	}

	public Calendar getDataDeVencimento() {
		return this.vencimento;
	}

	public DatasPadrao comDataDeVencimento(Calendar vencimento) {
		this.vencimento = vencimento;
		return this;
	}

}
