package br.com.caelum.stella.validator;

import br.com.caelum.stella.Validator;
import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ValidationMessage;

import java.util.List;

/**
 * @Author Fabio Kung
 */
public class CPFValidator implements Validator<String> {

    private final MessageProducer<CPFError> messageProducer;

    public CPFValidator(MessageProducer<CPFError> messageProducer) {
        this.messageProducer = messageProducer;
    }

    public boolean validate(String object) {
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<ValidationMessage> getLastValidationMessages() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

}
