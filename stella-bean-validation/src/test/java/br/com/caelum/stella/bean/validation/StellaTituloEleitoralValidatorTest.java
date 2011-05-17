package br.com.caelum.stella.bean.validation;

import static org.junit.Assert.assertTrue;

import javax.validation.ConstraintValidatorContext;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.caelum.stella.bean.validation.logic.StellaTituloEleitoralValidator;

/**
 * @author Leonardo Bessa
 */
public class StellaTituloEleitoralValidatorTest {
	private StellaTituloEleitoralValidator validator;
	private ConstraintValidatorContext context = Mockito
			.mock(ConstraintValidatorContext.class);

	private static class ObjectWithTituloEleitoral {
		@SuppressWarnings("unused")
		@TituloEleitoral
		private String tituloEleitoral;
	}

	@Before
	public void createValidator() throws Exception {
		TituloEleitoral tituloEleitoralAnnotation = ObjectWithTituloEleitoral.class
				.getDeclaredField("tituloEleitoral").getAnnotation(
						TituloEleitoral.class);
		validator = new StellaTituloEleitoralValidator();
		validator.initialize(tituloEleitoralAnnotation);
	}

	@Test
	public void shouldOnlyValidateStrings() {
		boolean valid = validator.isValid("253346440540", context);
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
