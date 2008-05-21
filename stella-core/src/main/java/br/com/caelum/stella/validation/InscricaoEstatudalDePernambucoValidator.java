package br.com.caelum.stella.validation;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.ValidationMessage;

import java.util.List;

public class InscricaoEstatudalDePernambucoValidator implements Validator<String> {

    private final InscricaoEstatudalDePernambucoAntigaValidator antigaValidator;
    private final InscricaoEstatudalDePernambucoNovaValidator novaValidator;
    private final BaseValidator<String> baseValidator;

    /**
     * Este considera, por padrão, que as cadeias estão formatadas e utiliza um
     * {@linkplain SimpleMessageProducer} para geração de mensagens.
     */
    public InscricaoEstatudalDePernambucoValidator() {
        this(true);
    }

    /**
     * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
     * mensagens.
     *
     * @param isFormatted considerar cadeia formatada quando <code>true</code>
     */
    public InscricaoEstatudalDePernambucoValidator(boolean isFormatted) {
        this(new SimpleMessageProducer(), isFormatted);
    }

    public InscricaoEstatudalDePernambucoValidator(
            MessageProducer messageProducer, boolean isFormatted) {
        antigaValidator = new InscricaoEstatudalDePernambucoAntigaValidator(
                null, isFormatted);
        novaValidator = new InscricaoEstatudalDePernambucoNovaValidator(null,
                isFormatted);
        final boolean finalIsFormatted = isFormatted;
        this.baseValidator = new BaseValidator<String>(messageProducer) {

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
        baseValidator.assertValid(value);
    }

    public List<ValidationMessage> invalidMessagesFor(String value) {
        return baseValidator.invalidMessagesFor(value);
    }

}
