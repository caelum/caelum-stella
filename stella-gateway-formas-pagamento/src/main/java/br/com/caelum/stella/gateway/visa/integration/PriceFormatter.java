package br.com.caelum.stella.gateway.visa.integration;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Classe utilitaria apenas para formatar que chegam das integrações.
 * 
 * @author Alberto Pc
 * 
 */
public class PriceFormatter {

	public static BigDecimal convertToNormalValue(String priceInCents) {
		return new BigDecimal(priceInCents).divide(new BigDecimal(100)).setScale(2,
				RoundingMode.HALF_EVEN);
	}
		
}
