package br.com.caelum.stella.hibernate.validator;

import org.hibernate.validator.ValidatorClass;

import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Restrição que pode ser associada a objetos em que o método {@linkplain #toString()} 
 * represente um CPF.
 *
 * @author Fabio Kung
 * @author Leonardo Bessa
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD, METHOD})
@ValidatorClass(StellaCPFValidator.class)
public @interface CPF {
    String message() default "{cpf_invalid}";
    boolean formatted() default false;
}
