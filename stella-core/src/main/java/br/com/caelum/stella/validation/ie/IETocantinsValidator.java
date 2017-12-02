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
 * <a href="http://www.sintegra.gov.br/Cad_Estados/cad_TO.html">SINTEGRA -
 * ROTEIRO DE CRÍTICA DA INSCRIÇÃO ESTADUAL </a> <br>
 * <a href="http://www2.sefaz.to.gov.br/Servicos/Sintegra/calinse.htm"> ESTADO
 * DO TOCANTINS SECRETARIA DA FAZENDA ASSESSORIA DE MODERNIZAÇÃO E
 * INFORMAÇÃO</a>
 * 
 * @author Leonardo Bessa
 * 
 */
public class IETocantinsValidator extends AbstractIEValidator {

	public static final Pattern FORMATED = Pattern.compile("\\d{2}(.\\d{2}.)?(\\.)?\\d{3}\\.\\d{3}\\-\\d{1}");

	public static final Pattern UNFORMATED = Pattern.compile("(\\d{9}|\\d{11})");

	/**
	 * Este considera, por padrão, que as cadeias estão formatadas e utiliza um
	 * {@linkplain SimpleMessageProducer} para geração de mensagens.
	 */
	public IETocantinsValidator() {
		super(true);
	}

	/**
	 * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
	 * mensagens.
	 * 
	 * @param isFormatted
	 *            considerar cadeia formatada quando <code>true</code>
	 */
	public IETocantinsValidator(boolean isFormatted) {
		super(isFormatted);
	}

	public IETocantinsValidator(MessageProducer messageProducer, boolean isFormatted) {
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

		if (iESemDigito.length() == 10) {
			iESemDigito = removeCaracteresIgnorados(iESemDigito);
		}

		String digitoCalculado = calculaDigito(iESemDigito);
		return digito.equals(digitoCalculado);
	}

	private String removeCaracteresIgnorados(String iESemDigito) {
		return iESemDigito.substring(0, 2) + iESemDigito.substring(4);
	}

	private String calculaDigito(String iESemDigito) {
		return new DigitoPara(iESemDigito).complementarAoModulo().trocandoPorSeEncontrar("0", 10, 11).calcula();
	}

	/**
	 * @see Validator#generateRandomValid()
	 * @return uma inscrição estadual válida com 9 dígitos
	 */
	@Override
	public String generateRandomValid() {
		final String ieSemDigito = new DigitoGenerator().generate(8);
		final String ieComDigito = ieSemDigito + calculaDigito(ieSemDigito);
		if (isFormatted) {
			return format(ieComDigito, "##.###.###-#");
		}
		return ieComDigito;
	}
}
