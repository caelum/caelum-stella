package br.com.caelum.stella.inwords;

import java.util.Locale;

/**
 * Representa o formato para números utilizando a moeda de acordo com o país
 * passado por parâmetro.
 *
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
public class FormatoDeMoeda implements FormatoDeExtenso {
	private final FormatoDeExtenso formato;

	public FormatoDeMoeda(Locale locale) {
		if (Locale.US.equals(locale)) {
			formato = new FormatoDeDolar();
		} else if (Messages.LOCALE_PT_BR.equals(locale)){
			formato = new FormatoDeReal();
		} else {
			String pais = locale.getDisplayCountry(Messages.LOCALE_PT_BR);

			throw new IllegalArgumentException("Não foi possível determinar a moeda para o país " + pais);
		}
	}

	@Override
	public String getUnidadeDecimalNoSingular() {
		return formato.getUnidadeDecimalNoSingular();
	}

	@Override
	public String getUnidadeDecimalNoPlural() {
		return formato.getUnidadeDecimalNoPlural();
	}

	@Override
	public String getUnidadeInteiraNoSingular() {
		return formato.getUnidadeInteiraNoSingular();
	}

	@Override
	public String getUnidadeInteiraNoPlural() {
		return formato.getUnidadeInteiraNoPlural();
	}

	@Override
	public int getCasasDecimais() {
		return formato.getCasasDecimais();
	}
}
