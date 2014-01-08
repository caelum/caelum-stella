package br.com.caelum.stella.tinytype;

import org.junit.Assert;
import org.junit.Test;

public class CPFTest {

	@Test
	public void shouldAcceptValidFormattedCPF() {
		CPF cpf = new CPF("111.111.111-11");
		Assert.assertEquals("11111111111", cpf.getNumero());
		Assert.assertEquals("111.111.111-11", cpf.getNumeroFormatado());
	}

	@Test
	public void shouldAcceptValidUnformattedCPF() {
		CPF cpf = new CPF("11144477735");
		Assert.assertEquals("11144477735", cpf.getNumero());
		Assert.assertEquals("111.444.777-35", cpf.getNumeroFormatado());
	}

	@Test
	public void shouldAcceptInvalidCPF() {
		CPF cpf = new CPF("843.843.131-84");
		Assert.assertEquals("84384313184", cpf.getNumero());
		Assert.assertEquals("843.843.131-84", cpf.getNumeroFormatado());
	}
	
	@Test
	public void shouldReturnIfIsValid() throws Exception {
		CPF cpfValido = new CPF("111.444.777-35");
		CPF cpfInvalido = new CPF("843.843.131-85");

		Assert.assertTrue(cpfValido.isValido());
		Assert.assertFalse(cpfInvalido.isValido());
	}

	@Test
	public void shouldHaveDomainDrivenEquals() {
		CPF a = new CPF("333.333.333-33");
		CPF b = new CPF("333.333.333-33");
		Assert.assertTrue(a.equals(b));
		Assert.assertTrue(b.equals(a));
	}
	
}
