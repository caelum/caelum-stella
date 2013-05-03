package br.com.caelum.stella.boleto.bancos;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.Sacado;

public class CaixaTest {

	private Boleto boleto;
	private Caixa banco = new Caixa();
	private Emissor emissor;

	@Before
	public void setUp() {

		Datas datas = Datas.newDatas().withDocumento(22, 04, 2013)
			.withProcessamento(22, 04, 2013).withVencimento(29, 04, 2013);

		this.emissor = Emissor.newEmissor().withCedente("Rodrigo Turini")
			.withAgencia(2873).withCarteira(1)
			.withContaCorrente(2359).withNossoNumero(990000000003994458l)
			.withDigitoNossoNumero("0");

		Sacado sacado = Sacado.newSacado().withNome("Mario Amaral");

		this.boleto = Boleto.newBoleto().withDatas(datas)
			.withEmissor(emissor).withBanco(this.banco).withSacado(sacado)
			.withValorBoleto(4016.10).withNumeroDoDocumento("3084373");
	}

	@Test
	public void codFornecidoPelaAgenciaDeveTerOitoDigitos() {
		Emissor emissor = Emissor.newEmissor()
				.withCodigoFornecidoPelaAgencia(2);
		String numeroFormatado = this.banco
				.getCodigoFornecidoPelaAgenciaFormatado(emissor);
		assertEquals(8, numeroFormatado.length());
		assertEquals("00000002", numeroFormatado);
	}

	@Test
	public void codOperacaoDeveTerTresDigitos() {
		Emissor emissor = Emissor.newEmissor().withCodigoOperacao(2);
		String numeroFormatado = this.banco.getCodigoOperacaoFormatado(emissor);
		assertEquals(3, numeroFormatado.length());
		assertEquals("002", numeroFormatado);
	}

	@Test
	public void carteiraFormatadoDeveTerDoisDigitos() {
		Emissor emissor = Emissor.newEmissor().withCarteira(1);
		String numeroFormatado = this.banco
				.getCarteiraDoEmissorFormatado(emissor);
		assertEquals(2, numeroFormatado.length());
		assertEquals("01", numeroFormatado);
	}

	@Test
	public void contaCorrenteFormatadaDeveTerCincoDigitos() {
		String numeroFormatado = this.banco
			.getContaCorrenteDoEmissorFormatado(this.emissor);
		assertEquals(5, numeroFormatado.length());
		assertEquals("02359", numeroFormatado);
	}

	@Test
	public void testLinhaDoBancoCaixa() {
		GeradorDeLinhaDigitavel gerador = new GeradorDeLinhaDigitavel();
		String codigoDeBarras = boleto.getBanco().geraCodigoDeBarrasPara(this.boleto);
		String linha = "10491.00231  59990.000008  00039.944582  2  56830000401610";
		assertEquals(linha, gerador.geraLinhaDigitavelPara(codigoDeBarras));
	}

	@Test
	public void testCodigoDeBarraDoBancoCaixa() {
		assertEquals("10492568300004016101002359990000000003994458",
				this.banco.geraCodigoDeBarrasPara(this.boleto));
	}

	@Test
	public void testGetImage() {
		assertNotNull(this.banco.getImage());
	}
}
