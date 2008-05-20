package br.com.caelum.stella.validation;

import java.util.List;

import br.com.caelum.stella.MessageProducer;

public class InscricaoEstatudalDeRondoniaValidator extends
        AbstractValidator<String> {

    private final InscricaoEstatudalDeRondoniaValidatorCaso1 caso1;
    private final InscricaoEstatudalDeRondoniaValidatorCaso2 caso2;

    public InscricaoEstatudalDeRondoniaValidator(
            MessageProducer messageProducer, boolean isFormatted) {
        super(messageProducer);
        caso1 = new InscricaoEstatudalDeRondoniaValidatorCaso1(messageProducer,
                isFormatted);
        caso2 = new InscricaoEstatudalDeRondoniaValidatorCaso2(messageProducer,
                isFormatted);
    }

    @Override
    protected List<InvalidValue> getInvalidValues(String ie) {
        List<InvalidValue> result = null;
        List<InvalidValue> invalidValuesNoCaso2 = caso2.getInvalidValues(ie);
        if (invalidValuesNoCaso2.isEmpty()) {
            result = invalidValuesNoCaso2;
        } else {
            List<InvalidValue> invalidValuesNoCaso1 = caso1
                    .getInvalidValues(ie);
            if (invalidValuesNoCaso1.isEmpty()) {
                result = invalidValuesNoCaso1;
            } else {
                result = invalidValuesNoCaso2;
            }
        }
        return result;
    }

}
