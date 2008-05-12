package br.com.caelum.stella.boleto.bancos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.BoletoPadrao;
import br.com.caelum.stella.boleto.DatasPadrao;
import br.com.caelum.stella.boleto.EmissorPadrao;
import br.com.caelum.stella.boleto.SacadoPadrao;

public class BradescoTest {

	private BoletoPadrao boleto;
	private Banco banco;

	@Before
	public void setUp() {
		DatasPadrao datas = DatasPadrao.newDatas().comDocumento(
				dataPara(4, 5, 2008)).comProcessamento(dataPara(4, 5, 2008))
				.comVencimento(dataPara(2, 5, 2008));

		EmissorPadrao emissor = EmissorPadrao.newEmissor().comCedente("Caue")
				.comAgencia("1824").comDvAgencia("4").comContaCorrente(
						"76000").comNumConvenio("1207113").comDvContaCorrete(
						"5").comCarteira("18").comNossoNumero("0009000206");

		SacadoPadrao sacado = SacadoPadrao.newSacado().comNome("Fulano");

		banco = new BancoDoBrasil();

		boleto = BoletoPadrao.newBoleto().comDatas(datas).comEmissor(emissor)
				.comSacado(sacado).comValorBoleto("40.00").comNoDocumento(
						"4323");
	}

	@Test
	public void testLinhaDoBradesco() {
		banco = new Bradesco();
		boleto = boleto.comBanco(banco);

		assertEquals(
				"23790.18241  18000.900029  06007.600007  5  38600000004000",
				banco.geraLinhaDigitavelPara(boleto));
	}

	@Test
	public void testCodigoDeBarraDoBradesco() {
		banco = new Bradesco();
		boleto = boleto.comBanco(banco);

		assertEquals("23795386000000040000182418000900020600760000", banco
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
