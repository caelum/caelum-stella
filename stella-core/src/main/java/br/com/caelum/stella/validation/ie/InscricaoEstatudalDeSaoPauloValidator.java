package br.com.caelum.stella.validation.ie;

import java.util.List;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.Validator;
import br.com.caelum.stella.validation.BaseValidator;
import br.com.caelum.stella.validation.InvalidValue;

public class InscricaoEstatudalDeSaoPauloValidator implements Validator<String> {

    private final InscricaoEstatudalDeSaoPauloParaComercioIndustriaValidator comercioIndustriaValidator;
    private final InscricaoEstatudalDeSaoPauloParaProdutorRuralValidator produtorRuralValidator;
    private final BaseValidator<String> baseValidator;
    
    /**
     * Este considera, por padrão, que as cadeias estão formatadas e utiliza um
     * {@linkplain SimpleMessageProducer} para geração de mensagens.
     */
    public InscricaoEstatudalDeSaoPauloValidator() {
        this(true);
    }

    /**
     * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
     * mensagens.
     * 
     * @param isFormatted
     *                considerar cadeia formatada quando <code>true</code>
     */
    public InscricaoEstatudalDeSaoPauloValidator(boolean isFormatted) {
        this(new SimpleMessageProducer(),isFormatted);
    }

    public InscricaoEstatudalDeSaoPauloValidator(
            MessageProducer messageProducer, boolean isFormatted) {
        comercioIndustriaValidator = new InscricaoEstatudalDeSaoPauloParaComercioIndustriaValidator(
                null, isFormatted);
        produtorRuralValidator = new InscricaoEstatudalDeSaoPauloParaProdutorRuralValidator(
                null, isFormatted);
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
