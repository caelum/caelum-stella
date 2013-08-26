package br.com.caelum.stella.validation.ie;

import java.util.regex.Pattern;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.annotations.GwtCompatible;
import br.com.caelum.stella.validation.DigitoVerificadorInfo;
import br.com.caelum.stella.validation.RotinaDeDigitoVerificador;
import br.com.caelum.stella.validation.ValidadorDeDV;

@GwtCompatible(patternConvertible = true)
class IEPernambucoAntigaValidator extends AbstractIEValidator {

    private static final int MOD = 11;

    private static final int FATOR = 1;

    private static final int DVX_POSITION = 14;

    private static final Integer[] DVX_MULTIPLIERS = IEConstraints.P7;

    private static final RotinaDeDigitoVerificador[] rotinas = { IEConstraints.Rotina.E, IEConstraints.Rotina.POS_IE };

    private static final DigitoVerificadorInfo DVX_INFO = new DigitoVerificadorInfo(FATOR, rotinas, MOD,
            DVX_MULTIPLIERS, DVX_POSITION);

    private static final ValidadorDeDV DVX_CHECKER = new ValidadorDeDV(DVX_INFO);

    public static final Pattern FORMATED = Pattern.compile("([1][8])\\.?([1-9])\\.?(\\d{3})\\.?(\\d{7})\\-?(\\d{1})");

    public static final Pattern UNFORMATED = Pattern.compile("([1][8])([1-9])(\\d{3})(\\d{7})(\\d{1})");
	
    /**
	 * Este considera, por padrão, que as cadeias estão formatadas e utiliza um
	 * {@linkplain SimpleMessageProducer} para geração de mensagens.
	 */
	public IEPernambucoAntigaValidator() {
		super(true);
	}

	/**
	 * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
	 * mensagens.
	 * 
	 * @param isFormatted
	 *            considerar cadeia formatada quando <code>true</code>
	 */
	public IEPernambucoAntigaValidator(boolean isFormatted) {
		super(isFormatted);
	}

	public IEPernambucoAntigaValidator(MessageProducer messageProducer, boolean isFormatted) {
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
        String testedValue = value;
        return DVX_CHECKER.isDVValid(testedValue);
    }

}
