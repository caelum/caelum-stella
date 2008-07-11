package br.com.caelum.stella.inwords;

/**
 * Transforma números representados por algarismos em números na forma por extenso.
 * 
 * @author Victor Santos
 * @author Leonardo Bessa
 */
public interface NumericCardinalToWordsConverter {
	
	/**
	 * Transforma número em sua represntação por extenso.
	 * @param number número a ser transformado
	 * @return número por extenso
	 */
	public String toWords(double number);
	
}