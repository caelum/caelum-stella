package br.com.caelum.stella.gateway.bb;

import br.com.caelum.stella.gateway.core.DefinedByCode;

public enum BBSituacao implements DefinedByCode{

	PAGAMENTO_EFETUADO("00"),PAGAMENTO_NAO_AUTORIZADO("01"),ERRO_NO_PROCESSAMENTO_DA_CONSULTA("02"),
	PAGAMENTO_NAO_LOCALIZADO("03"),CAMPO_IDCONV_INVALIDO_OU_NULO("10"),
	VALOR_INFORMADO_E_INVALIDO_NULO_OU_NAO_CONFERE_COM_O_REGISTRADO("11");
	
	private String codigo;

	private BBSituacao(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		// TODO Auto-generated method stub
		return codigo;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return codigo;
	}
	
	
	
	
}
