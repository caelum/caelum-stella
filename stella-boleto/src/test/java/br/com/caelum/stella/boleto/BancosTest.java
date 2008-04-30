package br.com.caelum.stella.boleto;

import static org.junit.Assert.*;

import org.junit.Test;

public class BancosTest {

	@Test
	public void testGetNumeroFormatado() {
		for(Bancos b : Bancos.values()) {
			assertEquals(b.getNumero(), Integer.parseInt(b.getNumeroFormatado()));
			
		}
	}

	@Test
	public void testGetImage() {
		for(Bancos b : Bancos.values()) {
			assertNotNull(b.getImage());
		}
	}

}
