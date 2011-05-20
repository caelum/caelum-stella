package br.com.caelum.stella.bean.validation.xml;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Size;

import br.com.caelum.stella.bean.validation.xml.logic.StellaLengthValidator;

/**
 * @deprecated Use {@linkplain Size} no lugar desta annotação
 */
@Deprecated

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.FIELD })
@Constraint(validatedBy = StellaLengthValidator.class)
public @interface Length {

    long max() default Long.MAX_VALUE;

    long min() default 0;
    
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
