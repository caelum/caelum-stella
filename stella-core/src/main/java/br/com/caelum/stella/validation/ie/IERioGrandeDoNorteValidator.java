package br.com.caelum.stella.validation.ie;

import java.util.regex.Pattern;

import br.com.caelum.stella.DigitoGenerator;
import br.com.caelum.stella.DigitoPara;
import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.validation.Validator;

/**
 * <p>
 * Documentação de referência:
 * </p>
 * <a href="http://www.sintegra.gov.br/Cad_Estados/cad_RN.html"> SINTEGRA -
 * ROTEIRO DE CRÍTICA DA INSCRIÇÃO ESTADUAL </a>
 * 
 * @author Leonardo Bessa
 */
public class IERioGrandeDoNorteValidator extends AbstractIEValidator {

	public static final Pattern FORMATED = Pattern.compile("20\\.(\\d\\.)?\\d{3}\\.\\d{3}\\-\\d{1}");

	public static final Pattern UNFORMATED = Pattern.compile("20\\d{7,8}");

	/**
	 * Este considera, por padrão, que as cadeias estão formatadas e utiliza um
	 * {@linkplain SimpleMessageProducer} para geração de mensagens.
	 */
	public IERioGrandeDoNorteValidator() {
		super(true);
	}

	/**
	 * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
	 * mensagens.
	 * 
	 * @param isFormatted
	 *            considerar cadeia formatada quando <code>true</code>
	 */
	public IERioGrandeDoNorteValidator(boolean isFormatted) {
		super(isFormatted);
	}

	public IERioGrandeDoNorteValidator(MessageProducer messageProducer, boolean isFormatted) {
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
		return new DigitoPara(iESemDigito).comMultiplicadoresDeAte(2, 10).complementarAoModulo()
				.trocandoPorSeEncontrar("0", 10, 11).calcula();
	}

	/**
	 * @see Validator#generateRandomValid()
	 * @return uma inscrição estadual válida com 10 dígitos
	 */
	@Override
	public String generateRandomValid() {
		final String ieSemDigito = "20" + new DigitoGenerator().generate(7);
		final String ieComDigito = ieSemDigito + calculaDigito(ieSemDigito);
		if (isFormatted) {
			return super.format(ieComDigito, "##.#.###.###-#");
		}
		return ieComDigito;
	}
}
