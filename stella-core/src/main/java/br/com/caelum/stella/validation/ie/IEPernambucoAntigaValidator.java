package br.com.caelum.stella.validation.ie;

import java.text.ParseException;
import java.util.regex.Pattern;

import javax.swing.text.MaskFormatter;

import br.com.caelum.stella.DigitoGenerator;
import br.com.caelum.stella.DigitoPara;
import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;

class IEPernambucoAntigaValidator extends AbstractIEValidator {

    public static final Pattern FORMATED = Pattern.compile("([1][8])\\.?([1-9])\\.?(\\d{3})\\.?(\\d{7})\\-?(\\d{1})");

    public static final Pattern UNFORMATED = Pattern.compile("([1][8])([1-9])(\\d{3})(\\d{7})(\\d{1})");
	
    /**
	 * Este considera, por padrão, que as cadeias estão formatadas e utiliza um
	 * {@linkplain SimpleMessageProducer} para geração de mensagens.
	 */
	public IEPernambucoAntigaValidator() {
		super(true);
	}

	/**
	 * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
	 * mensagens.
	 * 
	 * @param isFormatted
	 *            considerar cadeia formatada quando <code>true</code>
	 */
	public IEPernambucoAntigaValidator(boolean isFormatted) {
		super(isFormatted);
	}

	public IEPernambucoAntigaValidator(MessageProducer messageProducer, boolean isFormatted) {
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
		return new DigitoPara(iESemDigito + "0").comMultiplicadoresDeAte(1, 9).complementarAoModulo()
						.trocandoPorSeEncontrar("0", 10).trocandoPorSeEncontrar("1", 11).calcula();
	}

	private String formata(String valor) {
		try {
			final MaskFormatter formatador = new MaskFormatter("##.#.###.#######-#");
			formatador.setValidCharacters("1234567890");
			formatador.setValueContainsLiteralCharacters(false);
			return formatador.valueToString(valor);
		} catch (ParseException e) {
			throw new RuntimeException("Valor gerado não bate com o padrão: " + valor, e);
		}
	}

	@Override
	public String generateRandomValid() {
		final String ieSemDigito = "18" + new DigitoGenerator().generate(11);
		final String ieComDigito = ieSemDigito + calculaDigito(ieSemDigito);
		if (isFormatted) {
			return formata(ieComDigito);
		}
		return ieComDigito;
	}
}
