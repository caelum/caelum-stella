package br.com.caelum.stella.boleto;

import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("deprecation")
public class SacadoTest {
	private Sacado sacado = Sacado.novoSacado();

	@Test
	public void attributesShouldNotBeNull() {
		Assert.assertNotNull(sacado.getBairro());
		Assert.assertNotNull(sacado.getCep());
		Assert.assertNotNull(sacado.getCidade());
		Assert.assertNotNull(sacado.getCpf());
		Assert.assertNotNull(sacado.getEndereco());
		Assert.assertNotNull(sacado.getNome());
		Assert.assertNotNull(sacado.getUf());
	}
}
