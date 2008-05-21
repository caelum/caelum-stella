package br.com.caelum.stella.validation.ie;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.validation.BaseValidator;
import br.com.caelum.stella.validation.InvalidValue;

import java.util.List;

public class IEPernambucoValidator extends BaseValidator<String> {

    private final IEPernambucoAntigaValidator antigaValidator;
    private final IEPernambucoNovaValidator novaValidator;
    private final boolean formatted;

    /**
     * Este considera, por padrão, que as cadeias estão formatadas e utiliza um
     * {@linkplain SimpleMessageProducer} para geração de mensagens.
     */
    public IEPernambucoValidator() {
        this(true);
    }

    /**
     * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
     * mensagens.
     *
     * @param formatted considerar cadeia formatada quando <code>true</code>
     */
    public IEPernambucoValidator(boolean formatted) {
        this(new SimpleMessageProducer(), formatted);
    }

    public IEPernambucoValidator(MessageProducer messageProducer, boolean formatted) {
        super(messageProducer);
        this.formatted = formatted;
        antigaValidator = new IEPernambucoAntigaValidator(messageProducer, formatted);
        novaValidator = new IEPernambucoNovaValidator(messageProducer, formatted);
    }

    protected List<InvalidValue> getInvalidValues(String value) {
        List<InvalidValue> result = null;
        // FIXME usar mais polimorfismo
        if (this.formatted) {
            if (IEPernambucoAntigaValidator.FORMATED.matcher(value).matches()) {
                result = antigaValidator.getInvalidValues(value);
            } else {
                result = novaValidator.getInvalidValues(value);
            }
        } else {
            if (IEPernambucoAntigaValidator.UNFORMATED.matcher(value).matches()) {
                result = antigaValidator.getInvalidValues(value);
            } else {
                result = novaValidator.getInvalidValues(value);
            }
        }
        return result;
    }
}
