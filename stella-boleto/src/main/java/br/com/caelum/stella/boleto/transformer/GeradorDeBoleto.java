package br.com.caelum.stella.boleto.transformer;

import br.com.caelum.stella.boleto.transformer.template_basico.PDFBoletoWriter;
import br.com.caelum.stella.boleto.transformer.template_basico.PNGBoletoWriter;
import java.io.File;
import java.io.InputStream;

import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.exception.GeracaoBoletoException;

/**
 * Geração do boleto em arquivos. Essa é uma classe utilitária, dessa maneira
 * você não precisa trabalhar com InputStream, byte[], BoletoWriters, etc.
 *
 * Basta passar um Boleto para o construtor e usar o método adequado para gerar
 * um PDF, PNG, etc e grava-lo como o arquivo desejado.
 *
 * @author Cauê Guerra
 *
 */
public class GeradorDeBoleto {

    private final Boleto[] boletos;

    public GeradorDeBoleto(Boleto... boletos) {
        this.boletos = boletos;
    }

    /**
     * Gera um boleto em PDF, e grava no caminho indicado
     *
     * @param arquivo
     */
    public void geraPDF(String arquivo) {
        geraPDF(arquivo, BoletoTemplate.TEMPLATE_BASICO);
    }

    public void geraPDF(String arquivo, BoletoTemplate boletoTemplate) {
        File file = new File(arquivo);
        geraPDF(file, boletoTemplate);
    }

    /**
     * Gera um boleto em PDF, e grava no arquivo indicado
     *
     * @param arquivo
     */
    public void geraPDF(File arquivo, BoletoTemplate boletoTemplate) {
        new StreamHelper().escreveArquivo(arquivo, geraStream(boletoTemplate.getBoletoPDFWriter()));
    }

    /**
     * Gera um boleto em PNG, e grava no caminho indicado
     *
     * @param arquivo
     */
    public void geraPNG(String arquivo) {
        geraPNG(arquivo, BoletoTemplate.TEMPLATE_BASICO);
    }

    public void geraPNG(String arquivo, BoletoTemplate boletoTemplate) {
        File file = new File(arquivo);
        geraPNG(file, boletoTemplate);
    }

    /**
     * Gera um boleto em PNG, e grava no arquivo indicado
     *
     * @param arquivo
     */
    public void geraPNG(File arquivo, BoletoTemplate boletoTemplate) {
        new StreamHelper().escreveArquivo(arquivo, geraStream(boletoTemplate.getBoletoPNGWriter()));
    }

    /**
     * Devolve um array de bytes representando o PDF desse boleto ja gerado.
     */
    public byte[] geraPDF() {
        return geraPDF(BoletoTemplate.TEMPLATE_BASICO);
    }

    public byte[] geraPDF(BoletoTemplate boletoTemplate) {
        return new StreamHelper().geraBytes(geraStream(boletoTemplate.getBoletoPDFWriter()));
    }

    /**
     * Devolve um array de bytes representando o PNG desse boleto ja gerado.
     */
    public byte[] geraPNG() {
        return geraPNG(BoletoTemplate.TEMPLATE_BASICO);
    }

    public byte[] geraPNG(BoletoTemplate boletoTemplate) {
        return new StreamHelper().geraBytes(geraStream(boletoTemplate.getBoletoPNGWriter()));
    }

    /**
     * Devolve um array de bytes representando o HTML desse boleto ja gerado.
     *
     * @return
     */
    public byte[] geraHTML() {
        return new StreamHelper().geraBytes(geraStream(new HTMLBoletoWriter()));
    }

    public void geraHTML(File arquivo) {
        new StreamHelper().escreveArquivo(arquivo, geraStream(new HTMLBoletoWriter()));
    }

    public void geraHTML(String arquivo) {
        File file = new File(arquivo);
        geraHTML(file);
    }

    public InputStream geraHTMLStream() {
        return geraStream(new HTMLBoletoWriter());
    }

    public InputStream geraPDFStream() {
        return geraStream(new PDFBoletoWriter());
    }

    public InputStream geraPNGStream() {
        return geraStream(new PNGBoletoWriter());
    }

    /**
     * Devolve o InputStream do boleto escrito pelo writer indicado.
     *
     * @param writer Tipo de writer para gerar o boleto
     */
    public InputStream geraStream(BoletoWriter writer) {
        try {
            BoletoTransformer transformer = new BoletoTransformer(writer);
            return transformer.transform(this.boletos);
        } catch (Exception e) {
            throw new GeracaoBoletoException("Erro na geração do boleto", e);
        }

    }
}
