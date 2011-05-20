package br.com.caelum.stella.bean.validation.xml;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;

import br.com.caelum.stella.bean.validation.xml.logic.StellaRequiredValidator;

/**
 * @deprecated Use {@linkplain NotNull} no lugar desta annotação
 */
@Deprecated

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
@Constraint(validatedBy = StellaRequiredValidator.class)
public @interface Required {

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
