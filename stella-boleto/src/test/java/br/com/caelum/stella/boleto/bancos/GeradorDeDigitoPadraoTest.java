package br.com.caelum.stella.boleto.bancos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.boleto.bancos.gerador.GeradorDeDigito;
import br.com.caelum.stella.boleto.bancos.gerador.GeradorDeDigitoPadrao;

public class GeradorDeDigitoPadraoTest {

	private GeradorDeDigito gerador;

	@Before
	public void setUp() {
		this.gerador = new GeradorDeDigitoPadrao();
	}
	
	@Test
	public void geracaoDeDigitoMod11() {
		Assert.assertEquals(5, gerador.geraDigitoMod11("0019386000000040000000001207113000900020618"));
		Assert.assertEquals(6, gerador.geraDigitoMod11("2379316800000001002949060000000000300065800"));
		Assert.assertEquals(3, gerador.geraDigitoMod11("0000039104766"));
		Assert.assertEquals(3, gerador.geraDigitoMod11("3999100100001200000351202000003910476618602"));
		Assert.assertEquals(1, gerador.geraDigitoMod11("3999597400000001002461722000000001934404542"));
	}

	@Test
	public void geracaoDeDigitoMod10() {
		Assert.assertEquals(9, gerador.geraDigitoMod10("237929490"));
		Assert.assertEquals(4, gerador.geraDigitoMod10("6000000000"));
		Assert.assertEquals(9, gerador.geraDigitoMod10("0300065800"));
		Assert.assertEquals(8, gerador.geraDigitoMod10("399903512"));
	}
}
