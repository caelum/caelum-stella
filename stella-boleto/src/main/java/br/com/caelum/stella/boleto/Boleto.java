package br.com.caelum.stella.boleto;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import br.com.caelum.stella.boleto.exception.CriacaoBoletoException;

/**
 * Bean que representa os dados de um boleto.
 * 
 * @author Paulo Silveira
 * @author Caue Guerra
 * 
 */
public class Boleto {

	private BigDecimal valorBoleto;
	private BigDecimal quantidadeMoeda;
	private BigDecimal valorMoeda;
	private String especieMoeda;
	private int codigoEspecieMoeda;
	private String especieDocumento;
	private String numeroDocumento;
	private boolean aceite;
	private Banco banco;
	private Datas datas;
	private Sacado sacado;
	private Emissor emissor;
	private List<String> instrucoes = Collections.emptyList();
	private List<String> descricoes = Collections.emptyList();
	private List<String> locaisDePagamento = Collections.emptyList();

	private Boleto() {}

	/**
	 * @return novo Boleto com valores default de especieMoeda R$,
	 * código de espécie moeda 9 (real), aceite false e espécie DV
	 */
	public static Boleto novoBoleto() {
		return new Boleto().comEspecieMoeda("R$")
			.comCodigoEspecieMoeda(9)
			.comAceite(false).comEspecieDocumento("DV");
	}

	/**
	 * @return aceite do boleto que por default sempre é false
	 */
	public boolean getAceite() {
		return this.aceite;
	}

	/**
	 * @param aceite que será associado ao boleto
	 * @return este boleto
	 */
	public Boleto comAceite(boolean aceite) {
		this.aceite = aceite;
		return this;
	}

	/**
	 * @return datas do boleto 
	 * @see br.com.caelum.stella.boleto.Datas.java
	 */
	public Datas getDatas() {
		return this.datas;
	}

	/**
	 * @param datas que serão associadas ao boleto
	 * @return este boleto
	 */
	public Boleto comDatas(Datas datas) {
		this.datas = datas;
		return this;
	}

	/**
	 * @return espécie do documento do boleto que por default sempre é "DV"
	 */
	public String getEspecieDocumento() {
		return this.especieDocumento;
	}

	/**
	 * @param especieDocumento que será associado ao boleto.
	 * @return este boleto
	 */
	public Boleto comEspecieDocumento(String especieDocumento) {
		this.especieDocumento = especieDocumento;
		return this;
	}

	/**
	 * @return número do documento. Código informado pelo banco
	 */
	public String getNumeroDoDocumento() {
		return this.numeroDocumento;
	}

