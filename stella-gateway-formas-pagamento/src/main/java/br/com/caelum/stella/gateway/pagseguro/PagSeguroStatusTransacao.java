package br.com.caelum.stella.gateway.pagseguro;

import br.com.caelum.stella.gateway.core.DefinedByCode;

public enum PagSeguroStatusTransacao implements DefinedByCode{

	COMPLETO("COMPLETO"), AGUARDANDO_PAGAMENTO("AGUARDANDO PAGTO"), APROVADO(
			"APROVADO"), EM_ANALISE("EM ANALISE"), CANCELADO("CANCELADO");

	private String codigo;

	private PagSeguroStatusTransacao(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
