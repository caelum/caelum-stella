package br.com.caelum.stella.hibernate.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.hibernate.validator.ValidatorClass;

import br.com.caelum.stella.hibernate.validator.logic.StellaCNPJValidator;

/**
 * Restrição que pode ser associada a objetos em que o método
 * {@linkplain #toString()} represente um CNPJ.
 * 
 * @author Leonardo Bessa
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target( { FIELD, METHOD })
@ValidatorClass(StellaCNPJValidator.class)
public @interface CNPJ {
    String message() default "{cnpj_invalid}";

    boolean formatted() default false;

}
