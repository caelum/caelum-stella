package br.com.caelum.stella.bean.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.caelum.stella.bean.validation.logic.StellaCNPJValidator;

/**
 * Restrição que pode ser associada a objetos em que o método
 * {@linkplain #toString()} represente um CNPJ.
 * 
 * @author Leonardo Bessa
 * @author David Paniz
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target( { FIELD, METHOD })
@Constraint(validatedBy = StellaCNPJValidator.class)
public @interface CNPJ {
    String message() default "{br.com.caelum.stella.bean.validation.CNPJ.message}";

    boolean formatted() default false;
    
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
