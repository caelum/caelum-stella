package br.com.caelum.stella.bean.validation.xml;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.caelum.stella.bean.validation.xml.logic.StellaChoiceValidator;

/**
 * Valida se o objeto anotado só tem um atributo (não primitivo)
 * diferente de null.
 * 
 * Valida todos os atributos, ou apenas os que estiverem anotados com 
 * {@linkplain ChoiceItem} 
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.TYPE })
@Constraint(validatedBy = StellaChoiceValidator.class)
public @interface Choice {
	
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
