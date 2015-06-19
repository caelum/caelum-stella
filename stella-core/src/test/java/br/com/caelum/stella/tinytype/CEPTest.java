package br.com.caelum.stella.tinytype;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Edenir Norberto Anschau
 *
 */
public class CEPTest {

    @Test
    public void shouldAcceptValidFormattedCEP() {
        CEP cep = new CEP("12345-678");
        assertEquals("12345678", cep.getNumero());
        assertEquals("12345-678", cep.getNumeroFormatado());
    }

    @Test
    public void shouldAcceptValidUnformattedCEP() {
        CEP cep = new CEP("12345678");
        assertEquals("12345678", cep.getNumero());
        assertEquals("12345-678", cep.getNumeroFormatado());
    }

    @Test
    public void shouldAcceptInvalidCEP() {
        CEP cep = new CEP("12345-678");
        assertEquals("12345678", cep.getNumero());

        cep = new CEP("12345-a78");
        assertEquals("12345-a78", cep.getNumero());
        assertEquals("12345-a78", cep.getNumeroFormatado());

        cep = new CEP("12345-678");
        assertEquals("12345678", cep.getNumero());
        assertEquals("12345-678", cep.getNumeroFormatado());

        cep = new CEP("1234-678");
        assertEquals("1234-678", cep.getNumero());
        assertEquals("1234-678", cep.getNumeroFormatado());
    }

    @Test
    public void shouldHaveDomainDrivenEquals() {
        CEP a = new CEP("12345-678");
        CEP b = new CEP("12345-678");
        assertTrue(a.equals(b));
        assertTrue(b.equals(a));
    }
    
}