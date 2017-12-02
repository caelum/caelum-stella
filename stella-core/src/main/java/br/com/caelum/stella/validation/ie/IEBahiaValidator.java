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
 * <a href="http://www.pfe.fazenda.sp.gov.br/consist_ie.shtm">Secretaria da
 * Fazenda do Estado de São Paulo</a>
 * <a href="http://www.sintegra.gov.br/Cad_Estados/cad_BA.html">SINTEGRA -
 * ROTEIRO DE CRÍTICA DA INSCRIÇÃO ESTADUAL </a>
 * 
 */
public class IEBahiaValidator extends AbstractIEValidator {

	/*
	 * 612345-57
	 * 
	 * 123456-63
	 */
	public static final Pattern FORMATED = Pattern.compile("(\\d{6,7}-\\d{2})|(\\d{2,3}\\.\\d{3}\\.\\d{3})");

	public static final Pattern UNFORMATED = Pattern.compile("\\d{8,9}");

	/**
	 * Este considera, por padrão, que as cadeias estão formatadas e utiliza um
	 * {@linkplain SimpleMessageProducer} para geração de mensagens.
	 */
	public IEBahiaValidator() {
		super(true);
	}

	/**
	 * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
	 * mensagens.
	 * 
	 * @param isFormatted
	 *            considerar cadeia formatada quando <code>true</code>
	 */
	public IEBahiaValidator(boolean isFormatted) {
		super(isFormatted);
	}

	public IEBahiaValidator(MessageProducer messageProducer, boolean isFormatted) {
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

		String digitosCalculados = calculaDigito(iESemDigito);

		return digitos.equals(digitosCalculados);
	}

	private String calculaDigito(String iESemDigito) {
		DigitoPara digitoPara = new DigitoPara(iESemDigito);
		digitoPara.complementarAoModulo().trocandoPorSeEncontrar("0", 10, 11);

		char charToCheck;
		if (iESemDigito.length() == 6) {
			charToCheck = iESemDigito.charAt(0);
		} else {
			charToCheck = iESemDigito.charAt(1);
		}

		switch (charToCheck) {
		case '6':
		case '7':
		case '9':
			digitoPara.mod(11);
			break;
		default:
			digitoPara.mod(10);
		}

		String digito2 = digitoPara.calcula();
		digitoPara.addDigito(digito2);
		String digito1 = digitoPara.calcula();

		return digito1 + digito2;
	}

	/**
	 * Gera uma inscrição estadual com 8 dígitos
	 * 
	 * @see Validator#generateRandomValid()
	 * @return uma inscrição estadual aleatória válida
	 */
	@Override
	public String generateRandomValid() {
		final String ieSemDigitos = new DigitoGenerator().generate(6);
		final String ieComDigitos = ieSemDigitos + calculaDigito(ieSemDigitos);
		if (isFormatted) {
			return super.format(ieComDigitos, "######-##");
		}
		return ieComDigitos;
	}
}
