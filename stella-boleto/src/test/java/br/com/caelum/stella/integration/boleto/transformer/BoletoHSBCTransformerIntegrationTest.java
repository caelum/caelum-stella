package br.com.caelum.stella.integration.boleto.transformer;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.pdfbox.pdmodel.PDDocument;
import org.pdfbox.util.PDFTextStripper;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.Sacado;
import br.com.caelum.stella.boleto.bancos.HSBC;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;

/**
 * Teste de INTEGRACAO apesar de estar no de unidade FIXME
 * 
 */
public class BoletoHSBCTransformerIntegrationTest {

	@Before
	public void setUp() {
		System.out.println("begin setup: " + Runtime.getRuntime().freeMemory());
		Locale.setDefault(new Locale("pt", "br"));

		apagaArquivosGerados();

		Datas datas = Datas.novasDatas().comDocumento(03, 7, 2000).comVencimento(04, 7, 2000);

		Emissor emissor = Emissor.novoEmissor().comCedente("Alberto").comAgencia(501).comContaCorrente(6703255)
				.comNossoNumero(39104766).comCodigoFornecidoPelaAgencia(351202).comCarteira(0)
				.comDigitoNossoNumero("3");

		Sacado sacado = Sacado.novoSacado().comNome("Fulano da Silva").comCpf("111.222.333-12")
				.comEndereco("Av dos testes, 111 apto 333").comBairro("Bairro Teste").comCep("01234-111")
				.comCidade("São Paulo").comUf("SP");

		Banco banco = new HSBC();

		String[] descricoes = { "descricao 1", "descricao 2", "descricao 3", "descricao 4", "descricao 5" };

		String[] locaisDePagamento = { "local 1", "local 2" };

		String[] instrucoes = { "instrucao 1", "instrucao 2", "instrucao 3", "instrucao 4", "instrucao 5" };

		Boleto boleto = Boleto.novoBoleto().comDatas(datas).comEmissor(emissor).comSacado(sacado)
				.comValorBoleto("1200.00").comNumeroDoDocumento("39104766").comDescricoes(descricoes)
				.comLocaisDePagamento(locaisDePagamento).comInstrucoes(instrucoes);
		boleto.comBanco(banco);

		GeradorDeBoleto generator = new GeradorDeBoleto(boleto);

		generator.geraPDF("arquivo.pdf");
		generator.geraPNG("arquivo.png");

	}

	@Test
	public void testPDFWriteGeneration() {
		assertTrue(new File("arquivo.pdf").exists());
	}

	@Test
	public void testPDFWrriteEscreveValorCorreto() throws IOException {
		PDFTextStripper stripper = new PDFTextStripper();

		PDDocument document = PDDocument.load(new File("arquivo.pdf"));
		String text = stripper.getText(document);
		document.close();

		assertTrue(text.contains("1.200,00"));
	}

	@Test
	public void testPDFWrriteEscreveLinhaDigitavelCorreta() throws IOException {
		PDFTextStripper stripper = new PDFTextStripper();

		PDDocument document = PDDocument.load(new File("arquivo.pdf"));
		String text = stripper.getText(document);
		document.close();

		assertTrue(text.contains("39990.35128  02000.000006  39104.186026  2  10010000120000"));
	}

	@Test
	public void testPNGWriteGeneration() {
		assertTrue(new File("arquivo.png").exists());
	}

	@After
	public void apagaArquivosGerados() {
		final File pngFile = new File("arquivo.png");
		final File pdfFile = new File("arquivo.pdf");
		apagaArquivoSeExistir(pngFile);
		apagaArquivoSeExistir(pdfFile);
	}

	private void apagaArquivoSeExistir(final File pngFile) {
		if (pngFile.exists()) {
			(pngFile).delete();
		}
	}

}
