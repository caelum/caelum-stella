package br.com.caelum.stella.nfe.builder;

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

	public IPITrib withValorDaBaseDeCalculo(String baseDeCalculo) {
		// TODO Auto-generated method stub
		return null;
	}

	public IPITrib withAliquota(String aliquota) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param quantidadeTotal Quantidade total na unidade padrão para tributação.
	 * @return
	 */
	public IPITrib withQuantidadeTotal(String quantidadeTotal) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param valorPorUnidade o valor do imposto Pauta por unidade de medida.
	 * @return
	 */
	public IPITrib withValorPorUnidadeTributavel(String valorPorUnidade) {
		// TODO Auto-generated method stub
		return null;
	}

	public IPITrib withValorDoIPI(String valor) {
		// TODO Auto-generated method stub
		return this;
	}
}
