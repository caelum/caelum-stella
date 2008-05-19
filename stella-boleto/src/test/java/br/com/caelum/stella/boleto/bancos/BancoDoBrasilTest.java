package br.com.caelum.stella.boleto.bancos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.Sacado;

public class BancoDoBrasilTest {

	private Boleto boleto;
	private Banco banco;

	@Before
	public void setUp() {
		Datas datas = Datas.newDatas().withDocumento(4, 5, 2008)
				.withProcessamento(4, 5, 2008).withVencimento(2, 5, 2008);

		Emissor emissor = Emissor.newEmissor().withCedente("Caue").withAgencia(
				"1824").withDvAgencia("4").withContaCorrente("76000")
				.withNumConvenio("1207113").withDvContaCorrete("5").withCarteira(
						"18").withNossoNumero("0009000206");

		Sacado sacado = Sacado.newSacado().withNome("Fulano");

		this.banco = new BancoDoBrasil();

		this.boleto = Boleto.newBoleto().withDatas(datas).withEmissor(emissor)
				.withSacado(sacado).withValorBoleto("40.00").withNoDocumento(
						"4323");
	}

	@Test
	public void testLinhaDoBancoDoBrasil() {
		this.banco = new BancoDoBrasil();
		this.boleto = this.boleto.withBanco(this.banco);

		assertEquals(
				"00190.00009  01207.113000  09000.206186  5  38600000004000",
				this.banco.geraLinhaDigitavelPara(this.boleto));
	}

	@Test
	public void testCodigoDeBarraDoBancoDoBrasil() {
		this.banco = new BancoDoBrasil();
		this.boleto = this.boleto.withBanco(this.banco);

		assertEquals("00195386000000040000000001207113000900020618", this.banco
				.geraCodigoDeBarrasPara(this.boleto));
	}

	@Test
	public void testGetImage() throws IOException {
		assertNotNull(this.banco.getImage());
	}
}
