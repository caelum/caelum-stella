package br.com.caelum.stella.boleto;

import java.util.Calendar;

public interface Datas {

	Calendar getVencimento();

	/**
	 * Devolve a data do documento do boleto. (data de geração do boleto)<br/>
	 * Valor padrão: data de criação do boleto
	 * 
	 * @return
	 */
	Calendar getDocumento();

	/**
	 * Devolve a data de processamento do boleto. (data de geração do boleto)<br/>
	 * Valor padrão: data de criação do boleto
	 * 
	 * @return
	 */
	Calendar getProcessamento();
}