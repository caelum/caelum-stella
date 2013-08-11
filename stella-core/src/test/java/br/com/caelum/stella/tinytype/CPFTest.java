package br.com.caelum.stella.tinytype;


import org.junit.Assert;
import org.junit.Test;

public class CPFTest {

    @Test
    public void shouldAcceptValidFormattedCPF() {
        new CPF("111.111.111-11");
    }

    @Test
    public void shouldAcceptValidUnformattedCPF() {
        new CPF("12345678901");
    }

    @Test
    public void shouldHaveDomainDrivenEquals() {
        CPF a = new CPF("333.333.333-33");
        CPF b = new CPF("333.333.333-33");
        Assert.assertTrue(a.equals(b));
        Assert.assertTrue(b.equals(a));
    }

}
