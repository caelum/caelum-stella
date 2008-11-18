package br.com.caelum.stella.tinytype;

import junit.framework.Assert;

import org.junit.Test;


public class CPFTest {
    
    @Test
    public void shouldAcceptValidFormattedCPF(){
        new CPF("111.111.111-11");
    }
    
    @Test
    public void shouldAcceptValidUnformattedCPF(){
        new CPF("12345678901");
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotAcceptCPFWihtLetters(){
        new CPF("11111a1111");
    }
    
    @Test
    public void shouldReturnFormattedStringInToStringMethod(){
        CPF cpf = new CPF("22222222222");
        Assert.assertEquals("222.222.222-22", cpf.toString());
    }
    
    @Test
    public void shouldHaveDomainDrivenEquals(){
        CPF formated = new CPF("333.333.333-33");
        CPF unformated = new CPF("33333333333");
        Assert.assertTrue(formated.equals(unformated));
        Assert.assertTrue(unformated.equals(formated));
    }

}
