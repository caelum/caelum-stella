package br.com.caelum.stella.hibernate.validator.xml;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.hibernate.validator.ValidatorClass;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.FIELD })
@ValidatorClass(StellaLengthValidator.class)
public @interface Length {

    long max() default Long.MAX_VALUE;

    long min() default 0;

}
