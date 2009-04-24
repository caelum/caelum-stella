package br.com.caelum.stella.gateway.pagseguro;

import br.com.caelum.stella.gateway.core.DefinedByCode;

public enum PagSeguroTipoPagamento implements DefinedByCode{

	PAG_SEGURO("PAGAMENTO"),CARTAO_CREDITO("CARTAO DE CREDITO"),BOLETO("BOLETO"),PAGAMENTO_ONLINE("PAGAMENTO ONLINE");
	
	private String codigo;
	
	private PagSeguroTipoPagamento(String codigo){
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
