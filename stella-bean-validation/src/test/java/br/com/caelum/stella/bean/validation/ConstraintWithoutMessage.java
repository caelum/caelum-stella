package br.com.caelum.stella.bean.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Fabio Kung
 */
@Documented
@Target( { FIELD, METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ConstraintWithoutMessage {
}
