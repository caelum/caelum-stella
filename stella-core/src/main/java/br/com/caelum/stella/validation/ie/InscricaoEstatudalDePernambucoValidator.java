package br.com.caelum.stella.validation.ie;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.validation.BaseValidator;
import br.com.caelum.stella.validation.InvalidValue;

import java.util.List;

public class InscricaoEstatudalDePernambucoValidator extends BaseValidator<String> {

    private final InscricaoEstatudalDePernambucoAntigaValidator antigaValidator;
    private final InscricaoEstatudalDePernambucoNovaValidator novaValidator;
    private final boolean formatted;

    /**
     * Este considera, por padrão, que as cadeias estão formatadas e utiliza um
     * {@linkplain SimpleMessageProducer} para geração de mensagens.
     */
    public InscricaoEstatudalDePernambucoValidator() {
        this(true);
    }

    /**
     * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
     * mensagens.
     *
     * @param formatted considerar cadeia formatada quando <code>true</code>
     */
    public InscricaoEstatudalDePernambucoValidator(boolean formatted) {
        this(new SimpleMessageProducer(), formatted);
    }

    public InscricaoEstatudalDePernambucoValidator(MessageProducer messageProducer, boolean formatted) {
        super(messageProducer);
        this.formatted = formatted;
        antigaValidator = new InscricaoEstatudalDePernambucoAntigaValidator(messageProducer, formatted);
        novaValidator = new InscricaoEstatudalDePernambucoNovaValidator(messageProducer, formatted);
    }

    protected List<InvalidValue> getInvalidValues(String value) {
        List<InvalidValue> result = null;
        // FIXME usar mais polimorfismo
        if (this.formatted) {
            if (InscricaoEstatudalDePernambucoAntigaValidator.FORMATED.matcher(value).matches()) {
                result = antigaValidator.getInvalidValues(value);
            } else {
                result = novaValidator.getInvalidValues(value);
            }
        } else {
            if (InscricaoEstatudalDePernambucoAntigaValidator.UNFORMATED.matcher(value).matches()) {
                result = antigaValidator.getInvalidValues(value);
            } else {
                result = novaValidator.getInvalidValues(value);
            }
        }
        return result;
    }
}
