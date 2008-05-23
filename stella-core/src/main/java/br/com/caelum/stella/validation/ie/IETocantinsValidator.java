package br.com.caelum.stella.validation.ie;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.BaseValidator;
import br.com.caelum.stella.validation.InvalidValue;
import br.com.caelum.stella.validation.Validator;

public class IETocantinsValidator implements Validator<String> {

    private final IETocantinsAntigaValidator antigaValidator;
    private final IETocantinsNovaValidator novaValidator;
    private final BaseValidator<String> baseValidator;
    private final boolean isFormatted;
    
    /**
     * Este considera, por padrão, que as cadeias estão formatadas e utiliza um
     * {@linkplain SimpleMessageProducer} para geração de mensagens.
     */
    public IETocantinsValidator() {
        this(true);
    }

    /**
     * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
     * mensagens.
     * 
     * @param isFormatted
     *                considerar cadeia formatada quando <code>true</code>
     */
    public IETocantinsValidator(boolean isFormatted) {
        this(new SimpleMessageProducer(),isFormatted);
    }

    public IETocantinsValidator(
            MessageProducer messageProducer, boolean isFormatted) {
        this.isFormatted = isFormatted;
        antigaValidator = new IETocantinsAntigaValidator(
                null, isFormatted);
        novaValidator = new IETocantinsNovaValidator(
                null, isFormatted);
        this.baseValidator = new BaseValidator<String>(messageProducer) {

            @Override
            protected List<InvalidValue> getInvalidValues(String value) {
                List<InvalidValue> result = null;
                if (value!=null) {
                    if (IETocantinsValidator.this.isFormatted) {
                        if (IETocantinsAntigaValidator.FORMATED.matcher(value)
                                .matches()) {
                            result = antigaValidator.getInvalidValues(value);
                        } else {
                            result = novaValidator.getInvalidValues(value);
                        }
                    } else {
                        if (IETocantinsAntigaValidator.UNFORMATED
                                .matcher(value).matches()) {
                            result = antigaValidator.getInvalidValues(value);
                        } else {
                            result = novaValidator.getInvalidValues(value);
                        }
                    }
                } else { 
                    result = new ArrayList<InvalidValue>();
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
