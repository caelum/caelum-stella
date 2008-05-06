package br.com.caelum.stella.boleto;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

public class BancosTest {

	@Test
	public void testGetNumeroFormatado() {
		for (Bancos b : Bancos.values()) {
			assertEquals(b.getNumero(), Integer
					.parseInt(b.getNumeroFormatado()));
		}
	}

	@Test
	public void testGetImage() throws IOException {
		for (Bancos b : Bancos.values()) {
			assertNotNull(b.getImage());
		}
	}

	@Test
	public void testLinhaDoBancoDoBrasil() {

		DatasPadrao datas = DatasPadrao.newDatas().comDataDeDocumento(
				dataPara(5, 5, 2008)).comDataDeProcessamento(
				dataPara(5, 5, 2008)).comDataDeVencimento(dataPara(6, 5, 2008));

		EmissorPadrao emissor = EmissorPadrao.newEmissor().comCedente("Caue")
				.comAgencia("1824-4").comContaCorrente("76000")
				.comDvContaCorrete("5").comCarteira("18").comNossoNumero("0009000133");

		SacadoPadrao sacado = SacadoPadrao.newSacado().comNome("Fulano");

		BoletoPadrao boleto = BoletoPadrao.newBoleto().comBanco(
				Bancos.BANCO_DO_BRASIL).comDatas(datas).comEmissor(emissor)
				.comSacado(sacado).comValorBoleto("2.00")
				.comNoDocumento("4323");

		Assert.assertEquals(
				"00190.00009  01207.113000  09000.133182  3  38640000007000",
				boleto.getBanco().geraLinhaDigitavelPara(boleto));
	}

	static Calendar dataPara(int dia, int mes, int ano) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, dia);
		c.set(Calendar.MONTH, mes - 1);
		c.set(Calendar.YEAR, ano);
		return c;
	}

	@Test
	public void testCodigoDeBarraDoBancoDoBrasil() {

	}

}
