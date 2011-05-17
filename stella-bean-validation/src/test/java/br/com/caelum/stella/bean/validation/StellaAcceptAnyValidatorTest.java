package br.com.caelum.stella.bean.validation;

import static org.junit.Assert.assertTrue;

import javax.validation.ConstraintValidatorContext;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.caelum.stella.bean.validation.AcceptAny;
import br.com.caelum.stella.bean.validation.logic.StellaAcceptAnyValidator;
import br.com.caelum.stella.validation.AcceptAnyValidator.Documento;

/**
 * @author Leonardo Bessa
 * @author David Paniz
 */
public class StellaAcceptAnyValidatorTest {
	private ConstraintValidatorContext context = Mockito.mock(ConstraintValidatorContext.class);
	private StellaAcceptAnyValidator validator;

	private static class ObjectWithAnnotation {
		@SuppressWarnings("unused")
		@AcceptAny(documentos = { Documento.CPF, Documento.CNPJ })
		private String cpfOrCnpj;
	}

	@Before
	public void createValidator() throws Exception {
		AcceptAny annotation = ObjectWithAnnotation.class.getDeclaredField("cpfOrCnpj").getAnnotation(AcceptAny.class);
		validator = new StellaAcceptAnyValidator();
		validator.initialize(annotation);
	}

	@Test
	public void shouldOnlyValidateStrings() {
		{
			boolean valid = validator.isValid("44474042000130", context);
			assertTrue(valid);
		}
		{
			boolean valid = validator.isValid("03118383402", context);
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
