package br.com.caelum.stella.bean.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.validation.ConstraintValidatorContext;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.caelum.stella.bean.validation.CNPJ;
import br.com.caelum.stella.bean.validation.logic.StellaCNPJValidator;

/**
 * @author Leonardo Bessa
 * @author David Paniz
 */
public class StellaCNPJValidatorTest {
	private ConstraintValidatorContext context = Mockito.mock(ConstraintValidatorContext.class);
	private StellaCNPJValidator validator;
	private StellaCNPJValidator validatorFormatted;

	private static class ObjectWithCNPJ {
		@SuppressWarnings("unused")
		@CNPJ
		private String cnpj;
	}

	private static class ObjectWithCNPJFormatted {
		@SuppressWarnings("unused")
		@CNPJ(formatted = true)
		private String cnpj;
	}

	@Before
	public void createValidator() throws Exception {
		CNPJ cnpjAnnotation = ObjectWithCNPJ.class.getDeclaredField("cnpj").getAnnotation(CNPJ.class);
		validator = new StellaCNPJValidator();
		validator.initialize(cnpjAnnotation);

		cnpjAnnotation = ObjectWithCNPJFormatted.class.getDeclaredField("cnpj").getAnnotation(CNPJ.class);
		validatorFormatted = new StellaCNPJValidator();
		validatorFormatted.initialize(cnpjAnnotation);
	}

	@Test
	public void shouldOnlyValidateStrings() {
		{
			boolean valid = validator.isValid("44474042000130", context);
			assertTrue(valid);
		}

		{
			//value formatted but expected not formatted
			boolean valid = validator.isValid("44.474.042/0001-30", context);
			assertFalse(valid);
		}
	}

	@Test
	public void shouldOnlyValidateStringsFormatted() {
		{
			//value not formatted but expected formatted
			boolean valid = validatorFormatted.isValid("44474042000130", context);
			assertFalse(valid);
		}

		{
			boolean valid = validatorFormatted.isValid("44.474.042/0001-30", context);
			assertTrue(valid);
		}
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
