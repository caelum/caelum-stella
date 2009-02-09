package br.com.caelum.stella.hibernate.validator.logic;

import net.vidageek.mirror.Mirror;

import org.hibernate.validator.Validator;

import br.com.caelum.stella.hibernate.validator.IE;
import br.com.caelum.stella.type.Estado;

/**
 * Valida a cadeia gerada através do método {@linkplain #toString()} para
 * verificar se ela está de acordo com o padrão de Inscricao Estadual, no
 * estado epecificado.
 * 
 * @author Leonardo Bessa
 */
public class StellaIEValidator implements Validator<IE> {

    private br.com.caelum.stella.validation.Validator<String> stellaValidator;

    private IE ie;

    /**
     * @see org.hibernate.validator.Validator#initialize(java.lang.annotation.Annotation)
     */
    public void initialize(final IE ie) {
        this.ie = ie;
    }

    /**
     * @see org.hibernate.validator.Validator#isValid(java.lang.Object)
     */
    public boolean isValid(final Object obj) {
        if (obj != null) {
            String ieValue = getIEValue(obj);
            String estadoValue = getEstadoValue(obj);
            final AnnotationMessageProducer annotationMessageProducer = new AnnotationMessageProducer(ie);
            if (ieValue.trim().length() == 0) {
                return true;
            } else {
                try {
                    final Estado estado = Estado.valueOf(estadoValue);
                    stellaValidator = estado.getIEValidator(annotationMessageProducer, ie.formatted());
                } catch (IllegalArgumentException e) {
                    return false;
                }
                return stellaValidator.invalidMessagesFor(ieValue).isEmpty();
            }
        } else {
            return true;
        }
    }

    private String getEstadoValue(final Object obj) {
        return Mirror.on(obj).invoke().method(camelCaseGetFieldName(ie.estadoField())).withoutArgs().toString();
    }

    private String getIEValue(final Object obj) {
        return Mirror.on(obj).invoke().method(camelCaseGetFieldName(ie.ieField())).withoutArgs().toString();
    }

    private String camelCaseGetFieldName(final String fieldName) {
        return "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    }
}
