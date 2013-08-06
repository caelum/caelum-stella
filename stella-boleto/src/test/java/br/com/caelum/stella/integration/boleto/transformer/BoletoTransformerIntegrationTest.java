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
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;

/**
 * Teste de INTEGRACAO apesar de estar no de unidade FIXME
 * 
 */
public class BoletoTransformerIntegrationTest {

	@Before
	public void setUp() {

		Locale.setDefault(new Locale("pt", "br"));

		apagaArquivosGerados();

		Boleto boleto;
		Datas datas = Datas.novasDatas().comDocumento(4, 5, 2008).comProcessamento(4, 5, 2008)
				.comVencimento(2, 5, 2008);
		Emissor emissor = Emissor.novoEmissor().comCedente("Caue").comAgencia(1824).comDigitoAgencia('4')
				.comContaCorrente(76000).comNumeroConvenio(1207113).comDigitoContaCorrente('5').comCarteira(18)
				.comNossoNumero(9000206);

		Sacado sacado = Sacado.novoSacado().comNome("Fulano da Silva").comCpf("111.222.333-12")
				.comEndereco("Av dos testes, 111 apto 333").comBairro("Bairro Teste").comCep("01234-111")
				.comCidade("São Paulo").comUf("SP");

		String[] descricoes = { "descricao 1", "descricao 2", "descricao 3", "descricao 4", "descricao 5" };

		String[] locaisDePagamento = { "local 1", "local 2" };

		String[] instrucoes = { "instrucao 1", "instrucao 2", "instrucao 3", "instrucao 4", "instrucao 5" };

		Banco banco = new BancoDoBrasil();

		boleto = Boleto.novoBoleto().comBanco(banco).comDatas(datas).comDescricoes(descricoes).comEmissor(emissor)
				.comSacado(sacado).comValorBoleto("40.00").comNumeroDoDocumento("4323").comInstrucoes(instrucoes)
				.comLocaisDePagamento(locaisDePagamento);

		GeradorDeBoleto generator = new GeradorDeBoleto(boleto);

		generator.geraPDF("arquivo.pdf");
		generator.geraPNG("arquivo.png");

	}

	@Test
	public void testPDFWriterGeneration() {
		assertTrue(new File("arquivo.pdf").exists());
	}

	@Test
	public void testPDFWriterEscreveValorCorreto() throws IOException {
		PDFTextStripper stripper = new PDFTextStripper();

		PDDocument document = PDDocument.load(new File("arquivo.pdf"));
		String text = stripper.getText(document);
		document.close();
		assertTrue(text.contains("40,00"));
	}

	@Test
	public void testPDFWriterEscreveLinhaDigitavelCorreta() throws IOException {
		PDFTextStripper stripper = new PDFTextStripper();

		PDDocument document = PDDocument.load(new File("arquivo.pdf"));
		String text = stripper.getText(document);
		document.close();

		assertTrue(text.contains("00190.00009  01207.113000  09000.206186  5  38600000004000"));
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
			pngFile.delete();
		}
	}

}
