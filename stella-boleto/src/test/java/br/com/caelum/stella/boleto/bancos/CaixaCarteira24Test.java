package br.com.caelum.stella.boleto.bancos;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Pagador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CaixaCarteira24Test {

	private Boleto boleto;
	private Caixa banco = new Caixa();
	private Beneficiario beneficiario;

	@Before
	public void setUp() {

		// /////////////////////////////////////////////////////////////////
		// SET UP de boleto com carteira SIGCB Sem Registro Carteira 2 variação
		// 4 (24)
		// /////////////////////////////////////////////////////////////////

		Datas datas = Datas.novasDatas().comDocumento(10, 07, 2014)
				.comProcessamento(12, 12, 2014).comVencimento(10, 07, 2014);

		this.beneficiario = Beneficiario.novoBeneficiario()
				.comNomeBeneficiario("Empresa A").comAgencia("3531")
				.comDigitoAgencia("9").comCarteira("24")
				.comCodigoBeneficiario("503662")
				.comDigitoCodigoBeneficiario("3")
				.comNossoNumero("24000000000000006").comDigitoNossoNumero("3");

		Pagador pagador = Pagador.novoPagador().comNome(
				"Candidato ao pagamento");

		this.boleto = Boleto.novoBoleto().comDatas(datas)
				.comBeneficiario(beneficiario).comBanco(this.banco)
				.comPagador(pagador).comValorBoleto(1.23)
				.comNumeroDoDocumento("24000000000000006");

	}

	@Test
	public void carteiraFormatadoDeveTerDoisDigitos() {
		Beneficiario beneficiario = Beneficiario.novoBeneficiario().comCarteira("24");
		String numeroFormatado = this.banco.getCarteiraFormatado(beneficiario);
		assertEquals(2, numeroFormatado.length());
		assertEquals("24", numeroFormatado);
	}

	@Test
	public void nossoNumeroDeveComecarCom24() {
		assertEquals("24", this.beneficiario.getNossoNumero().substring(0, 2));
	}

	@Test
	public void nossoNumeroDeveConter17Digitos() {
		assertEquals(17, this.beneficiario.getNossoNumero().length());
	}

	@Test
	public void testLinhaDoBancoCaixaComCarteiraSIGCBSimples() {
		GeradorDeLinhaDigitavel gerador = new GeradorDeLinhaDigitavel();
		String codigoDeBarras = boleto.getBanco().geraCodigoDeBarrasPara(this.boleto);
		String linha = "10495.03665  23000.200040  00000.000604  8  61200000000123";
		assertEquals(linha, gerador.geraLinhaDigitavelPara(codigoDeBarras, this.banco));
	}

	@Test
	public void testCodigoDeBarraDoBancoCaixaComCarteiraSIGCBSimples() {
		assertEquals("10498612000000001235036623000200040000000060", this.banco.geraCodigoDeBarrasPara(this.boleto));
	}

	@Test
	public void testGetImage() {
		assertNotNull(this.banco.getImage());
	}
}
