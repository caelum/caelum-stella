package br.com.caelum.stella.validation;

import java.util.List;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ValidationMessage;

public class InscricaoEstatudalDePernambucoValidator implements
        Validator<String> {

    private final InscricaoEstatudalDePernambucoAntigaValidator antigaValidator;
    private final InscricaoEstatudalDePernambucoNovaValidator novaValidator;
    private final AbstractValidator<String> abstractValidator;

    public InscricaoEstatudalDePernambucoValidator(
            MessageProducer messageProducer, boolean isFormatted) {
        antigaValidator = new InscricaoEstatudalDePernambucoAntigaValidator(
                null, isFormatted);
        novaValidator = new InscricaoEstatudalDePernambucoNovaValidator(null,
                isFormatted);
        final boolean finalIsFormatted = isFormatted;
        this.abstractValidator = new AbstractValidator<String>(messageProducer) {

            @Override
            protected List<InvalidValue> getInvalidValues(String value) {
                List<InvalidValue> result = null;
                if (finalIsFormatted) {
                    if (InscricaoEstatudalDePernambucoAntigaValidator.FORMATED
                            .matcher(value).matches()) {
                        result = antigaValidator.getInvalidValues(value);
                    } else {
                        result = novaValidator.getInvalidValues(value);
                    }
                } else {
                    if (InscricaoEstatudalDePernambucoAntigaValidator.UNFORMATED
                            .matcher(value).matches()) {
                        result = antigaValidator.getInvalidValues(value);
                    } else {
                        result = novaValidator.getInvalidValues(value);
                    }
                }
                return result;
            }

        };
    }

    public void assertValid(String value) {
        abstractValidator.assertValid(value);
    }

    public List<ValidationMessage> invalidMessagesFor(String value) {
        return abstractValidator.invalidMessagesFor(value);
    }

}
