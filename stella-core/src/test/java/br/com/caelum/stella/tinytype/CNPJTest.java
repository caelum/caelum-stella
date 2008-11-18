package br.com.caelum.stella.tinytype;

import junit.framework.Assert;

import org.junit.Test;


public class CNPJTest {
    
    @Test
    public void shouldAcceptValidFormattedCNPJ(){
        new CNPJ("23.121.367/0001-69");
    }
    
    @Test
    public void shouldAcceptValidUnformattedCNPJ(){
        new CNPJ("12345678901234");
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotAcceptCNPJWihtLetters(){
        new CNPJ("23.121.3a7/0001-69");
    }
    
    @Test
    public void shouldReturnFormattedStringInToStringMethod(){
        CNPJ CNPJ = new CNPJ("23121367000169");
        Assert.assertEquals("23.121.367/0001-69", CNPJ.toString());
    }
    
    @Test
    public void shouldHaveDomainDrivenEquals(){
        CNPJ formated = new CNPJ("23.121.367/0001-69");
        CNPJ unformated = new CNPJ("23121367000169");
        Assert.assertTrue(formated.equals(unformated));
        Assert.assertTrue(unformated.equals(formated));
    }

}
