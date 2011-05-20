package br.com.caelum.stella.bean.validation.xml;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Payload;


/**
 * Marca um atributo para ser verificado pelo 
 * {@linkplain Choice} 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.FIELD })
public @interface ChoiceItem {
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
