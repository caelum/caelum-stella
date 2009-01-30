package br.com.caelum.stella.nfe.builder;

import java.math.BigDecimal;

public interface II {

	II withValorBaseCalculo(BigDecimal valorBaseCalculo);

	/**
	 * Entendem-se como despesas aduaneiras, além das referentes aos valores dos
	 * imposto federais, aquelas efetivamente pagas à repartição alfandegária
	 * até o momento do desembaraço das mercadorias, tais como: diferença do
	 * peso, classificação fiscal, multas por infrações.
	 * 
	 * @param valorAduaneira
	 * 
	 * @return
	 */
	II withValorAduaneira(BigDecimal valorAduaneira);

	/**
	 * @param valorII
	 *            valor do imposto de importacao
	 * @return
	 */
	II withValorII(BigDecimal valorII);

	/**
	 * @param valorIOF
	 *            valor do imposto de opercaoes financeiras
	 * @return
	 */
	II withValorIOF(BigDecimal valorIOF);

}
