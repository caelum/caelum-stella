package br.com.caelum.stella.boleto.bancos;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.exception.BancoNaoSuportadoException;

public class BancosTest {

	@Test
	public void deveRetornarOBancoBaseadoNoNumero() throws Exception {
		Banco brasil = Bancos.getPorNumero("001");
		Banco itau = Bancos.getPorNumero("341");

		Assert.assertThat(brasil, Matchers.instanceOf(BancoDoBrasil.class));
		Assert.assertThat(itau, Matchers.instanceOf(Itau.class));
	}
	
	@Test(expected=BancoNaoSuportadoException.class)
	public void deveLancarExceptionSeOBancoNaoEhSuportado() {
		Bancos.getPorNumero("9999");
	}

}
