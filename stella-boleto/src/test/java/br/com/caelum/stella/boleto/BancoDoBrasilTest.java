package br.com.caelum.stella.boleto;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

public class BancoDoBrasilTest {


	@Test
	public void testLinhaDoBancoDoBrasil() {

		DatasPadrao datas = DatasPadrao.newDatas().comDocumento(
				dataPara(5, 5, 2008)).comProcessamento(
				dataPara(5, 5, 2008)).comVencimento(dataPara(6, 5, 2008));

		EmissorPadrao emissor = EmissorPadrao.newEmissor().comCedente("Caue")
				.comAgencia("1824").comDvAgencia("4").comContaCorrente("0076000").comNumConvenio("41")
				.comDvContaCorrete("5").comCarteira("18").comNossoNumero("00009000133");

		SacadoPadrao sacado = SacadoPadrao.newSacado().comNome("Fulano");

		Banco banco = new BancoDoBrasil();
		
		BoletoPadrao boleto = BoletoPadrao.newBoleto().comBanco(
				banco).comDatas(datas).comEmissor(emissor)
				.comSacado(sacado).comValorBoleto("70.00")
				.comNoDocumento("4323");

		Assert.assertEquals(
				"00190.00009  01207.113000  09000.133182  3  38640000007000",
				banco.geraLinhaDigitavelPara(boleto));
	}
	
	@Test
	public void testCodigoDeBarraDoBancoDoBrasil() {
		
		DatasPadrao datas = DatasPadrao.newDatas().comDocumento(
				dataPara(5, 5, 2008)).comProcessamento(
				dataPara(5, 5, 2008)).comVencimento(dataPara(6, 5, 2008));

		EmissorPadrao emissor = EmissorPadrao.newEmissor().comCedente("Caue")
				.comAgencia("1824").comDvAgencia("4").comContaCorrente("0076000").comNumConvenio("41")
				.comDvContaCorrete("5").comCarteira("18").comNossoNumero("00009000133");

		SacadoPadrao sacado = SacadoPadrao.newSacado().comNome("Fulano");

		Banco banco = new BancoDoBrasil();
		
		BoletoPadrao boleto = BoletoPadrao.newBoleto().comBanco(
				banco).comDatas(datas).comEmissor(emissor)
				.comSacado(sacado).comValorBoleto("70.00")
				.comNoDocumento("4323");
		
		Assert.assertEquals(
				"0019838330000007000000000410000900013318",
				banco.geraCodigoDeBarrasPara(boleto));
	}
	
	static Calendar dataPara(int dia, int mes, int ano) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, dia);
		c.set(Calendar.MONTH, mes - 1);
		c.set(Calendar.YEAR, ano);
		return c;
	}
}
