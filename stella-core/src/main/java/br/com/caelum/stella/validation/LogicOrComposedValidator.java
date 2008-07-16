package br.com.caelum.stella.validation;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.ConsistentValidator;
import br.com.caelum.stella.SimpleValidationMessage;
import br.com.caelum.stella.ValidationMessage;

public class LogicOrComposedValidator<T> implements Validator<T> {

    public ConsistentValidator<T>[] validators;

    public LogicOrComposedValidator(ConsistentValidator<T>... validators) {
        this.validators = validators;
    }

    public void assertValid(T value) {
        InvalidStateException lastException = null;
        boolean isValid = false;
        for (ConsistentValidator<T> v : validators) {
            if (v.patternMatches(value)) {
                try {
                    v.assertValid(value);
                    isValid = true;
                    break;
                } catch (InvalidStateException e) {
                    lastException = e;
                }
            }
        }
        if (!isValid) {
            if (lastException != null) {
                throw lastException;
            } else {
                throw new InvalidStateException(new SimpleValidationMessage("INVALID_FORMAT"));
            }
        }
    }

    public List<ValidationMessage> invalidMessagesFor(T value) {
        List<ValidationMessage> result = null;
        for (ConsistentValidator<T> v : validators) {
            if (v.patternMatches(value)) {
                List<ValidationMessage> invalidMessages = v
                        .invalidMessagesFor(value);
                result = invalidMessages;
                if (invalidMessages.isEmpty()) {
                    break;
                }
            }
        }
        if (result == null) {
            result = new ArrayList<ValidationMessage>();
            result.add(new SimpleValidationMessage("INVALID_FORMAT"));
        }
        return result;
    }

}
