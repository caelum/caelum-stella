package br.com.caelum.stella.formatter;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.format.CPFFormatter;
import br.com.caelum.stella.format.Formatter;

public class CPFFormatterTest {

    private Formatter formatter;

    @Before
    public void before() {
        formatter = new CPFFormatter();
    }

    @Test
    public void testFormat() {
        String unfotmatedValue = "11122233344";
        String formatedValue = formatter.format(unfotmatedValue);
        assertEquals(formatedValue, "111.222.333-44");
    }

    @Test
    public void testUnformat() {
        String fotmatedValue = "111.222.333-44";
        String unformatedValue = formatter.unformat(fotmatedValue);
        assertEquals(unformatedValue, "11122233344");
    }

}
