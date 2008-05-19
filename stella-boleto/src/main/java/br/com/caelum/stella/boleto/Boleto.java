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
	private boolean aceite;

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
		return new Boleto().withEspecieMoeda("R$").withCodEspecieMoeda(9)
				.withAceite(false).withEspecieDocumento("DV");
	}

	/**
	 * Devolve o aceite do boleto Valor padrão: 'N'
	 * 
	 * @return
	 */
	public boolean getAceite() {
		return this.aceite;
	}

	/**
	 * Associa o aceite ao boleto. Valor padrão: 'N'
	 * 
	 * @param aceite
	 */
	public Boleto withAceite(boolean aceite) {
		this.aceite = aceite;
		return this;
	}

	public Datas getDatas() {
		return this.datas;
	}

	public Boleto withDatas(Datas datas) {
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
	public Boleto withEspecieDocumento(String especieDocumento) {
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
	public Boleto withNoDocumento(String noDocumento) {
		this.noDocumento = noDocumento;
		return this;
	}

	public String getQtdMoeda() {
		return this.qtdMoeda;
	}

	public Boleto withQtdMoeda(String qtdMoeda) {
		this.qtdMoeda = qtdMoeda;
		return this;
	}

	public String getValorBoleto() {
		return this.valorBoleto;
	}

	public Boleto withValorBoleto(String valorBoleto) {
		this.valorBoleto = valorBoleto;
		return this;
	}

	public String getEspecieMoeda() {
		return this.especieMoeda;
	}

	private Boleto withEspecieMoeda(String especieMoeda) {
		this.especieMoeda = especieMoeda;
		return this;
	}

	public int getCodEspecieMoeda() {
		return this.codEspecieMoeda;
	}

	private Boleto withCodEspecieMoeda(int codEspecieMoeda) {
		this.codEspecieMoeda = codEspecieMoeda;
		return this;
	}

	public String getValorMoeda() {
		return this.valorMoeda;
	}

	public Boleto withValorMoeda(String valorMoeda) {
		this.valorMoeda = valorMoeda;
		return this;
	}

	public Banco getBanco() {
		return this.banco;
	}

	public Boleto withBanco(Banco banco) {
		this.banco = banco;
		return this;
	}

	public Sacado getSacado() {
		return this.sacado;
	}

	public Boleto withSacado(Sacado sacado) {
		this.sacado = sacado;
		return this;
	}

	public Emissor getEmissor() {
		return this.emissor;
	}

	public Boleto withEmissor(Emissor emissor) {
		this.emissor = emissor;
		return this;
	}

	public List<String> getInstrucoes() {
		return this.instrucoes;
	}

	public Boleto withInstrucoes(String... instrucoes) {
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
	public Boleto withDescricoes(String... descricoes) {
		if (descricoes.length > 5)
			throw new IllegalArgumentException(
					"maximo de 5 descricoes permitidas");
		this.descricoes = Arrays.asList(descricoes);
		return this;
	}

	public List<String> getLocaisDePagamento() {
		return this.locaisDePagamento;
	}

	public Boleto withLocaisDePagamento(String... locaisDePagamento) {
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

		Calendar vencimentoSemHoras = Calendar.getInstance();
		vencimentoSemHoras.set(Calendar.DAY_OF_MONTH, this.datas
				.getVencimento().get(Calendar.DAY_OF_MONTH));
		vencimentoSemHoras.set(Calendar.MONTH, this.datas.getVencimento().get(
				Calendar.MONTH));
		vencimentoSemHoras.set(Calendar.YEAR, this.datas.getVencimento().get(
				Calendar.YEAR));
		vencimentoSemHoras.set(Calendar.HOUR_OF_DAY, 0);
		vencimentoSemHoras.set(Calendar.MINUTE, 0);
		vencimentoSemHoras.set(Calendar.SECOND, 0);
		vencimentoSemHoras.set(Calendar.MILLISECOND, 0);

		long diferencasEmMiliSegundos = vencimentoSemHoras.getTimeInMillis()
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
