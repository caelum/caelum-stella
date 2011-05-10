package br.com.caelum.stella.hibernate.validator.logic;

import org.hibernate.validator.Validator;

import br.com.caelum.stella.hibernate.validator.AcceptAny;
import br.com.caelum.stella.validation.AcceptAnyValidator;

/**
 * Valida a cadeia gerada através do método {@linkplain #toString()} para
 * verificar se ela está de acordo com o padrão de qualquer um dos documentos
 *  passados como parametro.
 * 
 * @author Leonardo Bessa
 */
public class StellaAcceptAnyValidator implements Validator<AcceptAny> {
    private AcceptAnyValidator stellaValidator;

    /**
     * @see org.hibernate.validator.Validator#initialize(java.lang.annotation.Annotation)
     */
    public void initialize(AcceptAny annotation) {
        AnnotationMessageProducer messageProducer = new AnnotationMessageProducer(annotation);
        stellaValidator = new AcceptAnyValidator(messageProducer, annotation.formatted(), annotation.documentos());
    }

    /**
     * @see org.hibernate.validator.Validator#isValid(java.lang.Object)
     */
    public boolean isValid(Object o) {
        if (o != null) {
            String candidato = o.toString();
            if (candidato.trim().length() == 0) {
                return true;
            } else {
                return stellaValidator.invalidMessagesFor(candidato).isEmpty();
            }
        } else {
            return true;
        }
    }
}
