package br.com.caelum.stella.boleto;

import java.util.Calendar;

public class DatasPadrao implements Datas {
	private Calendar documento;
	private Calendar processamento;
	private Calendar vencimento;

	private DatasPadrao() {
	}

	/**
	 * Cria novas datas<br/> Data do documento padrão: data atual<br/> Data do
	 * processamento padrão: data atual
	 * 
	 */
	public static DatasPadrao newDatas() {
		return new DatasPadrao().comDocumento(Calendar.getInstance())
				.comProcessamento(Calendar.getInstance());
	}

	public Calendar getDocumento() {
		return this.documento;
	}

	/**
	 * Associa uma data do documento.<br/> Valor padrão: data atual
	 * 
	 * @param documento
	 */
	public DatasPadrao comDocumento(Calendar documento) {
		this.documento = documento;
		return this;
	}

	public Calendar getProcessamento() {
		return this.processamento;
	}

	/**
	 * Associa uma data do processamento.<br/> Valor padrão: data atual
	 * 
	 * @param processamento
	 */
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
