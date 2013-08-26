package br.com.caelum.stella.validation.ie;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.annotations.GwtCompatible;
import br.com.caelum.stella.validation.DigitoVerificadorInfo;
import br.com.caelum.stella.validation.RotinaDeDigitoVerificador;
import br.com.caelum.stella.validation.ValidadorDeDV;

@GwtCompatible(patternConvertible = true)
class IEPernambucoNovaValidator extends AbstractIEValidator {

    private static final int DVX_MOD = 11;

    private static final int DVY_MOD = 11;

    // TAMANHO = 9;
    private static final String MISSING_ZEROS = "00000";

    private static final int DVX_POSITION = MISSING_ZEROS.length() + 8;

    private static final int DVY_POSITION = MISSING_ZEROS.length() + 9;

    private static final Integer[] DVX_MULTIPLIERS = IEConstraints.P2;

    private static final Integer[] DVY_MULTIPLIERS = IEConstraints.P13;

    private static final RotinaDeDigitoVerificador[] DVX_ROTINAS = { IEConstraints.Rotina.E,
            IEConstraints.Rotina.POS_IE };

    private static final RotinaDeDigitoVerificador[] DVY_ROTINAS = { IEConstraints.Rotina.E,
            IEConstraints.Rotina.POS_IE };

    private static final DigitoVerificadorInfo DVX_INFO = new DigitoVerificadorInfo(0, DVX_ROTINAS, DVX_MOD,
            DVX_MULTIPLIERS, DVX_POSITION);

    private static final DigitoVerificadorInfo DVY_INFO = new DigitoVerificadorInfo(0, DVY_ROTINAS, DVY_MOD,
            DVY_MULTIPLIERS, DVY_POSITION);

    private static final ValidadorDeDV DVX_CHECKER = new ValidadorDeDV(DVX_INFO);

    private static final ValidadorDeDV DVY_CHECKER = new ValidadorDeDV(DVY_INFO);

    // 0321418-40
    public static final Pattern FORMATED = Pattern.compile("(\\d{7})[-](\\d{2})");

    public static final Pattern UNFORMATED = Pattern.compile("(\\d{7})(\\d{2})");

    private static final String REPLACEMENT = MISSING_ZEROS + "$1$2";

	
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

    protected boolean hasValidCheckDigits(String value) {
        String testedValue = null;
        Matcher matcher = UNFORMATED.matcher(value);
        if (matcher.matches()) {
            testedValue = matcher.replaceAll(REPLACEMENT);
        }
        boolean DVXisValid = DVX_CHECKER.isDVValid(testedValue);
        boolean DVYisValid = DVY_CHECKER.isDVValid(testedValue);
        return (DVXisValid) && (DVYisValid);
    }
}
