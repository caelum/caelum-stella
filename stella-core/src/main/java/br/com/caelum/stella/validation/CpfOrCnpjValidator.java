package br.com.caelum.stella.validation;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.ValidationMessage;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: leonardobessa
 * Date: Jan 26, 2009
 * Time: 4:29:57 PM
 */
public class CpfOrCnpjValidator implements Validator<String> {

    private LogicOrComposedValidator<String> validator;

    /**
     * Este considera, por padrão, que as cadeias estão formatadas e utiliza um
     * {@linkplain br.com.caelum.stella.SimpleMessageProducer} para geração de mensagens.
     */
    public CpfOrCnpjValidator() {
        this(true);
    }

    /**
     * O validador utiliza um {@linkplain br.com.caelum.stella.SimpleMessageProducer} para geração de
     * mensagens.
     *
     * @param isFormatted se for true, considera cadeia formatada;
     */
    public CpfOrCnpjValidator(boolean isFormatted) {
        validator = new LogicOrComposedValidator(new SimpleMessageProducer(), isFormatted, CNPJValidator.class, CPFValidator.class);
    }

    /**
     * <p>
     * Construtor do Validador de CPF ou CNPJ.
     * </p>
     *
     * @param messageProducer produtor de mensagem de erro.
     * @param isFormatted     se for true, considera cadeia formatada;
     */
    public CpfOrCnpjValidator(MessageProducer messageProducer, boolean isFormatted) {
        validator = new LogicOrComposedValidator(messageProducer, isFormatted, CNPJValidator.class, CPFValidator.class);
    }

    public void assertValid(String value) {
        validator.assertValid(value);
    }

    public List<ValidationMessage> invalidMessagesFor(String value) {
        return validator.invalidMessagesFor(value);
    }

    public boolean isEligible(String object) {
        return validator.isEligible(object);
    }

    public void setInvalidFormat(InvalidValue invalidFormat) {
        validator.setInvalidFormat(invalidFormat);
    }
}
