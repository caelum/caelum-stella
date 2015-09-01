package br.com.caelum.stella.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.format.CEPFormatter;
import br.com.caelum.stella.format.Formatter;

public class CEPFormatterTest {

    private Formatter formatter;

    @Before
    public void before() {
        formatter = new CEPFormatter();
    }

    @Test
    public void testFormat() {
        String unfotmatedValue = "12345678";
        String formatedValue = formatter.format(unfotmatedValue);
        assertEquals(formatedValue, "12345-678");
    }

    @Test
    public void testUnformat() {
        String unfotmatedValue = "12345-678";
        String formatedValue = formatter.unformat(unfotmatedValue);
        assertEquals(formatedValue, "12345678");
    }

    @Test
    public void shouldVerifyIfAValueIsFormattedOrNot() throws Exception {
        assertTrue(formatter.isFormatted("12345-678"));
        assertFalse(formatter.isFormatted("12345678"));
        assertFalse(formatter.isFormatted("12345-67a"));
    }

    @Test
    public void shouldVerifyIfAValueCanBeFormattedOrNot() throws Exception {
        assertFalse(formatter.canBeFormatted("12345-678"));
        assertTrue(formatter.canBeFormatted("12345678"));
        assertFalse(formatter.canBeFormatted("12345-678"));
    }

    @Test
    public void testShoudNotThrowExceptionIfAlreadyUnformated() {
        String fotmatedValue = "12345678";
        String unformatedValue = formatter.unformat(fotmatedValue);
        assertEquals(unformatedValue, "12345678");
    }

}