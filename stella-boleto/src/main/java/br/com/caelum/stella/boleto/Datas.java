package br.com.caelum.stella.boleto;

import java.util.Calendar;

/**
 * Interface das datas
 * 
 * @author caue
 *
 */
public interface Datas {

	/**
	 * Devolve a data de vencimento do boleto
	 * 
	 * @return
	 */
	Calendar getVencimento();

	/**
	 * Devolve a data do documento do boleto. (data de geração do boleto)
	 * Valor padrão: data de criação do boleto
	 * 
	 * @return
	 */
	Calendar getDocumento();

	/**
	 * Devolve a data de processamento do boleto. (data de geração do boleto)
	 * Valor padrão: data de criação do boleto
	 * 
	 * @return
	 */
	Calendar getProcessamento();

}