package br.com.caelum.stella.validation.ie;

import java.util.regex.Pattern;

import br.com.caelum.stella.DigitoGenerator;
import br.com.caelum.stella.DigitoPara;
import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;

/**
 * <p>
 * Documentação de referência:
 * </p>
 * <ul>
 * <li><a href="http://www.sefaz.al.gov.br/sintegra/cad_AC.asp">ROTEIRO DE
 * CRÍTICA DA INSCRIÇÃO ESTADUAL</a>
 * <li><a href="http://www.sintegra.gov.br/Cad_Estados/cad_AC.html">SINTEGRA -
 * ROTEIRO DE CRÍTICA DA INSCRIÇÃO ESTADUAL</a>
 * </ul>
 * 
 */
public class IEAcreValidator extends AbstractIEValidator {

	public static final Pattern FORMATED = Pattern.compile("01(\\.\\d{3}){2}\\/\\d{3}\\-\\d{2}");

	public static final Pattern UNFORMATED = Pattern.compile("01\\d{11}");

	/**
	 * Este considera, por padrão, que as cadeias estão formatadas e utiliza um
	 * {@linkplain SimpleMessageProducer} para geração de mensagens.
	 */
	public IEAcreValidator() {
		super(true);
	}

	/**
	 * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
	 * mensagens.
	 * 
	 * @param isFormatted
	 *            considerar cadeia formatada quando <code>true</code>
	 */
	public IEAcreValidator(boolean isFormatted) {
		super(isFormatted);
	}

	public IEAcreValidator(MessageProducer messageProducer, boolean isFormatted) {
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

	@Override
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
		final String ieSemDigitos = "01" + new DigitoGenerator().generate(9);
		final String ieComDigitos = ieSemDigitos + calculaDigitos(ieSemDigitos);
		if (isFormatted) {
			return super.format(ieComDigitos, "##.###.###/###-##");
		}
		return ieComDigitos;
	}
}
