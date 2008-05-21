package br.com.caelum.stella.validation;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.validation.error.IEError;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class InscricaoEstatudalDeRoraimaValidator extends BaseValidator<String> {

    private static final int MOD = 9;

    // TAMANHO = 9
    private static final String MISSING_LEFT_SIDE_ZEROS = "00000";

    private static final int DVX_POSITION = MISSING_LEFT_SIDE_ZEROS.length() + 9;
    private static final Integer[] DVX_MULTIPLIERS = IEConstraints.P5;
    private static final RotinaDeDigitoVerificador[] ROTINAS = {IEConstraints.Rotina.D, IEConstraints.Rotina.POS_IE};
    private static final DigitoVerificadorInfo DVX_INFO =
            new DigitoVerificadorInfo(0, ROTINAS, MOD, DVX_MULTIPLIERS, DVX_POSITION);

    public static final Pattern FORMATED = Pattern.compile("([2][4])(\\d{6})[-](\\d{1})");
    public static final Pattern UNFORMATED = Pattern.compile("([2][4])(\\d{6})(\\d{1})");

    private final ValidadorDeDV validadorDeDV = new ValidadorDeDV(DVX_INFO);
    private final boolean formatted;

    /**
     * Este considera, por padrão, que as cadeias estão formatadas e utiliza um
     * {@linkplain SimpleMessageProducer} para geração de mensagens.
     */
    public InscricaoEstatudalDeRoraimaValidator() {
        this(true);
    }

    /**
     * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
     * mensagens.
     *
     * @param formatted considerar cadeia formatada quando <code>true</code>
     */
    public InscricaoEstatudalDeRoraimaValidator(boolean formatted) {
        this.formatted = formatted;
    }

    public InscricaoEstatudalDeRoraimaValidator(MessageProducer messageProducer, boolean formatted) {
        super(messageProducer);
        this.formatted = formatted;
    }

    @Override
    protected List<InvalidValue> getInvalidValues(String IE) {
        List<InvalidValue> errors = new ArrayList<InvalidValue>();
        errors.clear();
        if (IE != null) {
            String unformatedIE = checkForCorrectFormat(IE, errors);
            if (errors.isEmpty()) {
                if (!hasValidCheckDigits(unformatedIE)) {
                    errors.add(IEError.INVALID_CHECK_DIGITS);
                }
            }
        }
        return errors;
    }

    private String checkForCorrectFormat(String ie, List<InvalidValue> errors) {
        String unformatedIE = null;
        if (formatted) {
            if (!(FORMATED.matcher(ie).matches())) {
                errors.add(IEError.INVALID_FORMAT);
            }
            unformatedIE = ie.replaceAll("\\D", "");
        } else {
            if (!UNFORMATED.matcher(ie).matches()) {
                errors.add(IEError.INVALID_DIGITS);
            }
            unformatedIE = ie;
        }
        return unformatedIE;
    }

    private boolean hasValidCheckDigits(String value) {
        String testedValue = MISSING_LEFT_SIDE_ZEROS + value;
        return this.validadorDeDV.isDVValid(testedValue);
    }

}
