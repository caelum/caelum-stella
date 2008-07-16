package br.com.caelum.stella.validation.ie;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.validation.BaseValidator;
import br.com.caelum.stella.validation.InvalidValue;
import br.com.caelum.stella.validation.error.IEError;

public class IERondoniaValidator extends BaseValidator<String> {

    private final IERondoniaCasoUmValidator casoUm;

    private final IERondoniaCasoDoisValidator casoDois;

    private boolean isFormatted;

    /**
     * Este considera, por padrão, que as cadeias estão formatadas e utiliza um
     * {@linkplain SimpleMessageProducer} para geração de mensagens.
     */
    public IERondoniaValidator() {
        this(true);
    }

    /**
     * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
     * mensagens.
     * 
     * @param isFormatted
     *                considerar cadeia formatada quando <code>true</code>
     */
    public IERondoniaValidator(boolean isFormatted) {
        this(new SimpleMessageProducer(), isFormatted);
    }

    public IERondoniaValidator(MessageProducer messageProducer,
            boolean isFormatted) {
        super(messageProducer);
        casoUm = new IERondoniaCasoUmValidator(messageProducer, isFormatted);
        casoDois = new IERondoniaCasoDoisValidator(messageProducer, isFormatted);
        this.isFormatted = isFormatted;
    }

    @SuppressWarnings("static-access")
    @Override
    protected List<InvalidValue> getInvalidValues(String ie) {
        List<InvalidValue> result = null;

        if (ie == null) {
            result = new ArrayList<InvalidValue>();
        } else {
            if (isFormatted) {
                if (casoDois.FORMATED.matcher(ie).matches()) {
                    result = casoDois.getInvalidValues(ie);
                } else if (casoUm.FORMATED.matcher(ie).matches()) {
                    result = casoUm.getInvalidValues(ie);
                }
            } else {
                if (casoUm.UNFORMATED.matcher(ie).matches()) {
                    result = casoUm.getInvalidValues(ie);
                } else if (casoDois.UNFORMATED.matcher(ie).matches()) {
                    result = casoDois.getInvalidValues(ie);
                }
            }
            if (result == null) {
                result = new ArrayList<InvalidValue>();
                result.add(IEError.INVALID_FORMAT);
            }
        }
        return result;
    }

}
