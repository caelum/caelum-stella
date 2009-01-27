package br.com.caelum.stella.hibernate.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.hibernate.validator.ValidatorClass;

/**
 * Restrição que pode ser associada a objetos em que o método
 * {@linkplain #toString()} represente um CPF ou CNPJ.
 * 
 * @author Leonardo Bessa
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target( { FIELD, METHOD })
@ValidatorClass(StellaCpfOrCnpjValidator.class)
public @interface CpfOrCnpj {
    String message() default "{cpf_or_cnpj_invalid}";

    boolean formatted() default false;

}
