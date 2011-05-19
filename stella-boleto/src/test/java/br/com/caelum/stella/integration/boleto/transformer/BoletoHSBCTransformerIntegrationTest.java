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
import br.com.caelum.stella.boleto.transformer.BoletoGenerator;

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

        Datas datas = Datas.newDatas().withDocumento(03, 7, 2000).withVencimento(04, 7, 2000);

        Emissor emissor = Emissor
                                 .newEmissor()
                                 .withCedente("Alberto")
                                 .withAgencia(501)
                                 .withContaCorrente(6703255)
                                 .withNossoNumero(39104766)
                                 .withCodigoFornecidoPelaAgencia(351202)
                                 .withCarteira(0)
                                 .withDigitoNossoNumero('3');

        Sacado sacado = Sacado
                              .newSacado()
                              .withNome("Fulano da Silva")
                              .withCpf("111.222.333-12")
                              .withEndereco("Av dos testes, 111 apto 333")
                              .withBairro("Bairro Teste")
                              .withCep("01234-111")
                              .withCidade("São Paulo")
                              .withUf("SP");

        Banco banco = new HSBC();

        String[] descricoes = { "descricao 1", "descricao 2", "descricao 3", "descricao 4", "descricao 5" };

        String[] locaisDePagamento = { "local 1", "local 2" };

        String[] instrucoes = { "instrucao 1", "instrucao 2", "instrucao 3", "instrucao 4", "instrucao 5" };

        Boleto boleto = Boleto.newBoleto().withDatas(datas).withEmissor(emissor).withSacado(sacado).withValorBoleto(
                "1200.00").withNumeroDoDocumento("39104766").withDescricoes(descricoes).withLocaisDePagamento(
                locaisDePagamento).withInstrucoes(instrucoes);
        boleto.withBanco(banco);

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

        assertTrue(text.contains("1.200,00"));
    }

    @Test
    public void testPDFWrriteEscreveLinhaDigitavelCorreta() throws IOException {
        PDFTextStripper stripper = new PDFTextStripper();

        PDDocument document = PDDocument.load(new File("arquivo.pdf"));
        String text = stripper.getText(document);
        document.close();

        assertTrue(text.contains("39990.35128  02000.003919  04766.186029  3  10010000120000"));
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
