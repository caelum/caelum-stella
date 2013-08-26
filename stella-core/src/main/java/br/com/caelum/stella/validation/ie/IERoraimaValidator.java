package br.com.caelum.stella.validation.ie;

import java.util.regex.Pattern;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.annotations.GwtCompatible;
import br.com.caelum.stella.validation.DigitoVerificadorInfo;
import br.com.caelum.stella.validation.RotinaDeDigitoVerificador;
import br.com.caelum.stella.validation.ValidadorDeDV;

@GwtCompatible(patternConvertible = true)
public class IERoraimaValidator extends AbstractIEValidator {

    private static final int MOD = 9;

    private static final String MISSING_LEFT_SIDE_ZEROS = "00000";

    private static final int DVX_POSITION = MISSING_LEFT_SIDE_ZEROS.length() + 9;

    private static final Integer[] DVX_MULTIPLIERS = IEConstraints.P5;

    private static final RotinaDeDigitoVerificador[] ROTINAS = { IEConstraints.Rotina.D, IEConstraints.Rotina.POS_IE };

    private static final DigitoVerificadorInfo DVX_INFO = new DigitoVerificadorInfo(0, ROTINAS, MOD, DVX_MULTIPLIERS,
            DVX_POSITION);

    public static final Pattern FORMATED = Pattern.compile("24\\d{6}\\-\\d{1}");

    public static final Pattern UNFORMATED = Pattern.compile("24\\d{7}");

    private final ValidadorDeDV validadorDeDV = new ValidadorDeDV(DVX_INFO);


    /**
	 * Este considera, por padrão, que as cadeias estão formatadas e utiliza um
	 * {@linkplain SimpleMessageProducer} para geração de mensagens.
	 */
	public IERoraimaValidator() {
		super(true);
	}

	/**
	 * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
	 * mensagens.
	 * 
	 * @param isFormatted
	 *            considerar cadeia formatada quando <code>true</code>
	 */
	public IERoraimaValidator(boolean isFormatted) {
		super(isFormatted);
	}

	public IERoraimaValidator(MessageProducer messageProducer, boolean isFormatted) {
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
        return this.validadorDeDV.isDVValid(testedValue);
    }

}
