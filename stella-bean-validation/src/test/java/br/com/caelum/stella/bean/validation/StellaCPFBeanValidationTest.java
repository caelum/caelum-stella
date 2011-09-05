package br.com.caelum.stella.bean.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class StellaCPFBeanValidationTest {
	
	private static Validator	validator;

	public class Modelo{
		@CPF
		private String cpf;

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		
	}
	
	@BeforeClass
	public static void setUp() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}
 
	@Test
	public void testCPFValidoDeveTerListaDeErrosVazia() {
		Modelo modelo = new Modelo();
		modelo.setCpf("03118383402");
		
		Set<ConstraintViolation<Modelo>> violations = validator.validate(modelo);
		Assert.assertEquals(0, violations.size()); 
													
	}
	
	@Test
	public void testCpfInvalidoDeveRetornar1Erro(){

		Modelo modelo = new Modelo();
		modelo.setCpf("02338383402");
		
		Set<ConstraintViolation<Modelo>> violations = validator.validate(modelo);
		Assert.assertEquals(1, violations.size()); 
	}
	
	@Test
	public void testCpfComTodosDigitosIguaisDeveRetornar1Erro(){

		Modelo modelo = new Modelo();
		modelo.setCpf("11111111111");
		
		Set<ConstraintViolation<Modelo>> violations = validator.validate(modelo);
		Assert.assertEquals(1, violations.size()); 
	}

}
