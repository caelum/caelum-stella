package br.com.caelum.stella.nfe.builder;

import java.math.BigDecimal;

public class IPITrib {

	private IPITrib() {
	}

	public static IPITrib create() {
		return new IPITrib();
	}

	public IPITrib withSituacaoTribuaria(SituacaoTributaria situacao) {
		// TODO Auto-generated method stub
		return this;
	}

	public IPITrib withValorDaBaseDeCalculo(BigDecimal baseDeCalculo) {
		// TODO Auto-generated method stub
		return null;
	}

	public IPITrib withAliquota(BigDecimal aliquota) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param quantidadeTotal
	 *            Quantidade total na unidade padrão para tributação.
	 * @return
	 */
	public IPITrib withQuantidadeTotal(BigDecimal quantidadeTotal) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param valorPorUnidade
	 *            o valor do imposto Pauta por unidade de medida.
	 * @return
	 */
	public IPITrib withValorPorUnidadeTributavel(BigDecimal valorPorUnidade) {
		// TODO Auto-generated method stub
		return null;
	}

	public IPITrib withValorDoIPI(BigDecimal valor) {
		// TODO Auto-generated method stub
		return this;
	}
}
