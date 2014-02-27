package br.com.caelum.stella.boleto.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StellaStringUtilsTest {

	@Test
	public void deveCompletarUmaStringComZerosAEsquerda() {
		String value = "123";
		String result = StellaStringUtils.leftPadWithZeros(value, 5);
		assertEquals("00123", result);
	}
	
	@Test
	public void naoDeveApendarNadaSeOtamanhoJaEhCerto() {
		String value = "12345";
		String result = StellaStringUtils.leftPadWithZeros(value, 5);
		assertEquals("12345", result);
	}
	
	@Test
	public void naoDeveApendarNadaSeOtamanhoEhMenorQueAString() {
		String value = "12345";
		String result = StellaStringUtils.leftPadWithZeros(value, 4);
		assertEquals("12345", result);
	}
	
	
	

}
