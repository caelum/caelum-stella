package br.com.caelum.stella.bean.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class StellaTituloEleitoralBeanValidationTest {
	
	private static Validator	validator;
	
	@SuppressWarnings("unused")
	private static class Modelo {
		@TituloEleitoral
		private String tituloEleitoral;

		public String getTituloEleitoral() {
			return tituloEleitoral;
		}

		public void setTituloEleitoral(String tituloEleitoral) {
			this.tituloEleitoral = tituloEleitoral;
		}
		
	}
	
	@BeforeClass
	public static void setUp() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}
 
	@Test
	public void testCPFValidoDeveTerListaDeErrosVazia() {
		Modelo modelo = new Modelo();
		modelo.setTituloEleitoral("253346440540");
		
		Set<ConstraintViolation<Modelo>> violations = validator.validate(modelo);
		Assert.assertEquals(0, violations.size()); 
													
	}
	
	@Test
	public void testCpfInvalidoDeveRetornar1Erro(){

		Modelo modelo = new Modelo();
		modelo.setTituloEleitoral("253346445540");
		
		Set<ConstraintViolation<Modelo>> violations = validator.validate(modelo);
		Assert.assertEquals(1, violations.size()); 
		
	}

}
