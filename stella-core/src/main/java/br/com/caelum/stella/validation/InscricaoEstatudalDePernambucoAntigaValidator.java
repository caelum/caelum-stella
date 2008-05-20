package br.com.caelum.stella.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.error.IEError;

class InscricaoEstatudalDePernambucoAntigaValidator extends
        AbstractValidator<String> {

    // Exemplo 18.1.001.0000004-9

    // UF Tam Fat f Cálculo DVX
    // PE 14 1 E 11 P7

    // VALORES POSSÍVEIS PARA DÍGITOS
    // =1 =8 1/9 0/9 0/9 0/9 0/9 0/9 0/9 0/9 0/9 0/9 0/9

    // DVX
    private static final int MOD = 11;
    private static final int FATOR = 1;

    private static final int DVX_POSITION = 14;
    private static final Integer[] DVX_MULTIPLIERS = IEConstraints.P7;

    private static final RotinaDeDigitoVerificador[] rotinas = {
            IEConstraints.Rotina.E, IEConstraints.Rotina.POS_IE };

    private static final DigitoVerificadorInfo DVX_INFO = new DigitoVerificadorInfo(
            FATOR, rotinas, MOD, DVX_MULTIPLIERS, DVX_POSITION);

    private static final ValidadorDeDV DVX_CHECKER = new ValidadorDeDV(DVX_INFO);

    private final boolean isFormatted;

    public static final Pattern FORMATED = Pattern
            .compile("([1][8])[.]([1-9])[.](\\d{3})[.](\\d{7})[-](\\d{1})");
    public static final Pattern UNFORMATED = Pattern
            .compile("([1][8])([1-9])(\\d{3})(\\d{7})(\\d{1})");

    public InscricaoEstatudalDePernambucoAntigaValidator(
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
            }
        }
        return errors;
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
        String testedValue = value;
        return DVX_CHECKER.DVisValid(testedValue);
    }

}
