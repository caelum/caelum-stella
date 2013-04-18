package br.com.caelum.stella.validation.ie;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.validation.DigitoVerificadorInfo;
import br.com.caelum.stella.validation.RotinaDeDigitoVerificador;
import br.com.caelum.stella.validation.ValidadorDeDV;

public class IEMinasGeraisValidator extends AbstractIEValidator {

    private static final int DVX_MOD = 10;

    private static final int DVY_MOD = 11;

    // TAMANHO = 13;
    private static final String MISSING_ZEROS = "0";

    private static final int DVX_POSITION = MISSING_ZEROS.length() + 12;

    private static final int DVY_POSITION = MISSING_ZEROS.length() + 13;

    private static final Integer[] DVX_MULTIPLIERS = IEConstraints.P10;

    private static final Integer[] DVY_MULTIPLIERS = IEConstraints.P11;

    private static final RotinaDeDigitoVerificador[] DVX_ROTINAS = { IEConstraints.Rotina.A, IEConstraints.Rotina.E,
            IEConstraints.Rotina.POS_IE };

    private static final RotinaDeDigitoVerificador[] DVY_ROTINAS = { IEConstraints.Rotina.E,
            IEConstraints.Rotina.POS_IE };

    private static final DigitoVerificadorInfo DVX_INFO = new DigitoVerificadorInfo(0, DVX_ROTINAS, DVX_MOD,
            DVX_MULTIPLIERS, DVX_POSITION);

    private static final DigitoVerificadorInfo DVY_INFO = new DigitoVerificadorInfo(0, DVY_ROTINAS, DVY_MOD,
            DVY_MULTIPLIERS, DVY_POSITION);

    private static final ValidadorDeDV DVX_CHECKER = new ValidadorDeDV(DVX_INFO);

    private static final ValidadorDeDV DVY_CHECKER = new ValidadorDeDV(DVY_INFO);

    public static final Pattern FORMATED = Pattern.compile("(((\\d{3})\\.){2}\\d{3}/\\d{4})|(\\d{9}\\.\\d{2}-\\d{2})");

    public static final Pattern UNFORMATED = Pattern.compile("(\\d{13})");

    private static final String REPLACEMENT = MISSING_ZEROS + "$1";

	
    /**
	 * Este considera, por padrão, que as cadeias estão formatadas e utiliza um
	 * {@linkplain SimpleMessageProducer} para geração de mensagens.
	 */
	public IEMinasGeraisValidator() {
		super(true);
	}

	/**
	 * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
	 * mensagens.
	 * 
	 * @param isFormatted
	 *            considerar cadeia formatada quando <code>true</code>
	 */
	public IEMinasGeraisValidator(boolean isFormatted) {
		super(isFormatted);
	}

	public IEMinasGeraisValidator(MessageProducer messageProducer, boolean isFormatted) {
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
