package br.com.caelum.stella.boleto;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

public class BoletoTest {

	@Test
	public void testNewBoletoSeTemDefaultsCorretos() {
		Boleto b = Boleto.newBoleto();
		assertEquals("R$", b.getEspecieMoeda());
		assertEquals(9, b.getCodEspecieMoeda());
		assertEquals("N", b.getAceite());
		assertEquals("DV", b.getEspecieDocumento());
	}

	@Test
	public void testGetFatorVencimentoParaDataDaManha() {
		Boleto b = Boleto.newBoleto();

		Calendar passado10diasManha = Calendar.getInstance();
		passado10diasManha.set(Calendar.DAY_OF_MONTH, 17);
		passado10diasManha.set(Calendar.MONTH, 10 - 1);
		passado10diasManha.set(Calendar.YEAR, 1997);

		passado10diasManha.set(Calendar.HOUR_OF_DAY, 1);

		b.comDatas(Datas.newDatas().comVencimento(passado10diasManha));

		assertEquals(10, b.getFatorVencimento());
	}

	@Test
	public void testGetFatorVencimentoParaDataDaNoite() {
		Boleto b = Boleto.newBoleto();

		Calendar passado10diasNoite = Calendar.getInstance();
		passado10diasNoite.set(Calendar.DAY_OF_MONTH, 17);
		passado10diasNoite.set(Calendar.MONTH, 10 - 1);
		passado10diasNoite.set(Calendar.YEAR, 1997);

		passado10diasNoite.set(Calendar.HOUR_OF_DAY, 23);

		b.comDatas(Datas.newDatas().comVencimento(passado10diasNoite));

		assertEquals(10, b.getFatorVencimento());
	}

	@Test
	public void testGetFatorVencimentoParaDataDaExtremaNoite() {
		Boleto b = Boleto.newBoleto();

		Calendar passado10diasNoite = Calendar.getInstance();
		passado10diasNoite.set(Calendar.DAY_OF_MONTH, 17);
		passado10diasNoite.set(Calendar.MONTH, 10 - 1);
		passado10diasNoite.set(Calendar.YEAR, 1997);

		passado10diasNoite.set(Calendar.HOUR_OF_DAY, 23);
		passado10diasNoite.set(Calendar.MINUTE, 59);
		passado10diasNoite.set(Calendar.SECOND, 59);
		passado10diasNoite.set(Calendar.MILLISECOND, 999);

		b.comDatas(Datas.newDatas().comVencimento(passado10diasNoite));

		assertEquals(10, b.getFatorVencimento());
	}

	@Test
	public void testGetFatorVencimentoParaDataDoExtremaManha() {
		Boleto b = Boleto.newBoleto();

		Calendar passado10diasDia = Calendar.getInstance();
		passado10diasDia.set(Calendar.DAY_OF_MONTH, 17);
		passado10diasDia.set(Calendar.MONTH, 10 - 1);
		passado10diasDia.set(Calendar.YEAR, 1997);

		passado10diasDia.set(Calendar.HOUR_OF_DAY, 0);
		passado10diasDia.set(Calendar.MINUTE, 0);
		passado10diasDia.set(Calendar.SECOND, 0);
		passado10diasDia.set(Calendar.MILLISECOND, 0);

		b.comDatas(Datas.newDatas().comVencimento(passado10diasDia));

		assertEquals(10, b.getFatorVencimento());
	}

	@Test
	public void testGetValorFormatado() {
		Boleto b = Boleto.newBoleto();
		b.comValorBoleto("300");
		assertEquals("0000000300", b.getValorFormatado());
	}

	@Test
	public void testGetNoDocumentoFormatado() {
		Boleto b = Boleto.newBoleto();
		b.comNoDocumento("232");
		assertEquals("0232", b.getNoDocumentoFormatado());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBoletoComMaisDe5Instrucoes() {
		Boleto b = Boleto.newBoleto();
		b.comInstrucoes("", "", "", "", "", "");
	}

	@Test
	public void testBoletoCom5Instrucoes() {
		Boleto b = Boleto.newBoleto();
		b.comInstrucoes("", "", "", "", "");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBoletoComMaisDe5Descricoes() {
		Boleto b = Boleto.newBoleto();
		b.comDescricoes("", "", "", "", "", "");
	}

	@Test
	public void testBoletoCom5Descricoes() {
		Boleto b = Boleto.newBoleto();
		b.comDescricoes("", "", "", "", "");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBoletoComMaisDe2Locais() {
		Boleto b = Boleto.newBoleto();
		b.comLocaisDePagamento("", "", "");
	}

	@Test
	public void testBoletoCom2Locais() {
		Boleto b = Boleto.newBoleto();
		b.comLocaisDePagamento("", "");
	}

}
