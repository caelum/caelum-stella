package br.com.caelum.stella.boleto.bancos.gerador;

import org.junit.Assert;
import org.junit.Test;

public class DigitoParaTest {

	@Test
	public void geracaoDeDigitoMod11() {
		Assert.assertEquals(3, new DigitoPara("3999100100001200000351202000003910476618602").comMultiplicadoresDeAte(2,9).mod(11));
		Assert.assertEquals(6, new DigitoPara("2379316800000001002949060000000000300065800").comMultiplicadoresDeAte(2,9).mod(11));
		Assert.assertEquals(5, new DigitoPara("0019386000000040000000001207113000900020618").comMultiplicadoresDeAte(2,9).mod(11));
		Assert.assertEquals(3, new DigitoPara("0000039104766").comMultiplicadoresDeAte(2, 9).mod(11));
	}

}
