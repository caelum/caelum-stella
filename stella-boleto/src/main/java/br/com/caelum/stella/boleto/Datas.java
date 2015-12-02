package br.com.caelum.stella.boleto;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Bean que representa as datas relacionadas a um Boleto.
 * 
 * @author Paulo Silveira
 * @author Caue Guerra
 * @author Leonardo Bessa
 * 
 */
public class Datas implements Serializable {

	private static final long serialVersionUID = 1L;

	private LocalDate documento;
	private LocalDate processamento;
	private LocalDate vencimento;
	private static final LocalDate MINIMUM_DATE = LocalDate.of(1997, 10, 7);
	private static final LocalDate MAXIMUM_DATE = LocalDate.of(2024, 1, 1);

	private Datas() {
	}

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
	public LocalDate getDocumento() {
		if(documento == null){
			documento = LocalDate.now();
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
	public Datas comDocumento(LocalDate documento) {
		if (documento.isBefore(MINIMUM_DATE)) {
			throw new IllegalArgumentException("O ano do documento deve ser maior do que 1997.");
		}
		if (documento.isAfter(MAXIMUM_DATE)) {
			throw new IllegalArgumentException("O ano do documento deve ser menor do que 2024.");
		}
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
	public LocalDate getProcessamento() {
		if(processamento == null){
			processamento = LocalDate.now();
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
	public Datas comProcessamento(LocalDate processamento) {
		if (processamento.isBefore(MINIMUM_DATE)) {
			throw new IllegalArgumentException("O ano do processamento deve ser maior do que 1997.");
		}
		if (processamento.isAfter(MAXIMUM_DATE)) {
			throw new IllegalArgumentException("O ano do processamento deve ser menor do que 2024.");
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
	public LocalDate getVencimento() {
		if(vencimento == null){
			vencimento = LocalDate.now();
		}

		return this.vencimento;
	}

	/**
	 * Modifica o vencimento do respectivo boleto com um Calendar.
	 * @param vencimento data de vencimento
	 * @return this
	 */
	public Datas comVencimento(LocalDate vencimento) {
		if (vencimento.isBefore(MINIMUM_DATE)) {
			throw new IllegalArgumentException("O ano do vencimento deve ser maior do que 1997.");
		}
		if (vencimento.isAfter(MAXIMUM_DATE)) {
			throw new IllegalArgumentException("O ano do vencimento deve ser menor do que 2024.");
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

	private LocalDate dataPara(int dia, int mes, int ano) {
		
		return LocalDate.of(ano, mes, dia);
	}
}
