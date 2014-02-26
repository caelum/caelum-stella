package br.com.caelum.stella.tinytype;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CPFTest {

	@Test
	public void shouldAcceptValidFormattedCPF() {
		CPF cpf = new CPF("111.111.111-11");
		assertEquals("11111111111", cpf.getNumero());
		assertEquals("111.111.111-11", cpf.getNumeroFormatado());
	}

	@Test
	public void shouldAcceptValidUnformattedCPF() {
		CPF cpf = new CPF("11144477735");
		assertEquals("11144477735", cpf.getNumero());
		assertEquals("111.444.777-35", cpf.getNumeroFormatado());
	}

	@Test
	public void shouldAcceptInvalidCPF() {
		CPF cpf = new CPF("843.843.131-84");
		assertEquals("84384313184", cpf.getNumero());

		cpf = new CPF("111.111.1a1-11");
		assertEquals("111.111.1a1-11", cpf.getNumero());
		assertEquals("111.111.1a1-11", cpf.getNumeroFormatado());

		cpf = new CPF("111.1111.111-11");
		assertEquals("111.1111.111-11", cpf.getNumero());
		assertEquals("111.1111.111-11", cpf.getNumeroFormatado());

		cpf = new CPF("111.1.111-11");
		assertEquals("111.1.111-11", cpf.getNumero());
		assertEquals("111.1.111-11", cpf.getNumeroFormatado());
	}

	@Test
	public void shouldReturnIfIsValid() throws Exception {
		CPF cpfValido = new CPF("111.444.777-35");
		CPF cpfInvalido = new CPF("843.843.131-85");

		assertTrue(cpfValido.isValido());
		assertFalse(cpfInvalido.isValido());
	}

	@Test
	public void shouldHaveDomainDrivenEquals() {
		CPF a = new CPF("333.333.333-33");
		CPF b = new CPF("333.333.333-33");
		assertTrue(a.equals(b));
		assertTrue(b.equals(a));
	}

}
