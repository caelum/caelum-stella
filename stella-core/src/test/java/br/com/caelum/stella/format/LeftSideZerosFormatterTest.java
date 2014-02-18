package br.com.caelum.stella.format;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class LeftSideZerosFormatterTest {

	private Formatter formatter;

	@Before
	public void setUp() throws Exception {
		formatter = new LeftSideZerosFormatter(14);
	}

    @Test
    public void testFormat() {
        String actual = formatter.format("1234567890");
        assertEquals("00001234567890", actual);
    }

    @Test
    public void testUnformat() {
        String actual = formatter.unformat("000567890");
        assertEquals("567890", actual);
    }

    @Test
	public void shouldVerifyIfAValueIsAlreadyFormattedOrNot() throws Exception {
		assertTrue(formatter.isFormatted("00001234567890"));
		assertFalse(formatter.isFormatted("00001234"));
		assertFalse(formatter.isFormatted("1234567890"));
		assertFalse(formatter.isFormatted("123456789012345"));
	}

    @Test
	public void shouldVerifyIfAValueCanBeFormattedOrNot() throws Exception {
		assertTrue(formatter.canBeFormatted("00001234567890"));
		assertTrue(formatter.canBeFormatted("00001234"));
		assertTrue(formatter.canBeFormatted("1234567890"));
		assertFalse(formatter.canBeFormatted("123456789012345"));
		assertFalse(formatter.canBeFormatted("abc123"));
	}
}
