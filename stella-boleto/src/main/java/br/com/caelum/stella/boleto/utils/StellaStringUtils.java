package br.com.caelum.stella.boleto.utils;

public class StellaStringUtils {
	
	private static final String ZERO = "0";
	
	public static String lefPadWithZeros(String input, int expectedSize){
		StringBuilder sb = new StringBuilder(expectedSize);
		
		for (int i = expectedSize - input.length(); i>0; i-- ){
			sb.append(ZERO);
		}
		
		sb.append(input);
		return sb.toString();
	}
}
