package br.com.caelum.stella.validation.ie;

import java.util.Random;
import java.util.regex.Pattern;

import br.com.caelum.stella.DigitoGenerator;
import br.com.caelum.stella.DigitoPara;
import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;

/**
 * <p>
 * Documentação de referência:
 * </p>
 * <a href="http://www.pfe.fazenda.sp.gov.br/consist_ie.shtm">Secretaria da
 * Fazenda do Estado de São Paulo</a>
 * <a href="http://www.sintegra.gov.br/Cad_Estados/cad_GO.html">SINTEGRA -
 * ROTEIRO DE CRÍTICA DA INSCRIÇÃO ESTADUAL </a>
 * 
 * @author Leonardo Bessa
 * 
 */
public class IEGoiasValidator extends AbstractIEValidator {

	public static final Pattern FORMATED = Pattern.compile("(1[015])[.](\\d{3})[.](\\d{3})[-](\\d{1})");

	public static final Pattern UNFORMATED = Pattern.compile("(1[015])(\\d{3})(\\d{3})(\\d{1})");

	/**
	 * Este considera, por padrão, que as cadeias estão formatadas e utiliza um
	 * {@linkplain SimpleMessageProducer} para geração de mensagens.
	 */
	public IEGoiasValidator() {
		super(true);
	}

	/**
	 * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
	 * mensagens.
	 * 
	 * @param isFormatted
	 *            considerar cadeia formatada quando <code>true</code>
	 */
	public IEGoiasValidator(boolean isFormatted) {
		super(isFormatted);
	}

	public IEGoiasValidator(MessageProducer messageProducer, boolean isFormatted) {
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

		return regraBizarraDeGoias(iESemDigito, digito) || digito.equals(digitoCalculado);
	}

	private boolean regraBizarraDeGoias(String iESemDigito, String digito) {
		if (iESemDigito.equals("11094402")) {
			if (digito.equals("0") || digito.equals("1")) {
				return true;
			}
		}
		return false;
	}

	private String calculaDigito(String iESemDigito) {
		int ie = Integer.parseInt(iESemDigito);
		/*
		 * http://www.sintegra.gov.br/Cad_Estados/cad_GO.html
		 * 
		 * De 10103105X a 10119997X => d=1
		 */
		String d = "0";
		if ((10103105 <= ie) && (ie <= 10119997)) {
			d = "1";
		}

		return new DigitoPara(iESemDigito).complementarAoModulo().trocandoPorSeEncontrar(d, 10)
				.trocandoPorSeEncontrar("0", 11).calcula();
	}

	@Override
	public String generateRandomValid() {
		final int[] segundoDigitosPossiveis = new int[] { 0, 1, 5 };
		final int segundoDigitoSorteado = new Random().nextInt(segundoDigitosPossiveis.length);
		final String ieSemDigito = "1" + segundoDigitosPossiveis[segundoDigitoSorteado]
				+ new DigitoGenerator().generate(6);
		final String ieComDigitos = ieSemDigito + calculaDigito(ieSemDigito);
		if (isFormatted) {
			return super.format(ieComDigitos, "##.###.###-#");
		}
		return ieComDigitos;
	}
}
