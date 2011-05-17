package br.com.caelum.stella.bean.validation;

import static org.junit.Assert.fail;

import java.lang.reflect.Field;

import junit.framework.Assert;

import org.junit.Test;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.bean.validation.logic.AnnotationMessageProducer;
import br.com.caelum.stella.validation.InvalidValue;

/**
 * @author Fabio Kung
 */
public class AnnotationMessageProducerTest {
    private enum Errors implements InvalidValue {
        ANY, OTHER;
    }

    @Test
    public void shouldAlwaysRetrieveMessageFromAnnotationProperty() throws Exception {
        Field field = BeanToBeValidated.class.getDeclaredField("field");
        field.setAccessible(true);
        FakeConstraint constraint = field.getAnnotation(FakeConstraint.class);

        {
            AnnotationMessageProducer producer = new AnnotationMessageProducer(constraint);
            ValidationMessage validationMessage = producer.getMessage(Errors.ANY);
            Assert.assertEquals(constraint.message(), validationMessage.getMessage());
        }
        {
            AnnotationMessageProducer producer = new AnnotationMessageProducer(constraint);
            ValidationMessage validationMessage = producer.getMessage(Errors.OTHER);
            Assert.assertEquals(constraint.message(), validationMessage.getMessage());
        }
    }

    @Test
    // as Hibernate Validator
    public void shouldThrowIllegalArgumentExceptionIfConstraintHasNoMessage() throws Exception {
        Field field = BeanToBeValidated.class.getDeclaredField("other");
        field.setAccessible(true);
        ConstraintWithoutMessage constraint = field.getAnnotation(ConstraintWithoutMessage.class);

        AnnotationMessageProducer producer = new AnnotationMessageProducer(constraint);
        try {
            @SuppressWarnings("unused")
            ValidationMessage validationMessage = producer.getMessage(Errors.ANY);
            fail();
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            // any other exception should fail
            fail();
        }
    }

}
