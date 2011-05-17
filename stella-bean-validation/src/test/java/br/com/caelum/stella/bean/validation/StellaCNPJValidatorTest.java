package br.com.caelum.stella.bean.validation;

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

	private static class ObjectWithCNPJ {
		@SuppressWarnings("unused")
		@CNPJ
		private String cnpj;
	}

	@Before
	public void createValidator() throws Exception {
		CNPJ cnpjAnnotation = ObjectWithCNPJ.class.getDeclaredField("cnpj").getAnnotation(CNPJ.class);
		validator = new StellaCNPJValidator();
		validator.initialize(cnpjAnnotation);
	}

	@Test
	public void shouldOnlyValidateStrings() {
		{
			boolean valid = validator.isValid("44474042000130", context);
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
