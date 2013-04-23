package br.com.caelum.stella.validation.ie;

import java.util.regex.Pattern;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.validation.DigitoVerificadorInfo;
import br.com.caelum.stella.validation.RotinaDeDigitoVerificador;
import br.com.caelum.stella.validation.ValidadorDeDV;

/**
 * <p>
 * Documentação de referência:
 * </p>
 * <a href="http://www.pfe.fazenda.sp.gov.br/consist_ie.shtm">Secretaria da
 * Fazenda do Estado de São Paulo</a> <a
 * href="http://www.sintegra.gov.br/Cad_Estados/cad_AC.html">SINTEGRA - ROTEIRO
 * DE CRÍTICA DA INSCRIÇÃO ESTADUAL </a>
 * 
 */
public class IEAcreValidator extends AbstractIEValidator {

	public static final Pattern FORMATED = Pattern.compile("01(\\.\\d{3}){2}\\/\\d{3}\\-\\d{2}");

	public static final Pattern UNFORMATED = Pattern.compile("01\\d{11}");

	private static final int MOD = 11;

	private static final RotinaDeDigitoVerificador[] rotinas = {
			IEConstraints.Rotina.E, IEConstraints.Rotina.POS_IE };

	private static final int DVX_POSITION = 1 + 13;

	private static final Integer[] DVX_MULTIPLIERS = IEConstraints.P1;

	private static final DigitoVerificadorInfo DVX_INFO = new DigitoVerificadorInfo(
			0, rotinas, MOD, DVX_MULTIPLIERS, DVX_POSITION);

	static final ValidadorDeDV DVX_CHECKER = new ValidadorDeDV(DVX_INFO);

	private static final int DVY_POSITION = 1 + 12;

	private static final Integer[] DVY_MULTIPLIERS = IEConstraints.P2;

	private static final DigitoVerificadorInfo DVY_INFO = new DigitoVerificadorInfo(
			0, rotinas, MOD, DVY_MULTIPLIERS, DVY_POSITION);

	static final ValidadorDeDV DVY_CHECKER = new ValidadorDeDV(DVY_INFO);

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
	protected boolean hasValidCheckDigits(String value) {
		String testedValue = IEConstraints.PRE_VALIDATION_FORMATTER
				.format(value);
		return DVX_CHECKER.isDVValid(testedValue)
				&& DVY_CHECKER.isDVValid(testedValue);
	}

}
