package br.com.caelum.stella.boleto.bancos.gerador;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GeradorDeDigitoBradescoTest {

	private final GeradorDeDigitoBradesco gerador = new GeradorDeDigitoBradesco();

	@Test
	public void deveCalcularDigitoConformeExemploDoManual() {
		// carteira 19 + nosso número 00000000002: soma 69, resto 3, dígito 8
		assertEquals("8", gerador.calculaDVNossoNumero("19", "2"));
	}

	@Test
	public void deveRetornarPQuandoRestoForUm() {
		// carteira 19 + nosso número 00000000001: soma 67, resto 1
		assertEquals("P", gerador.calculaDVNossoNumero("19", "1"));
	}

	@Test
	public void deveRetornarZeroQuandoRestoForZero() {
		// carteira 19 + nosso número 00000000006: soma 77, resto 0
		assertEquals("0", gerador.calculaDVNossoNumero("19", "6"));
	}

	@Test
	public void deveCompletarCarteiraENossoNumeroComZerosAEsquerda() {
		assertEquals(gerador.calculaDVNossoNumero("19", "2"),
				gerador.calculaDVNossoNumero("19", "00000000002"));
	}
}
