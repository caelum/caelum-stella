package br.com.caelum.stella.bean.validation.logic;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleValidationMessage;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.InvalidValue;

/**
 * Recupera mensagens de validação definida na anotação do Hibernate
 * Validator.
 * 
 * @author Fabio Kung
 */
public class AnnotationMessageProducer implements MessageProducer {

    private final Annotation constraint;

    public AnnotationMessageProducer(final Annotation constraint) {
        this.constraint = constraint;
    }

    /**
     * This method will always return the same ValidationMessage, as Hibernate
     * Validator only let one message per Validator, defined inside the
     * constraint annotation.
     * 
     * @param invalidValue
     *            will be ignored
     * @return the message defined by the related constraint annotation
     */
    public ValidationMessage getMessage(final InvalidValue invalidValue) {
        try {
            Method constraintMessage = constraint.annotationType().getDeclaredMethod("message");
            constraintMessage.setAccessible(true);
            String message = constraintMessage.invoke(constraint).toString();
            return new SimpleValidationMessage(message);
        } catch (NoSuchMethodException e) {
            // same behavior as Hibernate Validator built-in validators
            // see
            // org.hibernate.validator.interpolator.DefaultMessageInterpolator
            throw new IllegalArgumentException("Annotation " + constraint
                    + " does not have an (accessible) message attribute");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
