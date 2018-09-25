package br.com.caelum.stella.validation.ie;

import java.text.ParseException;
import java.util.regex.Pattern;

import javax.swing.text.MaskFormatter;

import br.com.caelum.stella.DigitoGenerator;
import br.com.caelum.stella.DigitoPara;
import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;

public class IERoraimaValidator extends AbstractIEValidator {

	public static final Pattern FORMATED = Pattern.compile("24\\d{6}\\-\\d{1}");

	public static final Pattern UNFORMATED = Pattern.compile("24\\d{7}");

	/**
	 * Este considera, por padrão, que as cadeias estão formatadas e utiliza um
	 * {@linkplain SimpleMessageProducer} para geração de mensagens.
	 */
	public IERoraimaValidator() {
		super(true);
	}

	/**
	 * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
	 * mensagens.
	 * 
	 * @param isFormatted
	 *            considerar cadeia formatada quando <code>true</code>
	 */
	public IERoraimaValidator(boolean isFormatted) {
		super(isFormatted);
	}

	public IERoraimaValidator(MessageProducer messageProducer, boolean isFormatted) {
		super(messageProducer, isFormatted);
	}

	@Override
	protected Pattern getUnformattedPattern() {
		return UNFORMATED;
	}

	@Override
	protected Pattern getFormattedPattern() {
		return FORMATED;
	}

	protected boolean hasValidCheckDigits(String unformattedIE) {
		String iESemDigito = unformattedIE.substring(0, unformattedIE.length() - 1);
		String digito = unformattedIE.substring(unformattedIE.length() - 1);
		String digitoCalculado = calculaDigito(iESemDigito);

		return digito.equals(digitoCalculado);
	}

	private String calculaDigito(String iESemDigito) {
		return new DigitoPara(iESemDigito).comMultiplicadores(8, 7, 6, 5, 4, 3, 2, 1).mod(9).calcula();
	}

	@Override
	public String generateRandomValid() {
		final String ieSemDigito = "24" + new DigitoGenerator().generate(6);
		final String ieComDigito = ieSemDigito + calculaDigito(ieSemDigito);
		if (isFormatted) {
			return super.format(ieComDigito, "########-#");
		}
		return ieComDigito;
	}
}
