package br.com.caelum.stella.hibernate.validator;

import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author Fabio Kung
 */
@Documented
@Target({FIELD, METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface FakeConstraint {
    String message() default "validation message";
}
