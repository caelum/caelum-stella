package br.com.caelum.stella.hibernate.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.hibernate.validator.ValidatorClass;

/**
 * Restrição que pode ser associada a objetos em que o método {@linkplain #toString()} 
 * represente uma Inscrição Estadual de São Paulo.
 * @author Leonardo Bessa
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD, METHOD})
@ValidatorClass(StellaIncricaoEstadualDeSPValidator.class)
public @interface InscricaoEstadualSP {
	String message() default "{ie_invalid}";
	boolean formatted() default false;

}
