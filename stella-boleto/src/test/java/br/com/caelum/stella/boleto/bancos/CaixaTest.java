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
	private Boleto outroBoleto;

	@Before
	public void setUp() {

		///////////////////////////////////////////////////////////////////
		// SET UP de boleto com carteira SINCO
		///////////////////////////////////////////////////////////////////

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
		
		///////////////////////////////////////////////////////////////////
		// SET UP de boleto com carteira Sem Registro e Registrada no SIGCB
		///////////////////////////////////////////////////////////////////
		
		Datas datasOutroBoleto = Datas.newDatas().withDocumento(21, 8, 2012)
				.withProcessamento(21, 8, 2012).withVencimento(04, 9, 2012);

		Emissor emissor = Emissor.newEmissor().withCedente("Guilherme")
			.withAgencia(589).withCarteira(2)
			.withContaCorrente(290274).withDigitoContaCorrente('5')
			.withNossoNumero(24900000000000132l)
			.withDigitoNossoNumero("3");

		Sacado sacadoOutroBoleto = Sacado.newSacado().withNome("Paulo");

		this.outroBoleto = Boleto.newBoleto().withDatas(datasOutroBoleto)
			.withEmissor(emissor).withBanco(banco).withSacado(sacadoOutroBoleto)
			.withValorBoleto(80.00).withNumeroDoDocumento("00000000132");
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
	public void testLinhaDoBancoCaixaComCarteiraSINCO() {
		GeradorDeLinhaDigitavel gerador = new GeradorDeLinhaDigitavel();
		String codigoDeBarras = boleto.getBanco().geraCodigoDeBarrasPara(this.boleto);
		String linha = "10491.00231  59990.000008  00039.944582  2  56830000401610";
		assertEquals(linha, gerador.geraLinhaDigitavelPara(codigoDeBarras));
	}

	@Test
	public void testCodigoDeBarraDoBancoCaixaComCarteiraSINCO() {
		assertEquals("10492568300004016101002359990000000003994458",
				this.banco.geraCodigoDeBarrasPara(this.boleto));
	}

	@Test
	public void testLinhaDoBancoCaixaComCarteiraSICGB() {
		GeradorDeLinhaDigitavel gerador = new GeradorDeLinhaDigitavel();
		String codigoDeBarras = outroBoleto.getBanco().geraCodigoDeBarrasPara(outroBoleto);
		String linha = "10492.90271  45900.200044  00000.013227  9  54460000008000";
		assertEquals(linha, gerador.geraLinhaDigitavelPara(codigoDeBarras));
	}

	@Test
	public void testCodigoDeBarraDoBancoCaixaComCarteiraSICGB() {
		assertEquals("10499544600000080002902745900200040000001322",
				this.banco.geraCodigoDeBarrasPara(this.outroBoleto));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deveLancarExceptionSeCarteiraNaoForSuportada() throws Exception {
		this.outroBoleto.getEmissor().withCarteira(3);
		assertEquals("10499544600000080002902745900200040000001322",
				this.banco.geraCodigoDeBarrasPara(this.outroBoleto));
	}
	
	@Test
	public void testGetImage() {
		assertNotNull(this.banco.getImage());
	}
}
