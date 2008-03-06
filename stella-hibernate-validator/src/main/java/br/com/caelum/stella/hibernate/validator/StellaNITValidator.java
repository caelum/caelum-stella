package br.com.caelum.stella.hibernate.validator;

import org.hibernate.validator.Validator;

import br.com.caelum.stella.validation.NITError;
import br.com.caelum.stella.validation.NITValidator;


/**
 * @Author Leonardo Bessa
 */
public class StellaNITValidator implements Validator<NIT> {
    private NITValidator stellaValidator;

    public void initialize(NIT nit) {
        AnnotationMessageProducer<NITError> messageProducer = new AnnotationMessageProducer<NITError>(nit);
        stellaValidator = new NITValidator(messageProducer,nit.formatted());
    }

    public boolean isValid(Object o) {
        if (o != null) {
            String nit = o.toString();
            if (nit.trim().length() == 0) {
                return true;
            } else {
                return stellaValidator.validate(nit);
            }
        } else {
            return true;
        }
    }

}
