package br.com.caelum.stella.boleto.bancos;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Pagador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BradescoTest {

	private Boleto boleto;
	private Bradesco banco;
	private Beneficiario beneficiario;

	@Before
	public void setUp() {
		Datas datas = Datas.novasDatas().comDocumento(31, 5, 2006).comProcessamento(31, 5, 2006)
				.comVencimento(10, 6, 2006);

		this.beneficiario = Beneficiario.novoBeneficiario().comNomeBeneficiario("Leonardo Bessa")
				.comAgencia("2949").comDigitoAgencia("1")
				.comCodigoBeneficiario("6580").comNumeroConvenio("1207113")
				.comDigitoCodigoBeneficiario("3").comCarteira("6")
				.comNossoNumero("3");

		Pagador pagador = Pagador.novoPagador().comNome("Fulano");

		this.banco = new Bradesco();

		this.boleto = Boleto.novoBoleto().comDatas(datas).comBeneficiario(this.beneficiario).comPagador(pagador)
				.comValorBoleto("1.00").comNumeroDoDocumento("4323");
	}

	@Test
	public void nossoNumeroFormatadoDeveTerOnzeDigitos() {
		Beneficiario beneficiario = Beneficiario.novoBeneficiario().comNossoNumero("9000206").comDigitoNossoNumero("7");
		String numeroFormatado = this.banco.getNossoNumeroFormatado(beneficiario);
		assertEquals(11, numeroFormatado.length());
		assertEquals("00009000206", numeroFormatado);
	}

	@Test
	public void carteiraFormatadoDeveTerDoisDigitos() {
		Beneficiario beneficiario = Beneficiario.novoBeneficiario().comCarteira("1");
		String numeroFormatado = this.banco.getCarteiraFormatado(beneficiario);
		assertEquals(2, numeroFormatado.length());
		assertEquals("01", numeroFormatado);
	}

	@Test
	public void contaCorrenteFormatadaDeveTerSeteDigitos() {
		String numeroFormatado = this.banco.getCodigoBeneficiarioFormatado(this.beneficiario);
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
				linhaDigitavelGenerator.geraLinhaDigitavelPara(codigoDeBarras,this.banco));
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
