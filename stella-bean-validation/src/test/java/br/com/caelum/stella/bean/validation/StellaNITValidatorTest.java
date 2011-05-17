package br.com.caelum.stella.bean.validation;

import static org.junit.Assert.assertTrue;

import javax.validation.ConstraintValidatorContext;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.caelum.stella.bean.validation.logic.StellaNITValidator;

/**
 * @author Leonardo Bessa
 * @author Fabio Kung
 */
public class StellaNITValidatorTest {

	private StellaNITValidator validator;
	private ConstraintValidatorContext context = Mockito
			.mock(ConstraintValidatorContext.class);

	private static class ObjectWithNIT {
		@SuppressWarnings("unused")
		@NIT
		private String nit;
	}

	@Before
	public void createValidator() throws Exception {
		NIT nitAnnotation = ObjectWithNIT.class.getDeclaredField("nit")
				.getAnnotation(NIT.class);
		validator = new StellaNITValidator();
		validator.initialize(nitAnnotation);
	}

	@Test
	public void shouldOnlyValidateStrings() {
		boolean valid = validator.isValid("34608514300", context);
		assertTrue(valid);
	}

	@Test
	public void shouldValidateNull() {
		boolean valid = validator.isValid(null, context);
		assertTrue(valid);
	}

	@Test
	public void shouldValidateEmpty() {
		boolean valid = validator.isValid("", context);
		assertTrue(valid);
	}
}
