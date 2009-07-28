package br.com.caelum.stella.gateway.pagseguro;

import junit.framework.Assert;

import org.junit.Test;

public class TestNormalizarString {

	@Test
	public void testRetiraCaracteresEspeciais(){
		String nome = "Cartão de Crédito";
		Assert.assertEquals(new RemoverAcentos().remover(nome),"Cartao de Credito");
	}
}
