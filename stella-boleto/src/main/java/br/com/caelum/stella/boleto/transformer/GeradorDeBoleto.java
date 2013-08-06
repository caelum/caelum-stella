package br.com.caelum.stella.boleto.transformer;

import br.com.caelum.stella.boleto.transformer.templatebasico.PDFBoletoWriterBasic;
import br.com.caelum.stella.boleto.transformer.templatebasico.PNGBoletoWriterBasic;
import java.io.File;
import java.io.InputStream;

import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.exception.GeracaoBoletoException;
import br.com.caelum.stella.boleto.transformer.template2.PDFBoletoWriter2;
import br.com.caelum.stella.boleto.transformer.template2.PNGBoletoWriter2;

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
    public void geraPDFBasic(String arquivo) {
        File file = new File(arquivo);
        geraPDF(file, new PDFBoletoWriterBasic());
    }

    public void geraPDF2(String arquivo) {
        File file = new File(arquivo);
        geraPDF(file, new PDFBoletoWriter2());
    }

    /**
     * Gera um boleto em PDF, e grava no arquivo indicado
     *
     * @param arquivo
     */
    public void geraPDF(File arquivo, BoletoWriter boletoWriter) {
        new StreamHelper().escreveArquivo(arquivo, geraStream(boletoWriter));
    }

    /**
     * Gera um boleto em PNG, e grava no caminho indicado
     *
     * @param arquivo
     */
    public void geraPNGBasic(String arquivo) {
        File file = new File(arquivo);
        geraPNG(file, new PNGBoletoWriterBasic());
    }

    /* Gera um boleto em PNG, e grava no caminho indicado
     *
     * @param arquivo
     */
    public void geraPNG2(String arquivo) {
        File file = new File(arquivo);
        geraPNG(file, new PNGBoletoWriter2());
    }

    /**
     * Gera um boleto em PNG, e grava no arquivo indicado
     *
     * @param arquivo
     */
    public void geraPNG(File arquivo, BoletoWriter boletoWriter) {
        new StreamHelper().escreveArquivo(arquivo, geraStream(boletoWriter));
    }

    /**
     * Devolve um array de bytes representando o PDF desse boleto ja gerado.
     */
    public byte[] geraPDF() {
        return new StreamHelper().geraBytes(geraStream(new PDFBoletoWriterBasic()));
    }

    /**
     * Devolve um array de bytes representando o PNG desse boleto ja gerado.
     */
    public byte[] geraPNG() {
        return new StreamHelper().geraBytes(geraStream(new PNGBoletoWriterBasic()));
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
        return geraStream(new PDFBoletoWriterBasic());
    }

    public InputStream geraPNGStream() {
        return geraStream(new PNGBoletoWriterBasic());
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
