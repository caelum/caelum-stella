package br.com.caelum.stella.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
        String unformattedValue = "11122233344";
        String formattedValue = formatter.format(unformattedValue);
        assertEquals(formattedValue, "111.222.333-44");
    }

    @Test
    public void testUnformat() {
        String formattedValue = "111.222.333-44";
        String unformattedValue = formatter.unformat(formattedValue);
        assertEquals(unformattedValue, "11122233344");
    }

    @Test
	public void shouldDetectIfAValueIsFormattedOrNot() throws Exception {
		assertTrue(formatter.isFormatted("111.222.333-44"));
		assertFalse(formatter.isFormatted("11122233344"));
		assertFalse(formatter.isFormatted("1.1a1.1-2"));
	}

    @Test
	public void shouldDetectIfAValueCanBeFormattedOrNot() throws Exception {
    	assertFalse(formatter.canBeFormatted("111.222.333-44"));
		assertTrue(formatter.canBeFormatted("11122233344"));
		assertFalse(formatter.canBeFormatted("1.1a1.1-2"));
	}

}
