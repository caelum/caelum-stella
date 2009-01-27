package br.com.caelum.stella.hibernate.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Leonardo Bessa
 */
public class StellaCpfOrCnpjValidatorTest {
	private StellaCpfOrCnpjValidator validator;

	private static class ObjectWithAnnotation {
		@SuppressWarnings("unused")
		@CpfOrCnpj
		private String cpfOrCnpj;
	}

	@Before
	public void createValidator() throws Exception {
		CpfOrCnpj annotation = ObjectWithAnnotation.class.getDeclaredField(
				"cpfOrCnpj").getAnnotation(CpfOrCnpj.class);
		validator = new StellaCpfOrCnpjValidator();
		validator.initialize(annotation);
	}

	@Test
	public void shouldOnlyValidateStrings() {
		{
			boolean valid = validator.isValid(new Object());
			assertFalse(valid);
		}
		{
			boolean valid = validator.isValid(14);
			assertFalse(valid);
		}
		{
			boolean valid = validator.isValid("44474042000130");
			assertTrue(valid);
		}
        {
            boolean valid = validator.isValid("03118383402");
            assertTrue(valid);
        }
	}

	@Test
	public void shouldValidateNull() {
		boolean valid = validator.isValid(null);
		assertTrue(valid);
	}

	@Test
	public void shouldValidateEmpty() {
		boolean valid = validator.isValid("");
		assertTrue(valid);
	}

}
