package br.com.caelum.stella.boleto.bancos;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Pagador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CaixaTest {

	private Boleto boleto;
	private Caixa banco = new Caixa();
	private Beneficiario beneficiario;
	private Boleto outroBoleto;

	@Before
	public void setUp() {

		///////////////////////////////////////////////////////////////////
		// SET UP de boleto com carteira SINCO
		///////////////////////////////////////////////////////////////////

		Datas datas = Datas.novasDatas().comDocumento(22, 04, 2013)
			.comProcessamento(22, 04, 2013).comVencimento(29, 04, 2013);

		this.beneficiario = Beneficiario.novoBeneficiario().comNomeBeneficiario("Rodrigo Turini")
			.comAgencia("2873").comCarteira("1")
			.comCodigoBeneficiario("2359").comNossoNumero("990000000003994458")
			.comDigitoNossoNumero("0");

		Pagador pagador = Pagador.novoPagador().comNome("Mario Amaral");

		this.boleto = Boleto.novoBoleto().comDatas(datas)
			.comBeneficiario(beneficiario).comBanco(this.banco).comPagador(pagador)
			.comValorBoleto(4016.10).comNumeroDoDocumento("3084373");
		
		///////////////////////////////////////////////////////////////////
		// SET UP de boleto com carteira Sem Registro e Registrada no SIGCB
		///////////////////////////////////////////////////////////////////
		
		Datas datasOutroBoleto = Datas.novasDatas().comDocumento(21, 8, 2012)
				.comProcessamento(21, 8, 2012).comVencimento(04, 9, 2012);

		Beneficiario beneficiario = Beneficiario.novoBeneficiario().comNomeBeneficiario("Guilherme")
			.comAgencia("589").comCarteira("2")
			.comCodigoBeneficiario("290274").comDigitoCodigoBeneficiario("5")
			.comNossoNumero("24900000000000132")
			.comDigitoNossoNumero("3");

		Pagador pagadorOutroBoleto = Pagador.novoPagador().comNome("Paulo");

		this.outroBoleto = Boleto.novoBoleto().comDatas(datasOutroBoleto)
			.comBeneficiario(beneficiario).comBanco(banco).comPagador(pagadorOutroBoleto)
			.comValorBoleto(80.00).comNumeroDoDocumento("00000000132");
	}


	@Test
	public void carteiraFormatadoDeveTerDoisDigitos() {
		Beneficiario beneficiario = Beneficiario.novoBeneficiario().comCarteira("1");
		String numeroFormatado = this.banco
				.getCarteiraFormatado(beneficiario);
		assertEquals(2, numeroFormatado.length());
		assertEquals("01", numeroFormatado);
	}

	@Test
	public void contaCorrenteFormatadaDeveTerCincoDigitos() {
		String numeroFormatado = this.banco
			.getCodigoBeneficiarioFormatado(this.beneficiario);
		assertEquals(5, numeroFormatado.length());
		assertEquals("02359", numeroFormatado);
	}

	@Test
	public void testLinhaDoBancoCaixaComCarteiraSINCO() {
		GeradorDeLinhaDigitavel gerador = new GeradorDeLinhaDigitavel();
		String codigoDeBarras = boleto.getBanco().geraCodigoDeBarrasPara(this.boleto);
		String linha = "10491.00231  59990.000008  00039.944582  2  56830000401610";
		assertEquals(linha, gerador.geraLinhaDigitavelPara(codigoDeBarras,this.banco));
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
		assertEquals(linha, gerador.geraLinhaDigitavelPara(codigoDeBarras,this.banco));
	}

	@Test
	public void testCodigoDeBarraDoBancoCaixaComCarteiraSICGB() {
		assertEquals("10499544600000080002902745900200040000001322",
				this.banco.geraCodigoDeBarrasPara(this.outroBoleto));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deveLancarExceptionSeCarteiraNaoForSuportada() throws Exception {
		this.outroBoleto.getBeneficiario().comCarteira("3");
		assertEquals("10499544600000080002902745900200040000001322",
				this.banco.geraCodigoDeBarrasPara(this.outroBoleto));
	}
	
	@Test
	public void testGetImage() {
		assertNotNull(this.banco.getImage());
	}
}
