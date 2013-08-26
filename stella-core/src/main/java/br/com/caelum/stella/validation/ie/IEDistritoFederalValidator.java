package br.com.caelum.stella.validation.ie;

import java.util.regex.Pattern;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.annotations.GwtCompatible;
import br.com.caelum.stella.validation.DigitoVerificadorInfo;
import br.com.caelum.stella.validation.RotinaDeDigitoVerificador;
import br.com.caelum.stella.validation.ValidadorDeDV;

/**
 * <p>
 * Documentação de referência:
 * </p>
 * <a href="http://www.pfe.fazenda.sp.gov.br/consist_ie.shtm">Secretaria da
 * Fazenda do Estado de São Paulo</a> <a
 * href="http://www.sintegra.gov.br/Cad_Estados/cad_DF.html">SINTEGRA - ROTEIRO
 * DE CRÍTICA DA INSCRIÇÃO ESTADUAL </a>
 * 
 */
@GwtCompatible(patternConvertible = true)
public class IEDistritoFederalValidator extends AbstractIEValidator {

    private static final int MOD = 11;

    private static final int DVX_POSITION = 1 + 12;

    private static final RotinaDeDigitoVerificador[] rotinas = { IEConstraints.Rotina.E, IEConstraints.Rotina.POS_IE };

    private static final Integer[] DVX_MULTIPLIERS = IEConstraints.P2;

    private static final DigitoVerificadorInfo DVX_INFO = new DigitoVerificadorInfo(0, rotinas, MOD, DVX_MULTIPLIERS,
            DVX_POSITION);

    private static final ValidadorDeDV DVX_CHECKER = new ValidadorDeDV(DVX_INFO);

    private static final Integer[] DVY_MULTIPLIERS = IEConstraints.P1;

    private static final int DVY_POSITION = 1 + 13;

    private static final DigitoVerificadorInfo DVY_INFO = new DigitoVerificadorInfo(0, rotinas, MOD, DVY_MULTIPLIERS,
            DVY_POSITION);

    private static final ValidadorDeDV DVY_CHECKER = new ValidadorDeDV(DVY_INFO);
    /*
     * Formato: 07.408.738/002-50
     */

    public static final Pattern FORMATED = Pattern.compile("(07)[.]([3-9]\\d{2})[.](\\d{3})[/](\\d{3})[-](\\d{2})");

    public static final Pattern UNFORMATED = Pattern.compile("(07)([3-9]\\d{2})(\\d{3})(\\d{3})(\\d{2})");

	/**
	 * Este considera, por padrão, que as cadeias estão formatadas e utiliza um
	 * {@linkplain SimpleMessageProducer} para geração de mensagens.
	 */
	public IEDistritoFederalValidator() {
		super(true);
	}

	/**
	 * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
	 * mensagens.
	 * 
	 * @param isFormatted
	 *            considerar cadeia formatada quando <code>true</code>
	 */
	public IEDistritoFederalValidator(boolean isFormatted) {
		super(isFormatted);
	}

	public IEDistritoFederalValidator(MessageProducer messageProducer, boolean isFormatted) {
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
	
    protected boolean hasValidCheckDigits(String value) {
        String testedValue = IEConstraints.PRE_VALIDATION_FORMATTER.format(value);
        return DVX_CHECKER.isDVValid(testedValue) && DVY_CHECKER.isDVValid(testedValue);
    }

}
