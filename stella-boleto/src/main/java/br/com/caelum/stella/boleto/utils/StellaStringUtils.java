package br.com.caelum.stella.boleto.utils;

public class StellaStringUtils {
	
	private static final String ZERO = "0";
	
	public static String leftPadWithZeros(String input, int expectedSize){
		if( input == null ) {
			return leftPadWithZeros("", expectedSize);
		}
		
		StringBuilder sb = new StringBuilder(expectedSize);
		
		for (int i = expectedSize - input.length(); i>0; i-- ){
			sb.append(ZERO);
		}
		
		sb.append(input);
		return sb.toString();
	}
	
	/**
	 * Método para auxiliar a verificação de String nula e adicionar um prefixo caso não seja.
	 * @param str Campo desejado para fazer a verificação.
	 * @param defaultStr Caso a str for nula, esse campo será usado no lugar. 
	 * @param prefix Adicionar um prefixo apenas se a str não for nula.
	 * @return string tratada
	 */
	public static String prefixNotNullStringOrDefault (String str, String defaultStr, String prefix) {
		if ( str == null) {
			return defaultStr;
		}
		return prefix + str;
	}
	
	/**
	 * Método para auxiliar a verificação de String nula e adicionar um prefixo caso não seja.
	 * @param str Campo desejado para fazer a verificação.
	 * @param defaultStr Caso a str for nula, esse campo será usado no lugar. 
	 * @param suffix Adicionar um sufixo apenas se a str não for nula.
	 * @return string tratada
	 */
	public static String suffixNotNullStringOrDefault (String str, String defaultStr, String suffix) {
		if ( str == null) {
			return defaultStr;
		}
		return str + suffix;
	}
}
