package br.com.caelum.stella.hibernate.validator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.hibernate.validator.Validator;

import br.com.caelum.stella.type.Estado;
import br.com.caelum.stella.validation.ie.IEValidator;

/**
 * Valida a cadeia gerada através do método {@linkplain #toString()} para
 * verificar se ela está de acordo com o padrão de Inscricao Estadual, no estado epecificado.
 *
 * @author Leonardo Bessa
 */
public class StellaIEValidator implements Validator<IE> {

    private IEValidator stellaValidator;

    private IE ie;

    /**
     * @see org.hibernate.validator.Validator#initialize(java.lang.annotation.Annotation)
     */
    public void initialize(IE ie) {
        this.ie = ie;
    }

    /**
     * @see org.hibernate.validator.Validator#isValid(java.lang.Object)
     */
    public boolean isValid(Object obj) {
        try {
            if (obj != null) {
                String ieValue = getIEValue(obj);
                String estadoValue = getEstadoValue(obj);
                final AnnotationMessageProducer annotationMessageProducer = new AnnotationMessageProducer(
                        ie);
                if (ieValue.trim().length() == 0) {
                    return true;
                } else {
                    try {
                        final Estado estado = Estado.valueOf(estadoValue);
                        stellaValidator = new IEValidator(estado,
                                annotationMessageProducer, ie.formatted());
                    } catch (IllegalArgumentException e) {
                        return false;
                    }
                    return stellaValidator.invalidMessagesFor(ieValue)
                            .isEmpty();
                }
            } else {
                return true;
            }
        } catch (SecurityException e) {
            throw new RuntimeException(e.getCause());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e.getCause());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e.getCause());
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    private String getEstadoValue(Object obj) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException {
        Method getEstadoMethod = obj.getClass().getMethod(
                camelCaseGetFieldName(ie.estadoField()));
        String estadoValue = (String) getEstadoMethod.invoke(obj);
        return estadoValue;
    }

    private String getIEValue(Object obj) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException {
        Method getIeMethod = obj.getClass().getMethod(
                camelCaseGetFieldName(ie.ieField()));
        String ieValue = (String) getIeMethod.invoke(obj);
        return ieValue;
    }

    private String camelCaseGetFieldName(String fieldName) {
        return "get" + fieldName.substring(0, 1).toUpperCase()
                + fieldName.substring(1);
    }
}
