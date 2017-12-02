package br.com.caelum.stella.validation.ie;

import java.util.regex.Pattern;

import br.com.caelum.stella.DigitoGenerator;
import br.com.caelum.stella.DigitoPara;
import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;

class IEPernambucoNovaValidator extends AbstractIEValidator {

	// 0321418-40
	public static final Pattern FORMATED = Pattern.compile("(\\d{7})[-](\\d{2})");

	public static final Pattern UNFORMATED = Pattern.compile("(\\d{7})(\\d{2})");

	/**
	 * Este considera, por padrão, que as cadeias estão formatadas e utiliza um
	 * {@linkplain SimpleMessageProducer} para geração de mensagens.
	 */
	public IEPernambucoNovaValidator() {
		super(true);
	}

	/**
	 * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
	 * mensagens.
	 * 
	 * @param isFormatted
	 *            considerar cadeia formatada quando <code>true</code>
	 */
	public IEPernambucoNovaValidator(boolean isFormatted) {
		super(isFormatted);
	}

	public IEPernambucoNovaValidator(MessageProducer messageProducer, boolean isFormatted) {
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
		String iESemDigito = unformattedIE.substring(0, unformattedIE.length() - 2);
		String digitos = unformattedIE.substring(unformattedIE.length() - 2);
		String digitosCalculados = calculaDigitos(iESemDigito);

		return digitos.equals(digitosCalculados);
	}

	private String calculaDigitos(String iESemDigito) {
		DigitoPara digitoPara = new DigitoPara(iESemDigito);
		digitoPara.complementarAoModulo().trocandoPorSeEncontrar("0", 10, 11);

		String digito1 = digitoPara.calcula();
		digitoPara.addDigito(digito1);
		String digito2 = digitoPara.calcula();

		return digito1 + digito2;
	}

	@Override
	public String generateRandomValid() {
		final String ieSemDigitos = new DigitoGenerator().generate(7);
		final String ieComDigitos = ieSemDigitos + calculaDigitos(ieSemDigitos);
		if (isFormatted) {
			return super.format(ieComDigitos, "#######-##");
		}
		return ieComDigitos;
	}
}
