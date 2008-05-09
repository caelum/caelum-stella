package br.com.caelum.stella.boleto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.bancos.Bradesco;

public class BancosTest {
	private BoletoPadrao boleto;
	private Banco banco;

	@Before
	public void setUp() {
		DatasPadrao datas = DatasPadrao.newDatas().comDocumento(
				dataPara(4, 5, 2008)).comProcessamento(dataPara(4, 5, 2008))
				.comVencimento(dataPara(2, 5, 2008));
		
		EmissorPadrao emissor = EmissorPadrao.newEmissor().comCedente("Caue")
				.comAgencia("1824").comDvAgencia("4").comContaCorrente(
						"0076000").comNumConvenio("1207113").comDvContaCorrete(
						"5").comCarteira("18").comNossoNumero("0009000206");

		SacadoPadrao sacado = SacadoPadrao.newSacado().comNome("Fulano");

		banco = new BancoDoBrasil();

		boleto = BoletoPadrao.newBoleto().comDatas(datas)
				.comEmissor(emissor).comSacado(sacado).comValorBoleto("40.00")
				.comNoDocumento("4323");
	}

	@Test
	public void testLinhaDoBancoDoBrasil() {
		banco = new BancoDoBrasil();
		boleto = boleto.comBanco(banco);
		
		assertEquals(
				"00190.00009  01207.113000  09000.206186  5  38600000004000",
				banco.geraLinhaDigitavelPara(boleto));
	}

	@Test
	public void testCodigoDeBarraDoBancoDoBrasil() {
		banco = new BancoDoBrasil();
		boleto = boleto.comBanco(banco);

		assertEquals("00195386000000040000000001207113000900020618", banco
				.geraCodigoDeBarrasPara(boleto));
	}
	
	@Test
	public void testLinhaDoBradesco() {
		banco = new Bradesco();
		boleto = boleto.comBanco(banco);
		
		assertEquals(
				"23790.18241  18000.900029  06007.600007  5  38600000007000",
				banco.geraLinhaDigitavelPara(boleto));
	}

	@Test
	public void testCodigoDeBarraDoBradesco() {
		banco = new Bradesco();
		boleto = boleto.comBanco(banco);
		
		assertEquals("23795386000000070000182418000900020600760000", banco
				.geraCodigoDeBarrasPara(boleto));
	}

	@Test
	public void testGetImage() throws IOException {
		assertNotNull(banco.getImage());
	}

	static Calendar dataPara(int dia, int mes, int ano) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, dia);
		c.set(Calendar.MONTH, mes - 1);
		c.set(Calendar.YEAR, ano);
		return c;
	}
}
