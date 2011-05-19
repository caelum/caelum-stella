package br.com.caelum.stella.bean.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class StellaCNPJBeanValidationTest {
	
	private static Validator	validator;

	public class Modelo{
		@CNPJ
		private String cnpj;

		public String getCnpj() {
			return cnpj;
		}

		public void setCnpj(String cnpj) {
			this.cnpj = cnpj;
		}

	}
	
	@BeforeClass
	public static void setUp() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}
 
	@Test
	public void testCPFValidoDeveTerListaDeErrosVazia() {
		Modelo modelo = new Modelo();
		modelo.setCnpj("63025530002409");
		
		Set<ConstraintViolation<Modelo>> violations = validator.validate(modelo);
		Assert.assertEquals(0, violations.size()); 
													
	}
	
	@Test
	public void testCpfInvalidoDeveRetornar1Erro(){

		Modelo modelo = new Modelo();
		modelo.setCnpj("63025530002402");
		
		Set<ConstraintViolation<Modelo>> violations = validator.validate(modelo);
		Assert.assertEquals(1, violations.size()); 
		
	}

}
