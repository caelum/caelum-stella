package br.com.caelum.stella.validation;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.ValidationMessage;

public class BaseValidator {
    private final MessageProducer messageProducer;

    public BaseValidator() {
        this.messageProducer = new SimpleMessageProducer();
    }

    public BaseValidator(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    public List<ValidationMessage> generateValidationMessages(
            List<InvalidValue> invalidValues) {
        List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
        for (InvalidValue invalidValue : invalidValues) {
            ValidationMessage message = messageProducer
                    .getMessage(invalidValue);
            messages.add(message);
        }
        return messages;
    }

    public void assertValid(List<InvalidValue> invalidValues) {
        if (!invalidValues.isEmpty()) {
            throw new InvalidStateException(
                    generateValidationMessages(invalidValues));
        }
    }

}