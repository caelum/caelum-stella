package br.com.caelum.stella.boleto.transformer;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
		File file = new File(arquivo);
		geraPDF(file);
	}

	/**
	 * Gera um boleto em PDF, e grava no arquivo indicado
	 * 
	 * @param arquivo
	 */
	public void geraPDF(File arquivo) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(arquivo);
			byte[] b = geraPDF();

			fos.write(b);
		} catch (Exception e) {
			throw new GeracaoBoletoException("Erro na geração do boleto em PDF", e);
		} finally {
			fecharSilenciosamente(fos);
		}
	}

	private void fecharSilenciosamente(Closeable c) {
		try {
			c.close();
		} catch (Exception e) {
		}
	}

	/**
	 * Gera um boleto em PNG, e grava no caminho indicado
	 * 
	 * @param arquivo
	 */
	public void geraPNG(String arquivo) {
		File file = new File(arquivo);
		geraPNG(file);
	}

	/**
	 * Gera um boleto em PNG, e grava no arquivo indicado
	 * 
	 * @param arquivo
	 */
	public void geraPNG(File arquivo) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(arquivo);

			byte[] b = geraPNG();

			fos.write(b);
		} catch (FileNotFoundException e) {
			throw new GeracaoBoletoException("Erro na geração do boleto em PNG", e);
		} catch (IOException e) {
			throw new GeracaoBoletoException("Erro na geração do boleto em PNG", e);
		} finally {
			fecharSilenciosamente(fos);
		}

	}

	/**
	 * Devolve um array de bytes representando o PDF desse boleto ja gerado.
	 */
	public byte[] geraPDF() {
		return gera(new PDFBoletoWriter());
	}

	/**
	 * Devolve um array de bytes representando o PNG desse boleto ja gerado.
	 */
	public byte[] geraPNG() {
		return gera(new PNGBoletoWriter());
	}

	/**
	 * Devolve o array de bytes do boleto escrito pelo writer indicado.
	 * 
	 * @param writer
	 * @return
	 */
	private byte[] gera(BoletoWriter writer) {
		BoletoTransformer transformer = new BoletoTransformer(writer);

		InputStream is = transformer.transform(this.boletos);

		byte[] b;
		try {
			b = new byte[is.available()];
			is.read(b);

		} catch (NumberFormatException e) {
			throw new GeracaoBoletoException("Erro na geração do boleto em HTML", e);
		} catch (IOException e) {
			throw new GeracaoBoletoException("Erro na geração do boleto em HTML", e);
		} finally {
			fecharSilenciosamente(is);
		}
		return b;
	}
}
