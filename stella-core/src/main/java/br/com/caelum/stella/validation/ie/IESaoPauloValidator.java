package br.com.caelum.stella.validation.ie;

import java.util.List;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.BaseValidator;
import br.com.caelum.stella.validation.InvalidValue;
import br.com.caelum.stella.validation.Validator;

public class IESaoPauloValidator implements Validator<String> {

    private final IESaoPauloComercioIndustriaValidator comercioIndustriaValidator;
    private final IESaoPauloProdutorRuralValidator produtorRuralValidator;
    private final BaseValidator<String> baseValidator;

    /**
     * Este considera, por padrão, que as cadeias estão formatadas e utiliza um
     * {@linkplain SimpleMessageProducer} para geração de mensagens.
     */
    public IESaoPauloValidator() {
        this(true);
    }

    /**
     * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
     * mensagens.
     * 
     * @param isFormatted
     *                considerar cadeia formatada quando <code>true</code>
     */
    public IESaoPauloValidator(boolean isFormatted) {
        this(new SimpleMessageProducer(), isFormatted);
    }

    public IESaoPauloValidator(MessageProducer messageProducer,
            boolean isFormatted) {
        comercioIndustriaValidator = new IESaoPauloComercioIndustriaValidator(
                null, isFormatted);
        produtorRuralValidator = new IESaoPauloProdutorRuralValidator(null,
                isFormatted);
        this.baseValidator = new BaseValidator<String>(messageProducer) {

            @Override
            protected List<InvalidValue> getInvalidValues(String value) {
                List<InvalidValue> result = null;
                if (value.startsWith("P")) {
                    result = produtorRuralValidator.getInvalidValues(value);
                } else {
                    result = comercioIndustriaValidator.getInvalidValues(value);
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
