package br.com.caelum.stella.bean.validation.xml.logic;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.caelum.stella.bean.validation.xml.Max;

/**
 * @deprecated Anotação deste validador está obsoleta
 */
@Deprecated

final public class StellaMaxValidator implements ConstraintValidator<Max, Number> {

	private Max annotation;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private final List<Class<?>> acceptedTypes = (List) Arrays.asList(Byte.class, Short.class, Integer.class,
			Long.class);

	public void initialize(final Max annotation) {
		this.annotation = annotation;

	}

	public boolean isValid(final Number object, ConstraintValidatorContext context) {
		if (object == null) {
			return true;
		}

		if (!acceptedTypes.contains(object.getClass())) {
			throw new IllegalStateException(Max.class.getSimpleName() + " cannot be used to annotate a field of type "
					+ object.getClass().getName() + ". Only " + Arrays.toString(acceptedTypes.toArray())
					+ " are accepted.");
		}

		Long val = Long.parseLong(object.toString());

		if (val > annotation.value()) {
			return false;
		}

		return true;
	}
}
