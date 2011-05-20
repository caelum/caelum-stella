package br.com.caelum.stella.bean.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class StellaNITBeanValidationTest {
	
	private static Validator	validator;

	@SuppressWarnings("unused")
	private static class Modelo {
		@NIT
		private String nit;

		public String getNit() {
			return nit;
		}

		public void setNit(String nit) {
			this.nit = nit;
		}
		
	}
	
	@BeforeClass
	public static void setUp() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}
 
	@Test
	public void testCPFValidoDeveTerListaDeErrosVazia() {
		Modelo modelo = new Modelo();
		modelo.setNit("12345678919");
		
		Set<ConstraintViolation<Modelo>> violations = validator.validate(modelo);
		Assert.assertEquals(0, violations.size()); 
													
	}
	
	@Test
	public void testCpfInvalidoDeveRetornar1Erro(){

		Modelo modelo = new Modelo();
		modelo.setNit("12345678932");
		
		Set<ConstraintViolation<Modelo>> violations = validator.validate(modelo);
		Assert.assertEquals(1, violations.size()); 
		
	}

}
