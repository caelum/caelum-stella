package br.com.caelum.stella.gateway.redecard;

/**
 * Especifica a forma como vai ser o parcelamento
 * @author Alberto Pc
 *
 */
public enum TipoTransacao {

	A_VISTA("04"),PARCELADO_EMISSOR("06"),PARCELADO_ESTABELECIMENTO("08");
	
	private String codigo;

	private TipoTransacao(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}
	
	
}
