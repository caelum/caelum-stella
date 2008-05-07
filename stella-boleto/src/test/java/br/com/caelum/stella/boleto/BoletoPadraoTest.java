package br.com.caelum.stella.boleto;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

public class BoletoPadraoTest {


	@Test
	public void testLinhaDoBancoDoBrasil() {

		DatasPadrao datas = DatasPadrao.newDatas().comDocumento(
				dataPara(5, 5, 2008)).comProcessamento(
				dataPara(5, 5, 2008)).comVencimento(dataPara(6, 5, 2008));

		EmissorPadrao emissor = EmissorPadrao.newEmissor().comCedente("Caue")
				.comAgencia("1824").comDvAgencia("4").comContaCorrente("76000")
				.comDvContaCorrete("5").comCarteira("18").comNossoNumero("0009000133");

		SacadoPadrao sacado = SacadoPadrao.newSacado().comNome("Fulano");

		BoletoPadrao boleto = BoletoPadrao.newBoleto().comBanco(
				Bancos.BANCO_DO_BRASIL).comDatas(datas).comEmissor(emissor)
				.comSacado(sacado).comValorBoleto("2.00")
				.comNoDocumento("4323");

		Assert.assertEquals(
				"00190.00009  01207.113000  09000.133182  3  38640000007000",
				boleto.geraLinhaDigitavel());
	}
	
	@Test
	public void testCodigoDeBarraDoBancoDoBrasil() {

	}
	
	static Calendar dataPara(int dia, int mes, int ano) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, dia);
		c.set(Calendar.MONTH, mes - 1);
		c.set(Calendar.YEAR, ano);
		return c;
	}
}
