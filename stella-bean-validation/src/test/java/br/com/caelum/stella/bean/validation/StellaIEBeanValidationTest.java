package br.com.caelum.stella.bean.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class StellaIEBeanValidationTest {
	
	private static Validator	validator;
	
	@BeforeClass
	public static void setUp() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}
 
	@Test
	public void testCPFValidoDeveTerListaDeErrosVazia() {
		ObjectWithIE IEDeSaoPaulo = new ObjectWithIE("P011004243002", "SP");
		
		Set<ConstraintViolation<ObjectWithIE>> violations = validator.validate(IEDeSaoPaulo);
		Assert.assertEquals(0, violations.size()); 
													
	}
	
	@Test
	public void testCpfInvalidoDeveRetornar1Erro(){
		
		ObjectWithIE IEDeSaoPauloInvalido = new ObjectWithIE("P012004243002", "SP");
		
		
		Set<ConstraintViolation<ObjectWithIE>> violations = validator.validate(IEDeSaoPauloInvalido);
		Assert.assertEquals(1, violations.size()); 
		
	}

}
