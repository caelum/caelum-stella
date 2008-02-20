package br.com.caelum.stella.hibernate.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

/**
 * @Author Fabio Kung
 */
@Documented
@Target({FIELD, METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ConstraintWithoutMessage {
}
