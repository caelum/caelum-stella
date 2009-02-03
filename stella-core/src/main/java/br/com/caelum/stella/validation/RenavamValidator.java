package br.com.caelum.stella.validation;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.format.RenavamFormatter;
import br.com.caelum.stella.validation.error.RenavamError;

public class RenavamValidator implements Validator<String> {

    private final BaseValidator baseValidator;
    private static final Integer fator = 0;
    private static final Integer mod = 11;
    private static final Integer[] pesos = { 9, 8, 7, 6, 5, 4, 3, 2 };
    private static final Integer posicaoDoDigitoVerificador = 9;
    private static final RotinaDeDigitoVerificador[] rotinas = { new RotinaComumDeDigitoVerificador() };
    private static final DigitoVerificadorInfo digitoVerificadorInfo = new DigitoVerificadorInfo(fator, rotinas, mod,
            pesos,
            posicaoDoDigitoVerificador);
    private static final ValidadorDeDV validatorDeDigitoVerificador = new ValidadorDeDV(digitoVerificadorInfo);
    private final boolean isFormatted;

    public RenavamValidator() {
        this(true);
    }

    public RenavamValidator(boolean isFormatted) {
        this.isFormatted = isFormatted;
        this.baseValidator = new BaseValidator();
    }

    public RenavamValidator(MessageProducer messageProducer, boolean isFormatted) {
        this.isFormatted = isFormatted;
        this.baseValidator = new BaseValidator(messageProducer);
    }

    public void assertValid(String renavam) {
        baseValidator.assertValid(getInvalidValues(renavam));
    }

    private boolean isCheckDigitValid(String renavam) {
        return validatorDeDigitoVerificador.isDVValid(unformat(renavam));
    }

    public List<ValidationMessage> invalidMessagesFor(String renavam) {
        return baseValidator.generateValidationMessages(getInvalidValues(renavam));
    }

    private List<InvalidValue> getInvalidValues(String renavam) {
        List<InvalidValue> errors = new ArrayList<InvalidValue>();
        if (!isEligible(renavam)) {
            errors.add(RenavamError.INVALID_DIGITS);
        } else if (!isCheckDigitValid(renavam)) {
            errors.add(RenavamError.INVALID_CHECK_DIGIT);
        }
        return errors;
    }

    public boolean isEligible(String renavam) {
        boolean isEligible;
        if (isFormatted) {
            isEligible = RenavamFormatter.FORMATTED.matcher(renavam).matches();
        } else {
            isEligible = RenavamFormatter.UNFORMATTED.matcher(renavam).matches();
        }
        return isEligible;
    }

    private String unformat(String renavam) {
        String result = renavam;
        if (isFormatted) {
            result = new RenavamFormatter().unformat(renavam);
        }
        return result;
    }
}
