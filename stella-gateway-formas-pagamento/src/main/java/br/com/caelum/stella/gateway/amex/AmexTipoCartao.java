package br.com.caelum.stella.gateway.amex;

import br.com.caelum.stella.gateway.core.DefinedByCode;
/**
 * 
 * @author Alberto Souza
 *
 */
public enum AmexTipoCartao implements DefinedByCode {

	AMERICA_EXPRESS("AE"), AMERICA_EXPRESS_CORPORATE_PURCHASE__CARD("AP"), BANK_CARD(
			"BC"), BRAND_X("BX"), BRAND_Y("BY"), DINERS_CLUB("DC"), GAP_INC_CARD(
			"GC"), GENERIC_CARD("XX"), JCB_CARD("JC"), LOYALTY_CARD("LY"), MASTER_CARD(
			"MC"), MONDEX_CARD("MX"), PLC_CARD("PL"), SAFE_DEBIT_CARD("SD"), SOLO_CARD(
			"SO"), STYLE_CARD("ST"), SWITCH_CARD("SW"), VISA_DEBIT_CARD("VD"), VISA_CARD(
			"VC"), VISA_CORPORATE_PURCHASE_CARD("VP"), ELETRONIC_BENEFITS_CARD(
			"EB");

	private String codigo;

	private AmexTipoCartao(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return codigo;
	}

}
