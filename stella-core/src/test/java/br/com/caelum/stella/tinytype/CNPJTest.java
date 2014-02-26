package br.com.caelum.stella.tinytype;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CNPJTest {

    @Test
    public void shouldAcceptValidFormattedCNPJ() {
        CNPJ cnpj = new CNPJ("23.121.367/0001-69");
		assertEquals("23121367000169", cnpj.getNumero());
		assertEquals("23.121.367/0001-69", cnpj.getNumeroFormatado());
    }

    @Test
    public void shouldAcceptValidUnformattedCNPJ() {
        CNPJ cnpj = new CNPJ("23121367000169");
		assertEquals("23121367000169", cnpj.getNumero());
		assertEquals("23.121.367/0001-69", cnpj.getNumeroFormatado());
    }

    @Test
	public void shouldAcceptInvalidCNPJ() throws Exception {
    	CNPJ cnpj = new CNPJ("12.345.678/9012-34");
		assertEquals("12345678901234", cnpj.getNumero());
		assertEquals("12.345.678/9012-34", cnpj.getNumeroFormatado());

		cnpj = new CNPJ("12.3w5.678/9012-34");
		assertEquals("12.3w5.678/9012-34", cnpj.getNumero());
		assertEquals("12.3w5.678/9012-34", cnpj.getNumeroFormatado());

		cnpj = new CNPJ("12.3453.678/9012-34");
		assertEquals("12.3453.678/9012-34", cnpj.getNumero());
		assertEquals("12.3453.678/9012-34", cnpj.getNumeroFormatado());

		cnpj = new CNPJ("12.345.8/9012-34");
		assertEquals("12.345.8/9012-34", cnpj.getNumero());
		assertEquals("12.345.8/9012-34", cnpj.getNumeroFormatado());
	}

    @Test
	public void shouldReturnIfIsValid() throws Exception {
        CNPJ cnpjValido = new CNPJ("23.121.367/0001-69");
    	CNPJ cnpjInvalido = new CNPJ("12.345.678/9012-34");

    	assertTrue(cnpjValido.isValid());
    	assertFalse(cnpjInvalido.isValid());
	}

    @Test
    public void shouldHaveDomainDrivenEquals() {
        CNPJ a = new CNPJ("23.121.367/0001-69");
        CNPJ b = new CNPJ("23.121.367/0001-69");
        assertTrue(a.equals(b));
        assertTrue(b.equals(a));
    }

}
