package br.com.caelum.stella.validation;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.validation.error.IEError;

public class InscricaoEstatudalDeRondoniaValidator extends
        AbstractValidator<String> {

    private final InscricaoEstatudalDeRondoniaValidatorCaso1 caso1;
    private final InscricaoEstatudalDeRondoniaValidatorCaso2 caso2;
    private boolean isFormatted;

    /**
     * Este considera, por padrão, que as cadeias estão formatadas e utiliza um
     * {@linkplain SimpleMessageProducer} para geração de mensagens.
     */
    public InscricaoEstatudalDeRondoniaValidator() {
        this(true);
    }

    /**
     * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
     * mensagens.
     * 
     * @param isFormatted
     *                considerar cadeia formatada quando <code>true</code>
     */
    public InscricaoEstatudalDeRondoniaValidator(boolean isFormatted) {
        this(new SimpleMessageProducer(), isFormatted);
    }

    public InscricaoEstatudalDeRondoniaValidator(
            MessageProducer messageProducer, boolean isFormatted) {
        super(messageProducer);
        caso1 = new InscricaoEstatudalDeRondoniaValidatorCaso1(messageProducer,
                isFormatted);
        caso2 = new InscricaoEstatudalDeRondoniaValidatorCaso2(messageProducer,
                isFormatted);
        this.isFormatted = isFormatted;
    }

    @SuppressWarnings("static-access")
    @Override
    protected List<InvalidValue> getInvalidValues(String ie) {
        List<InvalidValue> result = null;
        
        if (ie==null) {
            result = new ArrayList<InvalidValue>();
        } else {
            if (isFormatted) {
                if (caso2.FORMATED.matcher(ie).matches()) {
                    result = caso2.getInvalidValues(ie);
                } else if (caso1.FORMATED.matcher(ie).matches()) {
                    result = caso1.getInvalidValues(ie);
                }
            } else {
                if (caso1.UNFORMATED.matcher(ie).matches()) {
                    result = caso1.getInvalidValues(ie);
                } else if (caso2.UNFORMATED.matcher(ie).matches()) {
                    result = caso2.getInvalidValues(ie);
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
