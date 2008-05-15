package br.com.caelum.stella.boleto.transformer;

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

	private final Boleto boleto;

	public BoletoGenerator(Boleto boleto) {
		this.boleto = boleto;
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
		PDFBoletoWriter writer = new PDFBoletoWriter();

		BoletoTransformer transformer = new BoletoTransformer(writer);

		InputStream is = transformer.transform(this.boleto);

		try {
			FileOutputStream fos = new FileOutputStream(arquivo);
			byte[] b = new byte[is.available()];
			is.read(b);

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
		PNGBoletoWriter writer = new PNGBoletoWriter();

		BoletoTransformer transformer = new BoletoTransformer(writer);

		InputStream is = transformer.transform(this.boleto);

		try {
			FileOutputStream fos = new FileOutputStream(arquivo);

			byte[] b = new byte[is.available()];
			is.read(b);

			fos.write(b);
			fos.close();
		} catch (FileNotFoundException e) {
			throw new GeracaoBoletoException(
					"Erro na geração do boleto em PNG", e);
		} catch (IOException e) {
			throw new GeracaoBoletoException(
					"Erro na geração do boleto em PNG", e);
		}

	}
}
