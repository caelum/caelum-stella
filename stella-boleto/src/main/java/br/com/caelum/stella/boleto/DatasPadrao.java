package br.com.caelum.stella.boleto;

import java.util.Calendar;

/**
 * Implementa datas padrão
 * 
 * @author caue
 *
 */
public class DatasPadrao implements Datas {
	private Calendar documento;
	private Calendar processamento;
	private Calendar vencimento;
	
	private DatasPadrao() {
	}
	
	/**
	 * Cria novas datas
	 * Data do documento padrão: data atual
	 * Data do processamento padrão: data atual
	 * 
	 * @return
	 */
	public static DatasPadrao newDatas() {
		return new DatasPadrao().comDocumento(Calendar.getInstance())
								.comProcessamento(Calendar.getInstance());
	}

	public Calendar getDocumento() {
		return this.documento;
	}
	
	/**
	 * Associa uma data do documento.
	 * Valor padrão: data atual
	 * 
	 * @param documento
	 * @return
	 */
	public DatasPadrao comDocumento(Calendar documento) {
		this.documento = documento;
		return this;
	}

	public Calendar getProcessamento() {
		return this.processamento;
	}
	
	/**
	 * Associa uma data do processamento.
	 * Valor padrão: data atual
	 * 
	 * @param processamento
	 * @return
	 */
	public DatasPadrao comProcessamento(Calendar processamento) {
		this.processamento = processamento;
		return this;
	}

	public Calendar getVencimento() {
		return this.vencimento;
	}

	/**
	 * Associa uma data de vencimento.
	 * 
	 * @param vencimento
	 * @return
	 */
	public DatasPadrao comVencimento(Calendar vencimento) {
		this.vencimento = vencimento;
		return this;
	}

}
