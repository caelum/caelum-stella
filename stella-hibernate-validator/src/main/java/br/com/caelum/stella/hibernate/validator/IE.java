package br.com.caelum.stella.hibernate.validator;

import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.hibernate.validator.ValidatorClass;

/**
 * Restrição que pode ser associada a classes que contenham um objeto que
 * represente uma Inscricao Estadual e outro objeto identificando o estado a que
 * este documento pertence.
 * 
 * @author Leonardo Bessa
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target( { TYPE })
@ValidatorClass(StellaIEValidator.class)
public @interface IE {
    String message() default "{ie_invalid}";

    String ieField() default "ie";

    String estadoField() default "estado";

    boolean formatted() default false;

}
