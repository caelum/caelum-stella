package br.com.caelum.stella.validation.ie;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.constraint.IEConstraints;
import br.com.caelum.stella.validation.error.IEError;
import br.com.caelum.stella.validation.*;

public class InscricaoEstatudalDeRioGrandeDoSulValidator extends
        BaseValidator<String> {

    private static final int MOD = 11;

    // TAMANHO = 10;
    private static final String MISSING_LEFT_SIDE_ZEROS = "0000";

    private static final int DVX_POSITION = MISSING_LEFT_SIDE_ZEROS.length() + 10;
    private static final Integer[] DVX_MULTIPLIERS = IEConstraints.P1;

    private static final RotinaDeDigitoVerificador[] rotinas = {
            IEConstraints.Rotina.E, IEConstraints.Rotina.POS_IE };

    private static final DigitoVerificadorInfo DVX_INFO = new DigitoVerificadorInfo(
            0, rotinas, MOD, DVX_MULTIPLIERS, DVX_POSITION);

    private static final ValidadorDeDV DVX_CHECKER = new ValidadorDeDV(DVX_INFO);

    private final boolean isFormatted;

    public static final Pattern FORMATED = Pattern
            .compile("([0-4]\\d{2})[/](\\d{6})(\\d{1})");
    public static final Pattern UNFORMATED = Pattern
            .compile("([0-4]\\d{2})(\\d{6})(\\d{1})");
    
    /**
     * Este considera, por padrão, que as cadeias estão formatadas e utiliza um
     * {@linkplain SimpleMessageProducer} para geração de mensagens.
     */
    public InscricaoEstatudalDeRioGrandeDoSulValidator() {
        this(true);
    }

    /**
     * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
     * mensagens.
     * 
     * @param isFormatted
     *                considerar cadeia formatada quando <code>true</code>
     */
    public InscricaoEstatudalDeRioGrandeDoSulValidator(boolean isFormatted) {
        super();
        this.isFormatted = isFormatted;
    }

    public InscricaoEstatudalDeRioGrandeDoSulValidator(
            MessageProducer messageProducer, boolean isFormatted) {
        super(messageProducer);
        this.isFormatted = isFormatted;
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
                if (!hasValidMunicipality(unformatedIE)) {
                    errors.add(IEError.INVALID_MUNICIPALITY);
                }
            }
        }
        return errors;
    }

    private boolean hasValidMunicipality(String unformatedIE) {
        String municipality = null;
        Matcher matcher = UNFORMATED.matcher(unformatedIE);
        if (matcher.matches()) {
            municipality = matcher.replaceAll("$1");
        }
        int municipalityInt = Integer.parseInt(municipality);
        boolean result = municipalityInt > 0 && municipalityInt <= 467;
        return result;
    }

    private String checkForCorrectFormat(String ie, List<InvalidValue> errors) {
        String unformatedIE = null;
        if (isFormatted) {
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
        return DVX_CHECKER.isDVValid(testedValue);
    }

}
