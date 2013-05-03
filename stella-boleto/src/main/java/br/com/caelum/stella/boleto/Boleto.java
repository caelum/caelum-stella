package br.com.caelum.stella.boleto;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;

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

	private Boleto() {
	}

	/**
	 * Cria um novo boleto com valores padrão.
	 * 
	 */
	public static Boleto novoBoleto() {
		return new Boleto().comEspecieMoeda("R$").comCodigoEspecieMoeda(9).comAceite(false)
				.comEspecieDocumento("DV");
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
	public Boleto comAceite(boolean aceite) {
		this.aceite = aceite;
		return this;
	}

	/**
	 * Devolve as datas do boleto
	 * 
	 * @return
	 */
	public Datas getDatas() {
		return this.datas;
	}

	/**
	 * Associa datas ao boleto
	 * 
	 * @param datas
	 * 
	 */
	public Boleto comDatas(Datas datas) {
		this.datas = datas;
		return this;
	}

	/**
	 * Devolve a espécie do documento do boleto. Valor padrão: "DV"
	 * 
	 * @return
	 */
	public String getEspecieDocumento() {
		return this.especieDocumento;
	}

	/**
	 * Associa a espécie do documento ao boleto. Valor padrão: "DV"
	 * 
	 * @param especieDocumento
	 */
	public Boleto comEspecieDocumento(String especieDocumento) {
		this.especieDocumento = especieDocumento;
		return this;
	}

	/**
	 * Devolve o número do documento. Código informado pelo banco.
	 * 
	 * @return
	 */
	public String getNumeroDoDocumento() {
		return this.numeroDocumento;
	}

	/**
	 * Associa o número do documento ao boleto Código informado pelo banco.
	 * 
	 * @param noDocumento
	 */
	public Boleto comNumeroDoDocumento(String noDocumento) {
		this.numeroDocumento = noDocumento;
		return this;
	}

	/**
	 * Devolve a quantidade da moeda
	 * 
	 * @return
	 */
	public BigDecimal getQuantidadeDeMoeda() {
		return this.quantidadeMoeda;
	}

	/**
	 * Associa a quantidade de moeda ao boleto
	 * 
	 * @param quantidadeMoeda
	 * @return
	 */
	public Boleto comQuantidadeMoeda(BigDecimal quantidadeMoeda) {
		this.quantidadeMoeda = quantidadeMoeda;
		return this;
	}

	/**
	 * Devolve o valor desse boleto
	 */
	public BigDecimal getValorBoleto() {
		return this.valorBoleto;
	}

	/**
	 * Associa um valor ao boleto, convertendo o double em string para evitar o
	 * bug de casa decimal
	 * 
	 * @see Boleto#comValorBoleto(String)
	 * @param valorBoleto
	 * @return
	 */

	public Boleto comValorBoleto(double valorBoleto) {
		return comValorBoleto(Double.toString(valorBoleto));
	}

	/**
	 * Associa um valor ao boleto, convertendo a String para BigDecimal
	 * utilizando o Locale da JVM
	 * 
	 * @see Boleto#comValorBoleto(BigDecimal)
	 * @param valorBoleto
	 * @return
	 */
	public Boleto comValorBoleto(String valorBoleto) {
		return comValorBoleto(new BigDecimal(valorBoleto));

	}

	/**
	 * Associa um valor ao boleto
	 * 
	 * @param valorBoleto
	 * @return
	 */
	public Boleto comValorBoleto(BigDecimal valorBoleto) {
		this.valorBoleto = valorBoleto;
		return this;
	}

	/**
	 * Devolve a espécie da moeda. Valor padrão: "R$"
	 * 
	 * @return
	 */
	public String getEspecieMoeda() {
		return this.especieMoeda;
	}

	/**
	 * Associa uma espécie de moeda ao boleto. Valor padrão: "R$"
	 * 
	 * @param especieMoeda
	 * @return
	 */
	private Boleto comEspecieMoeda(String especieMoeda) {
		this.especieMoeda = especieMoeda;
		return this;
	}

	/**
	 * Devolve o código da espécie da moeda. Valor padrão: '9' (para R$)
	 * 
	 * @return
	 */
	public int getCodigoEspecieMoeda() {
		return this.codigoEspecieMoeda;
	}

	/**
	 * Associa um código da espécie da moeda ao boleto. Valor padrão: '9' (para
	 * R$)
	 * 
	 * @param codEspecieMoeda
	 * @return
	 */
	private Boleto comCodigoEspecieMoeda(int codEspecieMoeda) {
		this.codigoEspecieMoeda = codEspecieMoeda;
		return this;
	}

	/**
	 * Devolve o valor da moeda, format
	 * 
	 * @return
	 */
	public BigDecimal getValorMoeda() {
		return this.valorMoeda;
	}

	/**
	 * Associa um valor de moeda ao boleto
	 * 
	 */
	public Boleto comValorMoeda(BigDecimal valorMoeda) {
		this.valorMoeda = valorMoeda;
		return this;
	}

	/**
	 * Devolve o banco do boleto
	 * 
	 * @return
	 */
	public Banco getBanco() {
		return this.banco;
	}

	/**
	 * Associa um banco ao boleto
	 * 
	 * @param banco
	 * @return
	 */
	public Boleto comBanco(Banco banco) {
		this.banco = banco;
		return this;
	}

	/**
	 * Devolve o sacado do banco
	 * 
	 * @return
	 */
	public Sacado getSacado() {
		return this.sacado;
	}

	/**
	 * Associa um sacado ao banco
	 * 
	 * @param sacado
	 * @return
	 */
	public Boleto comSacado(Sacado sacado) {
		this.sacado = sacado;
		return this;
	}

	/**
	 * Devolve o emissor do boleto
	 * 
	 * @return
	 */
	public Emissor getEmissor() {
		return this.emissor;
	}

	/**
	 * Associa um sacado ao boleto
	 * 
	 * @param emissor
	 * @return
	 */
	public Boleto comEmissor(Emissor emissor) {
		this.emissor = emissor;
		return this;
	}

	/**
	 * Devolve as instruções do boleto
	 * 
	 * @return
	 */
	public List<String> getInstrucoes() {
		return this.instrucoes;
	}

	/**
	 * Associa instruções ao boleto.
	 * 
	 * @param instrucoes
	 *            . Limite de 5 valores
	 * @return
	 * 
	 * @throws IllegalArgumentException
	 *             instruções tiver mais de 5 elementos
	 * 
	 */
	public Boleto comInstrucoes(String... instrucoes) {
		if (instrucoes.length > 5) {
			throw new IllegalArgumentException("maximo de 5 instrucoes permitidas");
		}
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
	 * @param descricoes
	 *            . Limite de 5 valores
	 * @return
	 * 
	 * @throws IllegalArgumentException
	 *             descricoes tiver mais de 5 elementos
	 */
	public Boleto comDescricoes(String... descricoes) {
		if (descricoes.length > 5) {
			throw new IllegalArgumentException("maximo de 5 descricoes permitidas");
		}
		this.descricoes = Arrays.asList(descricoes);
		return this;
	}

	/**
	 * Devolve os locais de pagamento do boleto
	 * 
	 * @return
	 */
	public List<String> getLocaisDePagamento() {
		return this.locaisDePagamento;
	}

	/**
	 * Associa locais de pagamento ao boleto
	 * 
	 * @param locaisDePagamento
	 *            . Limite de 2 valores
	 * @return
	 * 
	 * @throws IllegalArgumentException
	 *             locaisDePagamento tiver mais de 2 elementos
	 */
	public Boleto comLocaisDePagamento(String... locaisDePagamento) {
		if (locaisDePagamento.length > 2) {
			throw new IllegalArgumentException("maximo de 2 locais de pagamento permitidos");
		}
		this.locaisDePagamento = Arrays.asList(locaisDePagamento);
		return this;
	}

	/**
	 * Devolve o fator de vencimento do boleto. Utilizado para geração do código
	 * de barras e da linha digitável
	 * 
	 * @return
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
	 * Devolve o valor do boleto formatado (com 10 digitos)
	 * 
	 * @return
	 */
	public String getValorFormatado() {
		return String.format("%011.2f", this.valorBoleto).replaceAll("[^0-9]", "");
	}

	/**
	 * Devolve o número do documento formatado (com 4 digitos)
	 * 
	 * @return
	 */
	public String getNumeroDoDocumentoFormatado() {
		return StringUtils.leftPad(this.numeroDocumento, 4, '0');
	}

	public String getAgenciaECodigoCedente() {
		return this.banco.getAgenciaECodigoCedente(this.emissor);
	}

	public String getNossoNumeroECodDocumento() {
		return banco.getNossoNumeroECodDocumento(this.emissor);
	}
}
