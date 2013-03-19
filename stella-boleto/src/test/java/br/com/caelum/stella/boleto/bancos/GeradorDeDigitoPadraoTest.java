package br.com.caelum.stella.boleto.bancos;

import java.util.HashMap;
import java.util.Map;

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
		Map<String, Integer> codigos = new HashMap<String, Integer>();
		codigos.put("0019386000000040000000001207113000900020618", 5);
		codigos.put("2379316800000001002949060000000000300065800", 6);
		codigos.put("0000039104766", 3);
		codigos.put("3999100100001200000351202000003910476618602", 3);

		for (String codigo : codigos.keySet()) {
			Assert.assertEquals(codigos.get(codigo).intValue(), gerador.geraDigitoMod11(codigo));
		}
	}

	@Test
	public void geracaoDeDigitoMod10() {
		Map<String, Integer> codigos = new HashMap<String, Integer>();
		codigos.put("237929490", 9);
		codigos.put("6000000000", 4);
		codigos.put("0300065800", 9);
		codigos.put("399903512", 8);

		for (String codigo : codigos.keySet()) {
			Assert.assertEquals(codigos.get(codigo).intValue(), gerador.geraDigitoMod10(codigo));
		}
	}
}
