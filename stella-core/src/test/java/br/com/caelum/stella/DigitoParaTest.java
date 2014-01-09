package br.com.caelum.stella;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.stella.DigitoPara;

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
			Assert.assertEquals(esperado, digitoPara.comMultiplicadoresDeAte(2,9).complementarAoModulo().mod(11));
		}
	}

	@Test
	public void geracaoDeDigitoVerificadorParaBoletoCasosEspeciais() {
		Map<DigitoPara,String> entradas = new HashMap<DigitoPara, String>();
		entradas.put(new DigitoPara("3999100100001200000351202000003911476618611"), "1"); //mod dá 10
		entradas.put(new DigitoPara("2379316800000001002949060000000100300065885"), "1"); //mod dá 11
		
		for (DigitoPara digitoPara : entradas.keySet()) {
			String esperado = entradas.get(digitoPara);
			Assert.assertEquals(esperado, digitoPara.comMultiplicadoresDeAte(2,9).complementarAoModulo().trocandoPorSeEncontrar("1", 0, 10, 11).mod(11));
		}
	}
	
	@Test
	public void geracaoDeDigitoMod11PraIntervaloPassado() {
		Assert.assertEquals("1", new DigitoPara("05009401448").comMultiplicadores(9,8,7,6,5,4,3,2).mod(11));
	}

	@Test
	public void geracaoDeDigitoParaRGDeSaoPaulo() {
		Assert.assertEquals("1", new DigitoPara("36422911").comMultiplicadoresDeAte(2,9).mod(11));
		Assert.assertEquals("X", new DigitoPara("42105900").comMultiplicadoresDeAte(2,9).trocandoPorSeEncontrar("X", 10).mod(11));
	}
	
	@Test
	public void geracaoDeDigitoParaCNPJ(){
		Assert.assertEquals("8", digitoParaCNPJ("112223330001"));
		Assert.assertEquals("1", digitoParaCNPJ("1122233300018"));

		Assert.assertEquals("5", digitoParaCNPJ("615191280001"));
		Assert.assertEquals("0", digitoParaCNPJ("6151912800015"));
		
	}

	private String digitoParaCNPJ(String cnpj) {
		return new DigitoPara(cnpj).complementarAoModulo().trocandoPorSeEncontrar("0",10,11).mod(11);
	}
	
	@Test
	public void geracaoDeDigitoParaCPF(){
		Assert.assertEquals("3", digitoParaCPF("111444777"));
		Assert.assertEquals("5", digitoParaCPF("1114447773"));

		Assert.assertEquals("0", digitoParaCPF("367486656"));
		Assert.assertEquals("4", digitoParaCPF("3674866560"));
		
	}

	private String digitoParaCPF(String cpf) {
		return new DigitoPara(cpf).comMultiplicadoresDeAte(2, 11).complementarAoModulo().trocandoPorSeEncontrar("0",10,11).mod(11);
	}
}
