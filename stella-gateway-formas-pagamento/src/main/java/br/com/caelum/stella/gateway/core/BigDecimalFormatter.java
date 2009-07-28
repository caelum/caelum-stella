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

	public final static int SCALE = 2;
	public final static RoundingMode ROUNDING_MODE = RoundingMode.HALF_EVEN;
	/**
	 * 
	 * @param priceInCents valor em string e em centesimos. Ex: 2050=20.50
	 * @return
	 */
	public BigDecimal stringInCentsToBigDecimal(String priceInCents) {	
		return new BigDecimal(priceInCents).divide(new BigDecimal(100)).setScale(SCALE,
				ROUNDING_MODE);
	}
	
	public String bigDecimalToStringInCents(BigDecimal value){
		return String.format("%.0f", value.multiply(new BigDecimal(100)));
	}
	
	/**
	 * 
	 * @param valor
	 * @return retorna o BigDecimal normalizado com scale=2 e RoundingMode=HALF_EVEN
	 */
	public BigDecimal normalizaBigDecimal(BigDecimal valor){
		return valor.setScale(SCALE,ROUNDING_MODE);
	}
		
}
