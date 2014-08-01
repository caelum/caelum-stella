package br.com.caelum.stella.boleto.utils;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
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
	
	
	@Test
	public void deveCompletarUmaStringComZerosAEsquerdaQuandoValorForNulo() {
		String value = null;
		String result = StellaStringUtils.leftPadWithZeros(value, 5);
		assertEquals("00000", result);
	}
	
	@Test
	public void deveRetornarUmaStringPreenchidaAoInvesDeNullSemPrefixo() throws Exception {
		String value = null;
		String substitute = "123";
		String result = StellaStringUtils.prefixNotNullStringOrDefault(value, substitute, "123");
		assertThat(result, notNullValue());
		assertThat(result, is(substitute));
	}
	
	@Test
	public void naoDeveRetornarUmaStringSubstitutaQuandoValorNaoEstiverNuloComPrefixo() throws Exception {
		String value = "abc";
		String substitute = "123"; 
		String result = StellaStringUtils.prefixNotNullStringOrDefault(value, substitute, "def");
		assertThat(result, is("def"+value));
	}
	
	@Test
	public void deveRetornarUmaStringPreenchidaAoInvesDeNullSemSufixo() throws Exception {
		String value = null;
		String substitute = "123";
		String result = StellaStringUtils.suffixNotNullStringOrDefault(value, substitute, "123");
		assertThat(result, notNullValue());
		assertThat(result, is(substitute));
	}
	
	@Test
	public void naoDeveRetornarUmaStringSubstitutaQuandoValorNaoEstiverNuloComSufixo() throws Exception {
		String value = "abc";
		String substitute = "123"; 
		String result = StellaStringUtils.suffixNotNullStringOrDefault(value, substitute, "def");
		assertThat(result, is(value+"def"));
	}
}
