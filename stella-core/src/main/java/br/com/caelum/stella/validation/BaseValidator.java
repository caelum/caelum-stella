package br.com.caelum.stella.validation;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.ValidationMessage;

// TODO refactor to composition + strategy
public abstract class BaseValidator<T> implements Validator<T> {
    private final MessageProducer messageProducer;

    public BaseValidator() {
        this.messageProducer = new SimpleMessageProducer();
    }

    public BaseValidator(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    protected List<ValidationMessage> generateValidationMessages(
            List<InvalidValue> invalidValues) {
        List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
        for (InvalidValue invalidValue : invalidValues) {
            ValidationMessage message = messageProducer
                    .getMessage(invalidValue);
            messages.add(message);
        }
        return messages;
    }

    public List<ValidationMessage> invalidMessagesFor(T value) {
        List<InvalidValue> invalidValues = getInvalidValues(value);
        List<ValidationMessage> messages = generateValidationMessages(invalidValues);
        return messages;
    }

    public void assertValid(T value) {
        List<InvalidValue> errors = getInvalidValues(value);
        if (!errors.isEmpty()) {
            throw new InvalidStateException(generateValidationMessages(errors));
        }
    }

    protected abstract List<InvalidValue> getInvalidValues(T value);

}