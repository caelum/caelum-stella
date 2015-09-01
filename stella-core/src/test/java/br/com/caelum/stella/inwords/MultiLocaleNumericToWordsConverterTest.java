package br.com.caelum.stella.inwords;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Locale;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
public class MultiLocaleNumericToWordsConverterTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void supportMultipleCountriesWithSameLanguageWhenConvertingToWords() throws Exception {
	    Locale[] locales = new Locale[] { Locale.ENGLISH, Locale.CANADA, Locale.US, Locale.UK };

	    for (Locale locale : locales) {
	    	NumericToWordsConverter converter = new NumericToWordsConverter(new InteiroSemFormato(), locale);

	    	String result = converter.toWords(13L);

	    	assertThat(result, is("thirteen"));
		}
	}

	@Test
	public void throwExceptionWhenConvertingToWordsWithUnsupportedLanguage() throws Exception {
    	NumericToWordsConverter converter = new NumericToWordsConverter(new InteiroSemFormato(), Locale.JAPAN);

    	thrown.expect(UnsupportedOperationException.class);
    	thrown.expectMessage(is("Não é possivel converter números para o idioma japonês"));

    	converter.toWords(13L);
	}

	@Test
	public void useBrazilianLocaleWhenConvertingToWordsWithoutLocale() throws Exception {
		Locale defaultLocale = Locale.getDefault();
        Locale.setDefault(new Locale("en", "US"));

        try {
			NumericToWordsConverter converter = new NumericToWordsConverter(new InteiroSemFormato());

	    	String result = converter.toWords(13L);

	    	assertThat(result, is("treze"));
        } finally {
        	Locale.setDefault(defaultLocale);
        }
	}
}
