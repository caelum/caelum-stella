package br.com.caelum.stella.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.formatter.CNPJFormatter;
import br.com.caelum.stella.formatter.Formatter;

public class CNPJFormatterTest {

	private Formatter formatter;

	@Before
	public void before() {
		formatter = new CNPJFormatter();
	}


	@Test
	public void shouldUnformatValueThatMatchesFormattedPattern() {
		String value = "26.637.142/0001-58";
		String result = null;
		result = formatter.unformat(value);
		assertEquals("26637142000158", result);
	}

	@Test
	public void shouldFormatValueThatMatchesUnformattedPattern() {
		String value = "26637142000158";
		String result = null;
		result = formatter.format(value);
		assertEquals("26.637.142/0001-58", result);
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
