package br.com.caelum.stella.bean.validation.xml;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

import br.com.caelum.stella.bean.validation.xml.logic.StellaMaxElementsValidator;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.FIELD })
@Constraint(validatedBy = StellaMaxElementsValidator.class)
public @interface MaxElements {

    long value();

}
