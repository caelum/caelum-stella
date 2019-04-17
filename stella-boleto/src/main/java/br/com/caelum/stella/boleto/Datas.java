package br.com.caelum.stella.boleto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.caelum.stella.boleto.exception.DataLimiteUltrapassadaException;

/**
 * Bean que representa as datas relacionadas a um Boleto.
 * 
 * @author Paulo Silveira
 * @author Caue Guerra
 * @author Leonardo Bessa
 * 
 */
@SuppressWarnings("unused")
public class Datas implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Utilizar o range de 3000 dias antes da data de emissão do documento
	 */
	@Deprecated
	private static final Calendar MINIMUM_DATE = new GregorianCalendar(1997, 10, 7);
	
	/**
	 * Utilizar o range de 5500 dias a partir da data de emissão do documento
	 */
	@Deprecated
	private static final Calendar MAXIMUM_DATE = new GregorianCalendar(2025, 1, 21);

	/**
	 * Data inicial com fator de vencimento de 1000. (03/07/2000)
	 */
	private static final Calendar INIT_DATE = new GregorianCalendar(2000, 6, 3);

	private static final int RANGE_MINIMO = 3000;
	private static final int RANGE_MAXIMO = 5500;

	private Calendar documento;
	private Calendar processamento;
	private Calendar vencimento;
	private Datas() { }

	/**
	 * Cria novas datas<br>
	 * @return this
	 * 
	 */
	public static Datas novasDatas() {
		return new Datas();
	}

	/**
	 * Devolve a data do documento do boleto. (data de geração do boleto)<br>
	 * Valor padrão: data de criação do boleto
	 * 
	 * @return data de emissão do boleto
	 */
	public Calendar getDocumento() {
		if(documento == null){
			documento = Calendar.getInstance();
		}
		return this.documento;
	}

	/**
	 * Associa uma data do documento.<br>
	 * Valor padrão: data atual
	 * 
	 * @param documento data de emissão
	 * @return this
	 */
	public Datas comDocumento(Calendar documento) {
		Calendar dataLimite = Calendar.getInstance();
		dataLimite.setTime(documento.getTime());
		dataLimite.add(Calendar.DAY_OF_YEAR, RANGE_MAXIMO);
		
		if (documento.getTime().before(INIT_DATE.getTime())) {
			throw new DataLimiteUltrapassadaException("A data do documento deve ser a partir de 03/07/2000.");
		}
		//else if()
		
		this.documento = documento;
		
		return this;
	}

	/**
	 * Associa uma data do documento.<br>
	 * Valor padrão: data atual
	 * 
	 * @param dia dia de emissão
	 * @param mes mes de emissão
	 * @param ano ano de emissão
	 * @return this
	 */
	public Datas comDocumento(int dia, int mes, int ano) {
		return comDocumento(dataPara(dia, mes, ano));
	}

	/**
	 * Devolve a data de processamento do boleto. (data de geração do boleto)<br>
	 * Valor padrão: data de criação do boleto
	 * 
	 * @return data de processamento
	 */
	public Calendar getProcessamento() {
		if(processamento == null){
			processamento = Calendar.getInstance();
		}
		return this.processamento;
	}

	/**
	 * Associa uma data do processamento.<br>
	 * Valor padrão: data atual
	 * 
	 * @param processamento data de processamento
	 * @return this
	 */
	public Datas comProcessamento(Calendar processamento) {
		if (processamento.getTime().before(INIT_DATE.getTime())) {
			throw new DataLimiteUltrapassadaException("A data do documento deve ser a partir de 03/07/2000.");
		}

		this.processamento = processamento;

		return this;
	}

	/**
	 * Associa uma data do processamento.<br>
	 * Valor padrão: data atual
	 * 
	 * @param dia dia de processamento
	 * @param mes mes de processamento
	 * @param ano ano de processamento
	 * @return this
	 */
	public Datas comProcessamento(int dia, int mes, int ano) {
		return comProcessamento(dataPara(dia, mes, ano));
	}

	/**
	 * Retorna a data de vencimento do boleto
	 * @return data de vencimento
	 */
	public Calendar getVencimento() {
		if(vencimento == null){
			vencimento = Calendar.getInstance();
		}

		return this.vencimento;
	}

	/**
	 * Modifica o vencimento do respectivo boleto com um Calendar.
	 * @param vencimento data de vencimento
	 * @return this
	 */
	public Datas comVencimento(Calendar vencimento) {
		if (vencimento.getTime().before(INIT_DATE.getTime())) {
			throw new DataLimiteUltrapassadaException("A data do documento deve ser a partir de 03/07/2000.");
		}
		
		Calendar dataLimite = Calendar.getInstance();
		if(documento != null)
			dataLimite.setTime(documento.getTime());
		
		dataLimite.add(Calendar.DAY_OF_YEAR, RANGE_MAXIMO);
		
		if (vencimento.getTime().after(dataLimite.getTime())) {
			throw new DataLimiteUltrapassadaException("A data de vencimento ultrapassa o range permitido para emissão do boleto.");
		}
		
		this.vencimento = vencimento;
		
		return this;
	}

	/**
	 * Modifica o vencimento.
	 * 
	 * @param dia dia de vencimento
	 * @param mes mes de vencimento
	 * @param ano ano de vencimento
	 * @return this 
	 */
	public Datas comVencimento(int dia, int mes, int ano) {
		return comVencimento(dataPara(dia, mes, ano));
	}

	private Calendar dataPara(int dia, int mes, int ano) {
		Calendar c = Calendar.getInstance();
		c.set(ano, mes-1, dia);
		return c;
	}
}