	/**
	 * @param numeroDocumento que será associado ao boleto
	 * @return este boleto
	 */
	public Boleto comNumeroDoDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
		return this;
	}

	/**
	 * @return quantidade da moeda
	 */
	public BigDecimal getQuantidadeDeMoeda() {
		return this.quantidadeMoeda;
	}

	/**
	 * @param quantidadeMoeda que será associada ao boleto
	 * @return este boleto
	 */
	public Boleto comQuantidadeMoeda(BigDecimal quantidadeMoeda) {
		this.quantidadeMoeda = quantidadeMoeda;
		return this;
	}

	/**
	 * @return valor desse boleto
	 */
	public BigDecimal getValorBoleto() {
		return this.valorBoleto;
	}

	/**
	 * @param valor em double que após ser convertido pra String 
	 * será associado ao boleto @see Boleto#comValorBoleto(String)
	 */

	public Boleto comValorBoleto(double valor) {
		return comValorBoleto(Double.toString(valor));
	}

	/**
	 * @param valor String que é convertido para BigDecimal com
	 * o Locale da JVM @see Boleto#comValorBoleto(BigDecimal)
	 */
	public Boleto comValorBoleto(String valor) {
		return comValorBoleto(new BigDecimal(valor));

	}

	/**
	 * @param valor que será associado ao boleto
	 * @return este boleto
	 */
	public Boleto comValorBoleto(BigDecimal valor) {
		this.valorBoleto = valor;
		return this;
	}

	/**
	 * @return espécie da moeda que por default é "R$"
	 */
	public String getEspecieMoeda() {
		return this.especieMoeda;
	}

	/**
	 * @param especieMoeda que será associada ao boleto
	 * @return este boleto
	 */
	private Boleto comEspecieMoeda(String especieMoeda) {
		this.especieMoeda = especieMoeda;
		return this;
	}

	/**
	 * @return código da espécie da moeda que por default é "9" (real)
	 */
	public int getCodigoEspecieMoeda() {
		return this.codigoEspecieMoeda;
	}

	/**
	 * @param codigoEspecieMoeda que será associado ao boleto
	 * @return este boleto
	 */
	private Boleto comCodigoEspecieMoeda(int codigoEspecieMoeda) {
		this.codigoEspecieMoeda = codigoEspecieMoeda;
		return this;
	}

	/**
	 * @return valor da moeda
	 */
	public BigDecimal getValorMoeda() {
		return this.valorMoeda;
	}

	/**
	 * @param valorMoeda que será associado ao boleto
	 */
	public Boleto comValorMoeda(BigDecimal valorMoeda) {
		this.valorMoeda = valorMoeda;
		return this;
	}

	/**
	 * @return banco do boleto
	 */
	public Banco getBanco() {
		return this.banco;
	}

	/**
	 * @param banco que será associado ao boleto
	 * @return este boleto
	 */
	public Boleto comBanco(Banco banco) {
		this.banco = banco;
		return this;
	}

	/**
	 * @return sacado do banco
	 */
	public Sacado getSacado() {
		return this.sacado;
	}

	/**
	 * @param sacado que será associado ao boleto
	 * @return este boleto
	 */
	public Boleto comSacado(Sacado sacado) {
		this.sacado = sacado;
		return this;
	}

	/**
	 * @return emissor do boleto
	 */
	public Emissor getEmissor() {
		return this.emissor;
	}

	/**
	 * @param emissor que será associado ao boleto
	 * @return este boleto
	 */
	public Boleto comEmissor(Emissor emissor) {
		this.emissor = emissor;
		return this;
	}

	/**
	 * @return lista de instruções do boleto
	 */
	public List<String> getInstrucoes() {
		return this.instrucoes;
	}

	/**
	 * @param instrucoes que serão associadas ao boleto (limite de 5)
	 * @throws IllegalArgumentException caso tenha mais de 5 instruções
	 * @return este boleto
	 */
	public Boleto comInstrucoes(String... instrucoes) {
		if (instrucoes.length > 5) {
			throw new IllegalArgumentException("maximo de 5 instrucoes permitidas");
		}
		this.instrucoes = Arrays.asList(instrucoes);
		return this;
	}

	/**
	 * @return lista de descrições do boleto. <br>
	 * Note que esse campo não aparece no boleto gerado em PNG
	 */
	public List<String> getDescricoes() {
		return this.descricoes;
	}

	/**
	 * @param descricoes que serão asociadas ao boleto (limite de 5)
	 * <br> Note que esse campo não aparece no boleto gerado em PNG
	 * @throws IllegalArgumentException caso tenha mais de 5 descrições
	 * @return este boleto
	 */
	public Boleto comDescricoes(String... descricoes) {
		if (descricoes.length > 5) {
			throw new IllegalArgumentException("maximo de 5 descricoes permitidas");
		}
		this.descricoes = Arrays.asList(descricoes);
		return this;
	}

	/**
	 * @return lista de locais de pagamento do boleto
	 */
	public List<String> getLocaisDePagamento() {
		return this.locaisDePagamento;
	}

	/**
	 * @param locaisDePagamento que serão associados ao boleto (limite de 2 locais)
	 * @throws IllegalArgumentException tiver mais de 2 locais de pagamento
	 * @return este boleto
	 */
	public Boleto comLocaisDePagamento(String... locaisDePagamento) {
		if (locaisDePagamento.length > 2) {
			throw new IllegalArgumentException("maximo de 2 locais de pagamento permitidos");
		}
		this.locaisDePagamento = Arrays.asList(locaisDePagamento);
		return this;
	}

	/**
	 * @return fator de vencimento do boleto. Utilizado para geração do código de barras
	 */
	public String getFatorVencimento() {
		Calendar dataBase = Calendar.getInstance();
		dataBase.set(Calendar.DAY_OF_MONTH, 7);
		dataBase.set(Calendar.MONTH, 10 - 1);
		dataBase.set(Calendar.YEAR, 1997);
		dataBase.set(Calendar.HOUR_OF_DAY, 0);
		dataBase.set(Calendar.MINUTE, 0);
		dataBase.set(Calendar.SECOND, 0);
		dataBase.set(Calendar.MILLISECOND, 0);

		Calendar vencimentoSemHoras = Calendar.getInstance();

		vencimentoSemHoras.set(Calendar.DAY_OF_MONTH, this.datas.getVencimento().get(Calendar.DAY_OF_MONTH));
		vencimentoSemHoras.set(Calendar.MONTH, this.datas.getVencimento().get(Calendar.MONTH));
		vencimentoSemHoras.set(Calendar.YEAR, this.datas.getVencimento().get(Calendar.YEAR));
		vencimentoSemHoras.set(Calendar.HOUR_OF_DAY, 0);
		vencimentoSemHoras.set(Calendar.MINUTE, 0);
		vencimentoSemHoras.set(Calendar.SECOND, 0);
		vencimentoSemHoras.set(Calendar.MILLISECOND, 0);

		long diferencasEmMiliSegundos = vencimentoSemHoras.getTimeInMillis() - dataBase.getTimeInMillis();
		long diferencasEmDias = diferencasEmMiliSegundos / (1000 * 60 * 60 * 24);

		if (diferencasEmDias > 9999) {
			throw new CriacaoBoletoException("Data fora do formato aceito!");
		}

		return String.valueOf((int) diferencasEmDias);
	}

	/**
	 * @return valor do boleto formatado (com 10 digitos)
	 */
	public String getValorFormatado() {
		return String.format("%011.2f", this.valorBoleto).replaceAll("[^0-9]", "");
	}

	/**
	 * @return número do documento formatado (com 4 digitos)
	 */
	public String getNumeroDoDocumentoFormatado() {
		return String.format("%04d", new Integer(this.numeroDocumento));
	}
	
	/**
	 * @return agencia e codigo cedente (conta corrente) do banco
	 */
	public String getAgenciaECodigoCedente() {
		return this.banco.getAgenciaECodigoCedente(this.emissor);
	}

	/**
	 * @return nosso numero e codigo do documento para boleto
	 */
	public String getNossoNumeroECodDocumento() {
		return banco.getNossoNumeroECodDocumento(this.emissor);
	}
}
