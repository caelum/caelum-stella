package br.com.caelum.stella.formatter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.formatter.CPFFormatter;
import br.com.caelum.stella.formatter.Formatter;

public class CPFFormatterTest {

	private Formatter formatter;

	@Before
	public void before() {
		formatter = new CPFFormatter();
	}

	@Test
	public void shouldUnformatValueThatMatchesFormattedPattern() {
		String value = "123.789.456-20";
		String result = null;
		result = formatter.unformat(value);
		assertEquals("12378945620", result);
	}

	@Test
	public void shouldFormatValueThatMatchesUnformattedPattern() {
		String value = "12378945620";
		String result = null;
		result = formatter.format(value);
		assertEquals("123.789.456-20", result);
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
