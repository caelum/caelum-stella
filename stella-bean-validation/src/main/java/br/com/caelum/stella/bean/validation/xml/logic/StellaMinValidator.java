package br.com.caelum.stella.bean.validation.xml.logic;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.caelum.stella.bean.validation.xml.Min;

/**
 * @deprecated Anotação deste validador está obsoleta
 */
@Deprecated

final public class StellaMinValidator implements
		ConstraintValidator<Min, Number> {

	private Min annotation;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private final List<Class<?>> acceptedTypes = (List) Arrays.asList(
			Byte.class, Short.class, Integer.class, Long.class);

	public void initialize(final Min annotation) {
		this.annotation = annotation;

	}

	public boolean isValid(Number value, ConstraintValidatorContext context) {
		if (value == null) {
			return true;
		}

		if (!acceptedTypes.contains(value.getClass())) {
			throw new IllegalStateException(Min.class.getSimpleName()
					+ " cannot be used to annotate a field of type "
					+ value.getClass().getName()
					+ ". Only Byte, Short, Integer and Long are accepted.");
		}

		Long val = new Long(value.toString());

		if (val < annotation.value()) {
			return false;
		}

		return true;
	}
}
