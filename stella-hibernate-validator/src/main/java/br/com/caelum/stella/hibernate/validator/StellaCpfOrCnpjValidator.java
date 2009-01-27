package br.com.caelum.stella.hibernate.validator;

import org.hibernate.validator.Validator;

import br.com.caelum.stella.validation.CpfOrCnpjValidator;

/**
 * Valida a cadeia gerada através do método {@linkplain #toString()} para
 * verificar se ela está de acordo com o padrão de CPF ou CNPJ.
 * 
 * @author Leonardo Bessa
 */
public class StellaCpfOrCnpjValidator implements Validator<CpfOrCnpj> {
    private CpfOrCnpjValidator stellaValidator;

    /**
     * @see org.hibernate.validator.Validator#initialize(java.lang.annotation.Annotation)
     */
    public void initialize(CpfOrCnpj annotation) {
        AnnotationMessageProducer messageProducer = new AnnotationMessageProducer(annotation);
        stellaValidator = new CpfOrCnpjValidator(messageProducer, annotation.formatted());
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
