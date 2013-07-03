package br.com.caelum.stella.boleto.bancos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.Sacado;

public class BradescoTest {

	private Boleto boleto;
	private Bradesco banco;
	private Emissor emissor;

	@Before
	public void setUp() {
		Datas datas = Datas.novasDatas().comDocumento(31, 5, 2006).comProcessamento(31, 5, 2006)
				.comVencimento(10, 6, 2006);

		this.emissor = Emissor.novoEmissor().comCedente("Leonardo Bessa").comAgencia(2949).comDigitoAgencia('1')
				.comContaCorrente(6580).comNumeroConvenio(1207113).comDigitoContaCorrente('3').comCarteira(6)
				.comNossoNumero(3);

		Sacado sacado = Sacado.novoSacado().comNome("Fulano");

		this.banco = new Bradesco();

		this.boleto = Boleto.novoBoleto().comDatas(datas).comEmissor(this.emissor).comSacado(sacado)
				.comValorBoleto("1.00").comNumeroDoDocumento("4323");
	}

	@Test
	public void numeroDoConvenioFormatadoDeveTerSeteDigitos() {
		Emissor emissor = Emissor.novoEmissor().comNumeroConvenio(1234);
		String numeroFormatado = this.banco.getNumeroConvenioDoEmissorFormatado(emissor);
		assertEquals(7, numeroFormatado.length());
		assertEquals("0001234", numeroFormatado);
	}

	@Test
	public void nossoNumeroFormatadoDeveTerOnzeDigitos() {
		Emissor emissor = Emissor.novoEmissor().comNossoNumero(9000206).comDigitoNossoNumero("7");
		String numeroFormatado = this.banco.getNossoNumeroDoEmissorFormatado(emissor);
		assertEquals(11, numeroFormatado.length());
		assertEquals("00009000206", numeroFormatado);
	}

	@Test
	public void carteiraFormatadoDeveTerDoisDigitos() {
		Emissor emissor = Emissor.novoEmissor().comCarteira(1);
		String numeroFormatado = this.banco.getCarteiraDoEmissorFormatado(emissor);
		assertEquals(2, numeroFormatado.length());
		assertEquals("01", numeroFormatado);
	}

	@Test
	public void contaCorrenteFormatadaDeveTerSeteDigitos() {
		String numeroFormatado = this.banco.getContaCorrenteDoEmissorFormatado(this.emissor);
		assertEquals(7, numeroFormatado.length());
		assertEquals("0006580", numeroFormatado);
	}

	@Test
	public void testLinhaDoBancoBradesco() {
		this.banco = new Bradesco();
		this.boleto = this.boleto.comBanco(this.banco);
		GeradorDeLinhaDigitavel linhaDigitavelGenerator = new GeradorDeLinhaDigitavel();
		String codigoDeBarras = boleto.getBanco().geraCodigoDeBarrasPara(this.boleto);

		assertEquals("23792.94909  60000.000004  03000.658009  6  31680000000100",
				linhaDigitavelGenerator.geraLinhaDigitavelPara(codigoDeBarras));
	}

	@Test
	public void testCodigoDeBarraDoBancoBradesco() {
		this.banco = new Bradesco();
		this.boleto = this.boleto.comBanco(this.banco);

		assertEquals("23796316800000001002949060000000000300065800", this.banco.geraCodigoDeBarrasPara(this.boleto));
	}

	@Test
	public void testGetImage() {
		assertNotNull(this.banco.getImage());
	}
}
