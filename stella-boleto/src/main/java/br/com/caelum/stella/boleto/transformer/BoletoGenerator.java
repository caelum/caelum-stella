package br.com.caelum.stella.boleto.transformer;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.GeracaoBoletoException;

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
public class BoletoGenerator {

    private final Boleto[] boletos;

    public BoletoGenerator(Boleto... boletos) {
        this.boletos = boletos;
    }

    /**
     * Gera um boleto em PDF, e grava no caminho indicado
     * 
     * @param arquivo
     */
    public void toPDF(String arquivo) {
        File file = new File(arquivo);
        toPDF(file);
    }

    /**
     * Gera um boleto em PDF, e grava no arquivo indicado
     * 
     * @param arquivo
     */
    public void toPDF(File arquivo) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(arquivo);
            byte[] b = toPDF();

            fos.write(b);
            fos.close();
        } catch (FileNotFoundException e) {
            throw new GeracaoBoletoException(
                    "Erro na geração do boleto em PDF", e);
        } catch (NumberFormatException e) {
            throw new GeracaoBoletoException(
                    "Erro na geração do boleto em PDF", e);
        } catch (IOException e) {
            throw new GeracaoBoletoException(
                    "Erro na geração do boleto em PDF", e);
        } finally {
            tryToClose(fos);
        }
    }

    private void tryToClose(Closeable c) {
        try {
            c.close();
        } catch (IOException e) {
            throw new GeracaoBoletoException("Erro ao fechar stream", e);
        }
    }

    /**
     * Gera um boleto em PNG, e grava no caminho indicado
     * 
     * @param arquivo
     */
    public void toPNG(String arquivo) {
        File file = new File(arquivo);
        toPNG(file);
    }

    /**
     * Gera um boleto em PNG, e grava no arquivo indicado
     * 
     * @param arquivo
     */
    public void toPNG(File arquivo) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(arquivo);

            byte[] b = toPNG();

            fos.write(b);
        } catch (FileNotFoundException e) {
            throw new GeracaoBoletoException(
                    "Erro na geração do boleto em PNG", e);
        } catch (IOException e) {
            throw new GeracaoBoletoException(
                    "Erro na geração do boleto em PNG", e);
        } finally {
            tryToClose(fos);
        }

    }

    /**
     * Devolve um array de bytes representando o PDF desse boleto ja gerado.
     */
    public byte[] toPDF() {
        return to(new PDFBoletoWriter());
    }

    /**
     * Devolve um array de bytes representando o PNG desse boleto ja gerado.
     */
    public byte[] toPNG() {
        return to(new PNGBoletoWriter());
    }

    private byte[] to(BoletoWriter writer) {
        BoletoTransformer transformer = new BoletoTransformer(writer);

        InputStream is = transformer.transform(this.boletos);

        byte[] b;
        try {
            b = new byte[is.available()];
            is.read(b);

        } catch (NumberFormatException e) {
            throw new GeracaoBoletoException(
                    "Erro na geração do boleto em PDF", e);
        } catch (IOException e) {
            throw new GeracaoBoletoException(
                    "Erro na geração do boleto em PDF", e);
        } finally {
            tryToClose(is);
        }
        return b;
    }
}
