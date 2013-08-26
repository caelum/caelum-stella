package br.com.caelum.stella.validation;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.annotations.GwtCompatible;

/**
 * 
 * @author leonardobessa
 */
@GwtCompatible
public class AcceptAnyValidator implements Validator<String> {

    private List<Validator<String>> validators = new ArrayList<Validator<String>>();

    public static enum Documento {
        CPF {
            public Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
                return new CPFValidator(messageProducer, isFormatted);
            }
        },
        CNPJ {
            public Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
                return new CNPJValidator(messageProducer, isFormatted);
            }
        };

        public abstract Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted);
    }

    public AcceptAnyValidator(Documento... documentos) {
        this(true, documentos);
    }

    public AcceptAnyValidator(boolean isFormatted, Documento... documentos) {
        this(new SimpleMessageProducer(), isFormatted, documentos);
    }

    public AcceptAnyValidator(MessageProducer messageProducer, boolean isFormatted, Documento... documentos) {
        for (Documento documento : documentos) {
            validators.add(documento.getValidator(messageProducer, isFormatted));
        }
    }

    public void assertValid(String value) {
        List<ValidationMessage> invalidMessages = invalidMessagesFor(value);
        if (!invalidMessages.isEmpty()) {
            throw new InvalidStateException(invalidMessages);
        }
    }

    public List<ValidationMessage> invalidMessagesFor(String value) {
        List<ValidationMessage> result = new ArrayList<ValidationMessage>();
        for (Validator<String> validator : validators) {
            List<ValidationMessage> messages = validator.invalidMessagesFor(value);
            if (messages.isEmpty()) {
                result.clear();
                break;
            } else {
                result.addAll(messages);
            }
        }
        return result;
    }

    public boolean isEligible(String object) {
        boolean result = false;
        for (Validator<String> validator : validators) {
            result |= validator.isEligible(object);
        }
        return result;
    }

}
