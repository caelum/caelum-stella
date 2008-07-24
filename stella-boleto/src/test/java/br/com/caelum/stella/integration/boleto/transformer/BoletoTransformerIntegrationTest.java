package br.com.caelum.stella.integration.boleto.transformer;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.pdfbox.pdmodel.PDDocument;
import org.pdfbox.util.PDFTextStripper;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.Sacado;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.transformer.BoletoGenerator;

/**
 * Teste de INTEGRACAO apesar de estar no de unidade FIXME
 * 
 */
public class BoletoTransformerIntegrationTest {

    @BeforeClass
    public static void setUp() {

	Boleto boleto;
	Datas datas = Datas.newDatas().withDocumento(4, 5, 2008)
		.withProcessamento(4, 5, 2008).withVencimento(2, 5, 2008);

	Emissor emissor = Emissor.newEmissor().withCedente("Caue").withAgencia(
		1824).withDvAgencia("4").withContaCorrente(76000)
		.withNumConvenio(1207113).withDvContaCorrete("5").withCarteira(
			18).withNossoNumero(9000206);

	Sacado sacado = Sacado.newSacado().withNome("Fulano da Silva").withCpf(
		"111.222.333-12").withEndereco("Av dos testes, 111 apto 333")
		.withBairro("Bairro Teste").withCep("01234-111").withCidade(
			"São Paulo").withUf("SP");

	String[] descricoes = { "descricao 1", "descricao 2", "descricao 3",
		"descricao 4", "descricao 5" };

	String[] locaisDePagamento = { "local 1", "local 2" };

	String[] instrucoes = { "instrucao 1", "instrucao 2", "instrucao 3",
		"instrucao 4", "instrucao 5" };

	Banco banco = new BancoDoBrasil();

	boleto = Boleto.newBoleto().withBanco(banco).withDatas(datas)
		.withDescricoes(descricoes).withEmissor(emissor).withSacado(
			sacado).withValorBoleto("40.00")
		.withNoDocumento("4323").withInstrucoes(instrucoes)
		.withLocaisDePagamento(locaisDePagamento);

	BoletoGenerator generator = new BoletoGenerator(boleto);

	generator.toPDF("arquivo.pdf");
	generator.toPNG("arquivo.png");
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

	assertTrue(text.contains("40.00"));
    }

    @Test
    public void testPDFWrriteEscreveLinhaDigitavelCorreta() throws IOException {
	PDFTextStripper stripper = new PDFTextStripper();

	PDDocument document = PDDocument.load(new File("arquivo.pdf"));
	String text = stripper.getText(document);
	document.close();

	assertTrue(text
		.contains("00190.00009  01207.113000  09000.206186  5  38600000004000"));
    }

    @Test
    public void testPNGWriteGeneration() {
	assertTrue(new File("arquivo.png").exists());
    }

    @AfterClass
    @BeforeClass
    public static void apagaArquivosGerados() {
	final File pngFile = new File("arquivo.png");
	final File pdfFile = new File("arquivo.pdf");
	apagaArquivoSeExistir(pngFile);
	apagaArquivoSeExistir(pdfFile);
    }

    private static void apagaArquivoSeExistir(final File pngFile) {
	if (pngFile.exists()) {
	    (pngFile).delete();
	}
    }
}
