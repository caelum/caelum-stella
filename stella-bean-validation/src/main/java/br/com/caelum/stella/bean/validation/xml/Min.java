package br.com.caelum.stella.bean.validation.xml;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.caelum.stella.bean.validation.xml.logic.StellaMinValidator;

/**
 * @deprecated Use {@linkplain javax.validation.constraints.Min} no lugar desta annotação
 */
@Deprecated

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
@Constraint(validatedBy = StellaMinValidator.class)
public @interface Min {

	long value();

	Class<?>[] groups() default {};
	
    Class<? extends Payload>[] payload() default {};

	
}
