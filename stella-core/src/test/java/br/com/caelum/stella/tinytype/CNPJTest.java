package br.com.caelum.stella.tinytype;


import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CNPJTest {

    @Test
    public void shouldAcceptValidFormattedCNPJ() {
        new CNPJ("23.121.367/0001-69");
    }

    @Test
    public void shouldAcceptValidUnformattedCNPJ() {
        new CNPJ("12345678901234");
    }

    @Test
    public void shouldHaveDomainDrivenEquals() {
        CNPJ a = new CNPJ("23.121.367/0001-69");
        CNPJ b = new CNPJ("23.121.367/0001-69");
        assertTrue(a.equals(b));
        assertTrue(b.equals(a));
    }

}
