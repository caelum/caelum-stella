package br.com.caelum.stella.hibernate.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.validation.AcceptAnyValidator.Documento;

/**
 * @author Leonardo Bessa
 */
public class StellaAcceptAnyValidatorTest {
	private StellaAcceptAnyValidator validator;

	private static class ObjectWithAnnotation {
		@SuppressWarnings("unused")
		@AcceptAny(documentos={Documento.CPF,Documento.CNPJ})
		private String cpfOrCnpj;
	}

	@Before
	public void createValidator() throws Exception {
		AcceptAny annotation = ObjectWithAnnotation.class.getDeclaredField(
				"cpfOrCnpj").getAnnotation(AcceptAny.class);
		validator = new StellaAcceptAnyValidator();
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
