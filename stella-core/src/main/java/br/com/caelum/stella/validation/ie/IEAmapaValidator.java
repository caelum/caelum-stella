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
 * <a href="http://www.pfe.fazenda.sp.gov.br/consist_ie.shtm">Secretaria da
 * Fazenda do Estado de São Paulo</a>
 * <a href="http://www.sintegra.gov.br/Cad_Estados/cad_AP.html">SINTEGRA -
 * ROTEIRO DE CRÍTICA DA INSCRIÇÃO ESTADUAL </a>
 * 
 */
public class IEAmapaValidator extends AbstractIEValidator {

	public static final Pattern FORMATED = Pattern.compile("(03)[.](\\d{3})\\.?(\\d{3})[-](\\d{1})");

	public static final Pattern UNFORMATED = Pattern.compile("(03)(\\d{3})(\\d{3})(\\d{1})");

	/**
	 * Este considera, por padrão, que as cadeias estão formatadas e utiliza um
	 * {@linkplain SimpleMessageProducer} para geração de mensagens.
	 */
	public IEAmapaValidator() {
		super(true);
	}

	/**
	 * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
	 * mensagens.
	 * 
	 * @param isFormatted
	 *            considerar cadeia formatada quando <code>true</code>
	 */
	public IEAmapaValidator(boolean isFormatted) {
		super(isFormatted);
	}

	public IEAmapaValidator(MessageProducer messageProducer, boolean isFormatted) {
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
		String iESemDigito = unformattedIE.substring(0, unformattedIE.length() - 1);
		String digito = unformattedIE.substring(unformattedIE.length() - 1);
		String digitoCalculado = calculaDigito(iESemDigito);

		return digito.equals(digitoCalculado);
	}

	private String calculaDigito(String iESemDigito) {
		int ie = Integer.parseInt(iESemDigito);
		/*
		 * http://www.sintegra.gov.br/Cad_Estados/cad_AP.html
		 * 
		 * De 03000001X a 03017000X => CASO 1 (p=5; d=0)
		 * 
		 * De 03017001X a 03019022X => CASO 2 (p=9; d=1)
		 * 
		 * De 03019023X em diante => CASO 3 (p=0; d=0)
		 */
		String p = "0";
		String d = "0";
		if ((3000001 <= ie) && (ie <= 3017000)) {
			p = "5";
		} else if ((3017001 <= ie) && (ie <= 3019022)) {
			p = "9";
			d = "1";
		}

		return new DigitoPara(iESemDigito).addDigito(p).comMultiplicadoresDeAte(1, 9).complementarAoModulo()
				.trocandoPorSeEncontrar("0", 10).trocandoPorSeEncontrar(d, 11).calcula();
	}

	@Override
	public String generateRandomValid() {
		final String ieSemDigito = "03" + new DigitoGenerator().generate(6);
		final String ieComDigito = ieSemDigito + calculaDigito(ieSemDigito);
		if (isFormatted) {
			return super.format(ieComDigito, "##.###.###-#");
		}
		return ieComDigito;
	}
}
