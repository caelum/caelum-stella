package br.com.caelum.stella.boleto.bancos;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Pagador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BancoDoBrasilTest {

	private Boleto boleto;
	private BancoDoBrasil banco;
	private Beneficiario beneficiario;

	@Before
	public void setUp() {
		Datas datas = Datas.novasDatas().comDocumento(4, 5, 2008).comProcessamento(4, 5, 2008)
				.comVencimento(2, 5, 2008);

		this.beneficiario = Beneficiario.novoBeneficiario().comNomeBeneficiario("Caue")
				.comAgencia("1824").comDigitoAgencia("4")
				.comCodigoBeneficiario("76000")
				.comNumeroConvenio("1207113")
				.comDigitoCodigoBeneficiario("5")
				.comCarteira("18")
				.comNossoNumero("9000206");

		Pagador pagador = Pagador.novoPagador().comNome("Fulano");

		this.banco = new BancoDoBrasil();

		this.boleto = Boleto.novoBoleto().comDatas(datas).comBeneficiario(this.beneficiario).comPagador(pagador)
				.comValorBoleto("40.00").comNumeroDoDocumento("4323");
	}

	@Test
	public void numeroDoConvenioFormatadoDeveTerSeisDigitos() {
		Beneficiario beneficiario = Beneficiario.novoBeneficiario().comNumeroConvenio("1234");
		
		String numeroFormatado = this.banco.getNumeroConvenioFormatado(beneficiario);
		assertEquals(6, numeroFormatado.length());
		assertEquals("001234", numeroFormatado);
	}

	@Test
	public void nossoNumeroFormatadoDeveTerOnzeDigitos() {
		Beneficiario beneficiario = Beneficiario.novoBeneficiario().comNossoNumero("9000206").comCarteira("11");
		String numeroFormatado = this.banco.getNossoNumeroFormatado(beneficiario);
		assertEquals(11, numeroFormatado.length());
		assertEquals("00009000206", numeroFormatado);
	}

	@Test
	public void nossoNumeroFormatadoDeveTerDezesseteDigitosComCarteira18() {
		Beneficiario beneficiario = Beneficiario.novoBeneficiario().comNossoNumero("9000206").comCarteira("18");
		String numeroFormatado = this.banco.getNossoNumeroFormatado(beneficiario);
		assertEquals(17, numeroFormatado.length());
		assertEquals("00000000009000206", numeroFormatado);
	}

	@Test
	public void carteiraFormatadoDeveTerDoisDigitos() {
		Beneficiario beneficiario = Beneficiario.novoBeneficiario().comCarteira("1");
		String numeroFormatado = this.banco.getCarteiraFormatado(beneficiario);
		assertEquals(2, numeroFormatado.length());
		assertEquals("01", numeroFormatado);
	}

	@Test
	public void contaCorrenteFormatadaDeveTerOitoDigitos() {
		String numeroFormatado = this.banco.getCodigoBeneficiarioFormatado(this.beneficiario);
		assertEquals(8, numeroFormatado.length());
		assertEquals("00076000", numeroFormatado);
	}

	@Test
	public void testNumeroFormatadoNoCodigoDeBarraDoBancoDoBrasil() {
		this.banco = new BancoDoBrasil();
		this.boleto = this.boleto.comBanco(this.banco);

		assertEquals("001", this.banco.geraCodigoDeBarrasPara(this.boleto).substring(0, 3));
	}

	@Test
	public void testCodEspecieMoedaNoCodigoDeBarraDoBancoDoBrasil() {
		this.banco = new BancoDoBrasil();
		this.boleto = this.boleto.comBanco(this.banco);

		assertEquals("9", this.banco.geraCodigoDeBarrasPara(this.boleto).substring(3, 4));
	}

	@Test
	public void testDigitoVerificadorNoCodigoDeBarraDoBancoDoBrasil() {
		this.banco = new BancoDoBrasil();
		this.boleto = this.boleto.comBanco(this.banco);

		assertEquals("5", this.banco.geraCodigoDeBarrasPara(this.boleto).substring(4, 5));
	}

	@Test
	public void testFatorVencimentoNoCodigoDeBarraDoBancoDoBrasil() {
		this.banco = new BancoDoBrasil();
		this.boleto = this.boleto.comBanco(this.banco);

		assertEquals("3860", this.banco.geraCodigoDeBarrasPara(this.boleto).substring(5, 9));
	}

	@Test
	public void testValorNominalNoCodigoDeBarraDoBancoDoBrasil() {
		this.banco = new BancoDoBrasil();
		this.boleto = this.boleto.comBanco(this.banco);

		assertEquals("0000004000", this.banco.geraCodigoDeBarrasPara(this.boleto).substring(9, 19));
	}

	@Test
	public void testCampoLivreNoCodigoDeBarraDoBancoDoBrasil() {
		this.banco = new BancoDoBrasil();
		this.boleto = this.boleto.comBanco(this.banco);

		assertEquals("0000001207113000900020618", this.banco.geraCodigoDeBarrasPara(this.boleto).substring(19, 44));
	}

	@Test
	public void testZerosNoCampoLivreNoCodigoDeBarraDoBancoDoBrasil() {
		this.banco = new BancoDoBrasil();
		this.boleto = this.boleto.comBanco(this.banco);

		assertEquals("000000", this.banco.geraCodigoDeBarrasPara(this.boleto).substring(19, 25));
	}

	@Test
	public void testNumConvenioFormatadoNoCampoLivreNoCodigoDeBarraDoBancoDoBrasil() {
		this.banco = new BancoDoBrasil();
		this.boleto = this.boleto.comBanco(this.banco);

		assertEquals("1207113", this.banco.geraCodigoDeBarrasPara(this.boleto).substring(25, 32));
	}

	@Test
	public void testNossoNumeroFormatadoNoCampoLivreNoCodigoDeBarraDoBancoDoBrasil() {
		this.banco = new BancoDoBrasil();
		this.boleto = this.boleto.comBanco(this.banco);

		assertEquals("0009000206", this.banco.geraCodigoDeBarrasPara(this.boleto).substring(32, 42));
	}

	@Test
	public void testCarteiraNoCampoLivreNoCodigoDeBarraDoBancoDoBrasil() {
		this.banco = new BancoDoBrasil();
		this.boleto = this.boleto.comBanco(this.banco);

		assertEquals("18", this.banco.geraCodigoDeBarrasPara(this.boleto).substring(42, 44));
	}

	@Test
	public void testCodigoDeBarraDoBancoDoBrasil() {
		this.banco = new BancoDoBrasil();
		this.boleto = this.boleto.comBanco(this.banco);

		assertEquals("00195386000000040000000001207113000900020618", this.banco.geraCodigoDeBarrasPara(this.boleto));
	}

	@Test
	public void testLinhaDoBancoDoBrasil() {
		this.banco = new BancoDoBrasil();
		this.boleto = this.boleto.comBanco(this.banco);
		GeradorDeLinhaDigitavel linhaDigitavelGenerator = new GeradorDeLinhaDigitavel();
		String codigoDeBarras = boleto.getBanco().geraCodigoDeBarrasPara(this.boleto);

		assertEquals("00190.00009  01207.113000  09000.206186  5  38600000004000",
				linhaDigitavelGenerator.geraLinhaDigitavelPara(codigoDeBarras,this.banco));
	}

	@Test
	public void testGetImage() {
		assertNotNull(this.banco.getImage());
	}

	@Test
	public void testCarteira17ComConvenioSeteDigitosMaior1000000() {
		this.banco = new BancoDoBrasil();
		this.boleto = this.boleto.comBanco(this.banco);
		
		Beneficiario beneficiario = Beneficiario.novoBeneficiario().comNumeroConvenio("2670001").comCarteira("17");
		this.boleto.comBeneficiario(beneficiario);

		assertEquals("00191386000000040000000002670001000000000017", this.banco.geraCodigoDeBarrasPara(boleto));
	}

}
