package br.com.caelum.stella.validation;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.error.LengthError;

/**
 * Validador para aceitar cadeias de tamanho pré-definido. A cadeia verificada
 * por este validador é a retornada pelo método {@code toString()} do objeto em
 * questão.
 * 
 * @author leonardobessa
 * 
 */
public class LengthValidator implements Validator<Object> {

    private final int validLength;
    private final BaseValidator base;

    /**
     * @param validLength
     *            quantidade de caracteres das cadeias a serem aceitas.
     */
    public LengthValidator(int validLength) {
        this.validLength = validLength;
        base = new BaseValidator();
    }

    /**
     * @param messageProducer
     *            produto de mensagens.
     * @param validLength
     *            quantidade de caracteres das cadeias a serem aceitas.
     * 
     */
    public LengthValidator(MessageProducer messageProducer, int validLength) {
        base = new BaseValidator(messageProducer);
        this.validLength = validLength;
    }

    public void assertValid(Object object) {
        base.assertValid(getInvalidValuesFor(object));
    }

    private List<InvalidValue> getInvalidValuesFor(Object object) {
        List<InvalidValue> messages = new ArrayList<InvalidValue>();
        if (object.toString().length() != validLength) {
            messages.add(new LengthError(validLength));
        }
        return messages;
    }

    public List<ValidationMessage> invalidMessagesFor(Object object) {
        List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
        messages.addAll(base.generateValidationMessages(getInvalidValuesFor(object)));
        return messages;
    }

    public boolean isEligible(Object object) {
        return true;
    }

    @Override
    public Object generateRandomValid() {
        throw new UnsupportedOperationException("Operação não suportada por este validador");
    }
}
