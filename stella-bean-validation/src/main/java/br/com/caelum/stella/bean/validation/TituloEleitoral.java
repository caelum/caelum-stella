package br.com.caelum.stella.bean.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.caelum.stella.bean.validation.logic.StellaTituloEleitoralValidator;

/**
 * Restrição que pode ser associada a objetos em que o método
 * {@linkplain #toString()} represente um Título Eleitoral.
 * 
 * @author Leonardo Bessa
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ FIELD, METHOD })
@Constraint(validatedBy = StellaTituloEleitoralValidator.class)
public @interface TituloEleitoral {
	String message() default "{br.com.caelum.stella.bean.validation.TituloEleitoral.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
