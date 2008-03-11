package br.com.caelum.stella.hibernate.validator;

import org.hibernate.validator.Validator;

import br.com.caelum.stella.validation.CNPJError;
import br.com.caelum.stella.validation.CNPJValidator;


/**
 * @author Fabio Kung
 * @author Leonardo Bessa
 */
public class StellaCNPJValidator implements Validator<CNPJ> {
    private CNPJValidator stellaValidator;

    public void initialize(CNPJ cnpj) {
        AnnotationMessageProducer<CNPJError> messageProducer = new AnnotationMessageProducer<CNPJError>(cnpj);
        stellaValidator = new CNPJValidator(messageProducer, cnpj.formatted());
    }

    public boolean isValid(Object o) {
        if (o != null) {
            String cnpj = o.toString();
            if (cnpj.trim().length() == 0) {
                return true;
            } else {
                return stellaValidator.validate(cnpj);
            }
        } else {
            return true;
        }
    }
}
