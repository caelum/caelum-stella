package br.com.caelum.stella;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class DigitoParaTest {

	@Test
	public void geracaoDeDigitoVerificadorParaBoleto() {
		Map<DigitoPara,String> entradas = new HashMap<DigitoPara, String>();
		entradas.put(new DigitoPara("3999100100001200000351202000003910476618602"), "3");
		entradas.put(new DigitoPara("2379316800000001002949060000000000300065800"), "6");
		entradas.put(new DigitoPara("0019386000000040000000001207113000900020618"), "5");
		entradas.put(new DigitoPara("0000039104766"), "3");

		for (DigitoPara digitoPara : entradas.keySet()) {
			String esperado = entradas.get(digitoPara);
			Assert.assertEquals(esperado, digitoPara.comMultiplicadoresDeAte(2,9).complementarAoModulo().mod(11).calcula());
		}
	}

	@Test
	public void geracaoDeDigitoVerificadorParaBoletoCasosEspeciais() {
		Map<DigitoPara,String> entradas = new HashMap<DigitoPara, String>();
		entradas.put(new DigitoPara("3999100100001200000351202000003911476618611"), "1"); //mod dá 10
		entradas.put(new DigitoPara("2379316800000001002949060000000100300065885"), "1"); //mod dá 11
		
		for (DigitoPara digitoPara : entradas.keySet()) {
			String esperado = entradas.get(digitoPara);
			Assert.assertEquals(esperado, digitoPara.comMultiplicadoresDeAte(2,9).complementarAoModulo().trocandoPorSeEncontrar("1", 0, 10, 11).mod(11).calcula());
		}
	}
	
	@Test
	public void geracaoDeDigitoMod11PraIntervaloPassado() {
		Assert.assertEquals("1", new DigitoPara("05009401448").comMultiplicadores(9,8,7,6,5,4,3,2).mod(11).calcula());
	}

	@Test
	public void geracaoDeDigitoParaRGDeSaoPaulo() {
		Assert.assertEquals("1", new DigitoPara("36422911").comMultiplicadoresDeAte(2,9).mod(11).calcula());
		Assert.assertEquals("X", new DigitoPara("42105900").comMultiplicadoresDeAte(2,9).trocandoPorSeEncontrar("X", 10).mod(11).calcula());
	}
	
}
