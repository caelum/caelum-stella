package br.com.caelum.stella.gateway.core;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Classe utilitaria apenas para formatar os valores que chegam das integrações do VISA.
 * 
 * @author Alberto
 * 
 */
public class BigDecimalFormatter {

	/**
	 * 
	 * @param priceInCents valor em string e em centesimos. Ex: 2050=20.50
	 * @return
	 */
	public BigDecimal stringInCentsToBigDecimal(String priceInCents) {
		return new BigDecimal(priceInCents).divide(new BigDecimal(100)).setScale(2,
				RoundingMode.HALF_EVEN);
	}
	
	public String bigDecimalToStringInCents(BigDecimal value){
		return String.format("%.0f", value.multiply(new BigDecimal(100)));
	}
	
		
}
