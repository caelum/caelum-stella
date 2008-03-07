package br.com.caelum.stella.hibernate.validator;


import br.com.caelum.stella.ValidationMessage;
import junit.framework.Assert;
import static org.junit.Assert.fail;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author Fabio Kung
 */
public class AnnotationMessageProducerTest {
    private enum Errors {
        ANY, OTHER;
    }

    @Test
    public void shouldAlwaysRetrieveMessageFromAnnotationProperty() throws Exception {
        Field field = BeanToBeValidated.class.getDeclaredField("field");
        field.setAccessible(true);
        FakeConstraint constraint = field.getAnnotation(FakeConstraint.class);

        {
            AnnotationMessageProducer<Errors> producer = new AnnotationMessageProducer<Errors>(constraint);
            ValidationMessage validationMessage = producer.getMessage(Errors.ANY);
            Assert.assertEquals(constraint.message(), validationMessage.getMessage());
        }
        {
            AnnotationMessageProducer<Errors> producer = new AnnotationMessageProducer<Errors>(constraint);
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

        AnnotationMessageProducer<Errors> producer = new AnnotationMessageProducer<Errors>(constraint);
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
