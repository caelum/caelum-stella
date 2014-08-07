package br.com.caelum.stella.boleto.bancos;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.exception.BancoNaoSuportadoException;

public class BancosTest {
	
	private Beneficiario beneficiario = Beneficiario.novoBeneficiario();

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
	
	@Test
	public void obterAgenciaECodigoBeneficiarioFormatadoSemDV() throws Exception {
		Banco banco = new BancoDoBrasil();
		
		beneficiario.comAgencia("1234").comDigitoAgencia(null)
			.comCodigoBeneficiario("12345678").comDigitoCodigoBeneficiario(null);
		
		assertThat(banco.getAgenciaECodigoBeneficiario(beneficiario), is("1234/12345678"));
	}
	
	@Test
	public void obterAgenciaECodigoBeneficiarioFormatado() throws Exception {
		Banco banco = new BancoDoBrasil();
		
		beneficiario.comAgencia("1234").comDigitoAgencia("3")
			.comCodigoBeneficiario("12345678").comDigitoCodigoBeneficiario("9");
		
		assertThat(banco.getAgenciaECodigoBeneficiario(beneficiario), is("1234-3/12345678-9"));
	}

}
