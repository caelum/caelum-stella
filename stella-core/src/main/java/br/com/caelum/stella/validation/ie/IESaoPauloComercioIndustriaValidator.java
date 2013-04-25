package br.com.caelum.stella.validation.ie;

import java.util.regex.Pattern;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.validation.DigitoVerificadorInfo;
import br.com.caelum.stella.validation.RotinaDeDigitoVerificador;
import br.com.caelum.stella.validation.ValidadorDeDV;

class IESaoPauloComercioIndustriaValidator extends AbstractIEValidator {

    private static final int MOD = 11;

    // TAMANHO = 12;
    private static final String MISSING_LEFT_SIDE_ZEROS = "00";

    private static final int DVX_POSITION = MISSING_LEFT_SIDE_ZEROS.length() + 9;

    private static final int DVY_POSITION = MISSING_LEFT_SIDE_ZEROS.length() + 12;

    private static final Integer[] DVX_MULTIPLIERS = IEConstraints.P12;

    private static final Integer[] DVY_MULTIPLIERS = IEConstraints.P13;

    private static final RotinaDeDigitoVerificador[] rotinas = { IEConstraints.Rotina.D, IEConstraints.Rotina.POS_IE };

    private static final DigitoVerificadorInfo DVX_INFO = new DigitoVerificadorInfo(0, rotinas, MOD, DVX_MULTIPLIERS,
            DVX_POSITION);

    private static final DigitoVerificadorInfo DVY_INFO = new DigitoVerificadorInfo(0, rotinas, MOD, DVY_MULTIPLIERS,
            DVY_POSITION);

    private static final ValidadorDeDV DVX_CHECKER = new ValidadorDeDV(DVX_INFO);

    private static final ValidadorDeDV DVY_CHECKER = new ValidadorDeDV(DVY_INFO);

    public static final Pattern FORMATED = Pattern.compile("(\\d{3}\\.){3}\\d{3}");

    public static final Pattern UNFORMATED = Pattern.compile("\\d{12}");

    /**
	 * Este considera, por padrão, que as cadeias estão formatadas e utiliza um
	 * {@linkplain SimpleMessageProducer} para geração de mensagens.
	 */
	public IESaoPauloComercioIndustriaValidator() {
		super(true);
	}

	/**
	 * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
	 * mensagens.
	 * 
	 * @param isFormatted
	 *            considerar cadeia formatada quando <code>true</code>
	 */
	public IESaoPauloComercioIndustriaValidator(boolean isFormatted) {
		super(isFormatted);
	}

	public IESaoPauloComercioIndustriaValidator(MessageProducer messageProducer, boolean isFormatted) {
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
        String testedValue = MISSING_LEFT_SIDE_ZEROS + value;
        return (DVX_CHECKER.isDVValid(testedValue)) && (DVY_CHECKER.isDVValid(testedValue));
    }

}
