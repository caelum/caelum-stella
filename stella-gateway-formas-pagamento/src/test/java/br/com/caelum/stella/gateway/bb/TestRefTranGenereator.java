package br.com.caelum.stella.gateway.bb;

import junit.framework.Assert;

import org.junit.Test;

public class TestRefTranGenereator {

	@Test
	public void testRefTranGeneratorComCodigoDeConvenioDeCobrancaENumeroDoUsuario(){
		Assert.assertEquals("12345678901234567",new RefTranGenerator().geraRefTran(1234567,"8901234567"));
	}
	
	@Test
	public void testRefTranGeneratorComCodigoDeConvenioDeCobrancaMenorQue7DigitosENumeroDoUsuario(){
		Assert.assertEquals("12345670000000000",new RefTranGenerator().geraRefTran(123456,"1234567"));
	}
	
	@Test
	public void testRefTranGeneratorSemCodigoDeConvenioDeCobrancaENumeroDoUsuario(){
		Assert.assertEquals("12345670000000000",new RefTranGenerator().geraRefTran("1234567"));
	}
		
}
