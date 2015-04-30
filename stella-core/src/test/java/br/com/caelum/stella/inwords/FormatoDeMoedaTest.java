package br.com.caelum.stella.inwords;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Locale;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
public class FormatoDeMoedaTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void useDolarWhenCreatingFormatoDeMoedaForLocaleUS() throws Exception {
		FormatoDeMoeda formato = new FormatoDeMoeda(Locale.US);

		assertThat(formato.getUnidadeDecimalNoSingular(), is("cent"));
		assertThat(formato.getUnidadeDecimalNoPlural(), is("cents"));
		assertThat(formato.getUnidadeInteiraNoSingular(), is("dollar"));
		assertThat(formato.getUnidadeInteiraNoPlural(), is("dollars"));
		assertThat(formato.getCasasDecimais(), is(2));
	}

	@Test
	public void useRealWhenCreatingFormatoDeMoedaForLocalePT_BR() throws Exception {
		FormatoDeMoeda formato = new FormatoDeMoeda(Messages.LOCALE_PT_BR);

		assertThat(formato.getUnidadeDecimalNoSingular(), is("centavo"));
		assertThat(formato.getUnidadeDecimalNoPlural(), is("centavos"));
		assertThat(formato.getUnidadeInteiraNoSingular(), is("real"));
		assertThat(formato.getUnidadeInteiraNoPlural(), is("reais"));
		assertThat(formato.getCasasDecimais(), is(2));
	}

	@Test
	public void throwExceptionWhenCreatingFormatoDeMoedaForUnknownLocale() throws Exception {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage(is("Não foi possível determinar a moeda para o país Japão"));

		new FormatoDeMoeda(Locale.JAPAN);
	}
}
