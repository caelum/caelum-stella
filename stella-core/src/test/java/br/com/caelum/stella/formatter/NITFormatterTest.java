package br.com.caelum.stella.formatter;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.format.Formatter;
import br.com.caelum.stella.format.NITFormatter;

public class NITFormatterTest {

    private Formatter formatter;

    @Before
    public void before() {
        formatter = new NITFormatter();
    }

    @Test
    public void testFormat() {
        String unfotmatedValue = "17033259504";
        String formatedValue = formatter.format(unfotmatedValue);
        assertEquals(formatedValue, "170.33259.50-4");
    }

    @Test
    public void testUnformat() {
        String fotmatedValue = "170.33259.50-4";
        String unformatedValue = formatter.unformat(fotmatedValue);
        assertEquals(unformatedValue, "17033259504");
    }

}
