package br.com.caelum.stella.gateway.visa.integration;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Classe utilitaria apenas para formatar os valores que chegam das integrações do VISA.
 * 
 * @author Alberto
 * 
 */
public class VISAPriceFormatter {

	public static BigDecimal convertToNormalValue(String priceInCents) {
		return new BigDecimal(priceInCents).divide(new BigDecimal(100)).setScale(2,
				RoundingMode.HALF_EVEN);
	}
	
		
}
