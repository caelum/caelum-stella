package br.com.caelum.stella.formatter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.validation.CNPJFormatter;
import br.com.caelum.stella.validation.Formatter;

public class CNPJFormatterTest {

    private Formatter formatter;

    @Before
    public void before() {
        formatter = new CNPJFormatter();
    }

    @Test
    public void testFormat() {
        String unfotmatedValue = "26637142000158";
        String formatedValue = formatter.format(unfotmatedValue);
        assertEquals(formatedValue, "26.637.142/0001-58");
    }

    @Test
    public void testUnformat() {
        String fotmatedValue = "26.637.142/0001-58";
        String unformatedValue = formatter.unformat(fotmatedValue);
        assertEquals(unformatedValue, "26637142000158");
    }

}
