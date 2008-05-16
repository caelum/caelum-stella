package br.com.caelum.stella.boleto;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * Bean que representa os dados de um boleto.
 * 
 * @author Paulo Silveira
 * @author Caue Guerra
 * 
 */
public class Boleto {

	private String valorBoleto;

	private String qtdMoeda;
	private String valorMoeda;
	private String especieMoeda;
	private int codEspecieMoeda;

	private String especieDocumento;
	private String noDocumento;
	private String aceite;

	private Banco banco;
	private Datas datas;
	private Sacado sacado;
	private Emissor emissor;
	private List<String> instrucoes;
	private List<String> descricoes;
	private List<String> locaisDePagamento;

	private Boleto() {
	}

	/**
	 * Cria um novo boleto com valores padrão.
	 * 
	 */
	public static Boleto newBoleto() {
		return new Boleto().comEspecieMoeda("R$").comCodEspecieMoeda(9)
				.comAceite("N").comEspecieDocumento("DV");
	}

	/**
	 * Devolve o aceite do boleto Valor padrão: 'N'
	 * 
	 * @return
	 */
	public String getAceite() {
		return this.aceite;
	}

	/**
	 * Associa o aceite ao boleto. Valor padrão: 'N'
	 * 
	 * @param aceite
	 */
	public Boleto comAceite(String aceite) {
		this.aceite = aceite;
		return this;
	}

	public Datas getDatas() {
		return this.datas;
	}

	public Boleto comDatas(Datas datas) {
		this.datas = datas;
		return this;
	}

	public String getEspecieDocumento() {
		return this.especieDocumento;
	}

	/**
	 * Associa a espécie do documento ao boleto Valor padrão: "DV"
	 * 
	 * @param especieDocumento
	 */
	public Boleto comEspecieDocumento(String especieDocumento) {
		this.especieDocumento = especieDocumento;
		return this;
	}

	public String getNoDocumento() {
		return this.noDocumento;
	}

	/**
	 * Associa o número do documento ao boleto Código informado pelo banco.
	 * 
	 * @param noDocumento
	 */
	public Boleto comNoDocumento(String noDocumento) {
		this.noDocumento = noDocumento;
		return this;
	}

	public String getQtdMoeda() {
		return this.qtdMoeda;
	}

	public Boleto comQtdMoeda(String qtdMoeda) {
		this.qtdMoeda = qtdMoeda;
		return this;
	}

	public String getValorBoleto() {
		return this.valorBoleto;
	}

	public Boleto comValorBoleto(String valorBoleto) {
		this.valorBoleto = valorBoleto;
		return this;
	}

	public String getEspecieMoeda() {
		return this.especieMoeda;
	}

	private Boleto comEspecieMoeda(String especieMoeda) {
		this.especieMoeda = especieMoeda;
		return this;
	}

	public int getCodEspecieMoeda() {
		return this.codEspecieMoeda;
	}

	private Boleto comCodEspecieMoeda(int codEspecieMoeda) {
		this.codEspecieMoeda = codEspecieMoeda;
		return this;
	}

	public String getValorMoeda() {
		return this.valorMoeda;
	}

	public Boleto comValorMoeda(String valorMoeda) {
		this.valorMoeda = valorMoeda;
		return this;
	}

	public Banco getBanco() {
		return this.banco;
	}

	public Boleto comBanco(Banco banco) {
		this.banco = banco;
		return this;
	}

	public Sacado getSacado() {
		return this.sacado;
	}

	public Boleto comSacado(Sacado sacado) {
		this.sacado = sacado;
		return this;
	}

	public Emissor getEmissor() {
		return this.emissor;
	}

	public Boleto comEmissor(Emissor emissor) {
		this.emissor = emissor;
		return this;
	}

	public List<String> getInstrucoes() {
		return this.instrucoes;
	}

	public Boleto comInstrucoes(String... instrucoes) {
		if (instrucoes.length > 5)
			throw new IllegalArgumentException(
					"maximo de 5 instrucoes permitidas");
		this.instrucoes = Arrays.asList(instrucoes);
		return this;
	}

	/**
	 * Devolve as descrições do boleto. Note que esse campo não aparece no
	 * boleto gerado em PNG
	 * 
	 * @return
	 */
	public List<String> getDescricoes() {
		return this.descricoes;
	}

	/**
	 * Associa as descrições ao boleto. Note que esse campo não aparece no
	 * boleto gerado em PNG
	 * 
	 * @return
	 */
	public Boleto comDescricoes(String... descricoes) {
		if (descricoes.length > 5)
			throw new IllegalArgumentException(
					"maximo de 5 descricoes permitidas");
		this.descricoes = Arrays.asList(descricoes);
		return this;
	}

	public List<String> getLocaisDePagamento() {
		return this.locaisDePagamento;
	}

	public Boleto comLocaisDePagamento(String... locaisDePagamento) {
		if (locaisDePagamento.length > 2)
			throw new IllegalArgumentException(
					"maximo de 2 locais de pagamento permitidos");
		this.locaisDePagamento = Arrays.asList(locaisDePagamento);
		return this;
	}

	/**
	 * Devolve o fator de vencimento do boleto. Utilizado para geração do código
	 * de barras e da linha digitável
	 * 
	 * @return
	 */
	public int getFatorVencimento() {
		Calendar dataBase = Calendar.getInstance();
		dataBase.set(Calendar.DAY_OF_MONTH, 7);
		dataBase.set(Calendar.MONTH, 10 - 1);
		dataBase.set(Calendar.YEAR, 1997);
		dataBase.set(Calendar.HOUR_OF_DAY, 0);
		dataBase.set(Calendar.MINUTE, 0);
		dataBase.set(Calendar.SECOND, 0);
		dataBase.set(Calendar.MILLISECOND, 0);

		long diferencasEmMiliSegundos = this.datas.getVencimento()
				.getTimeInMillis()
				- dataBase.getTimeInMillis();
		long diferencasEmDias = diferencasEmMiliSegundos
				/ (1000 * 60 * 60 * 24);

		return (int) diferencasEmDias;
	}

	public String getValorFormatado() {
		String formatado = this.valorBoleto.replaceAll("[^0-9]", "");
		return String.format("%010d", Integer.parseInt(formatado));
	}

	public String getNoDocumentoFormatado() {
		return String.format("%04d", Integer.parseInt(this.noDocumento));
	}
}
