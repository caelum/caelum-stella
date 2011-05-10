package br.com.caelum.stella.hibernate.validator.logic;

import org.hibernate.validator.Validator;

import br.com.caelum.stella.hibernate.validator.TituloEleitoral;
import br.com.caelum.stella.validation.TituloEleitoralValidator;

/**
 * Valida a cadeia gerada através do método {@linkplain #toString()} para
 * verificar se ela está de acordo com o padrão de Título Eleitoral.
 * 
 * @author Leonardo Bessa
 */
public class StellaTituloEleitoralValidator implements Validator<TituloEleitoral> {
    private TituloEleitoralValidator stellaValidator;

    /**
     * @see org.hibernate.validator.Validator#initialize(java.lang.annotation.Annotation)
     */
    public void initialize(TituloEleitoral tituloEleitoral) {
        AnnotationMessageProducer messageProducer = new AnnotationMessageProducer(tituloEleitoral);
        stellaValidator = new TituloEleitoralValidator(messageProducer);
    }

    /**
     * @see org.hibernate.validator.Validator#isValid(java.lang.Object)
     */
    public boolean isValid(Object o) {
        if (o != null) {
            String tituloEleitoral = o.toString();
            if (tituloEleitoral.trim().length() == 0) {
                return true;
            } else {
                return stellaValidator.invalidMessagesFor(tituloEleitoral).isEmpty();
            }
        } else {
            return true;
        }
    }
}
