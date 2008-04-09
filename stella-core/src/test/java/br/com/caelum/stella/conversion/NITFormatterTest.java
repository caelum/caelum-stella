package br.com.caelum.stella.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.formatter.Formatter;
import br.com.caelum.stella.formatter.NITFormatter;

public class NITFormatterTest {

	private Formatter formatter;

	@Before
	public void before() {
		formatter = new NITFormatter();
	}

	@Test
	public void shouldUnformatValueThatMatchesFormattedPattern() {
		String value = "123.45678.91-9";
		String result = null;
		result = formatter.unformat(value);
		assertEquals("12345678919", result);
	}

	@Test
	public void shouldFormatValueThatMatchesUnformattedPattern() {
		String value = "12345678919";
		String result = null;
		result = formatter.format(value);
		assertEquals("123.45678.91-9", result);
	}

	@Test
	public void shouldNotUnformatNullValue() {
		String value = null;
		String result = null;
		try {
			result = formatter.unformat(value);
			fail();
		} catch (IllegalArgumentException e) {
		} catch (Exception exception) {
			fail();
		}
		assertTrue(result == null);
	}

	@Test
	public void shouldNotFormatNullValue() {
		String value = null;
		String result = null;
		try {
			result = formatter.format(value);
			fail();
		} catch (IllegalArgumentException e) {
		} catch (Exception exception) {
			fail();
		}
		assertTrue(result == null);
	}

}
