package br.com.caelum.stella.boleto.transformer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

import br.com.caelum.stella.boleto.Boleto;

import com.lowagie.text.DocumentException;

/**
 * Geração do boleto em arquivos
 * 
 * @author Cauê Guerra
 * 
 */
public class GeradorBoleto {

	private BoletoWriter writer;

	private Boleto boleto;

	public GeradorBoleto(Boleto boleto) {
		this.boleto = boleto;
	}

	/**
	 * Gera um boleto em PDF, e grava no caminho indicado
	 * 
	 * @param arquivo
	 * @throws NumberFormatException
	 * @throws IOException
	 * @throws DocumentException
	 * @throws ParseException
	 */
	public void toPDF(String arquivo) throws NumberFormatException,
			IOException, DocumentException, ParseException {
		File file = new File(arquivo);
		toPDF(file);
	}

	/**
	 * Gera um boleto em PDF, e grava no arquivo indicado
	 * 
	 * @param arquivo
	 * @throws NumberFormatException
	 * @throws IOException
	 * @throws DocumentException
	 * @throws ParseException
	 */
	public void toPDF(File arquivo) throws NumberFormatException, IOException,
			DocumentException, ParseException {
		this.writer = new PDFBoletoWriter();

		BoletoTransformer transformer = new BoletoTransformer(this.writer);

		InputStream is = transformer.transform(this.boleto);

		FileOutputStream fos = new FileOutputStream(arquivo);

		byte[] b = new byte[is.available()];
		is.read(b);

		fos.write(b);
		fos.close();
	}

	/**
	 * Gera um boleto em PNG, e grava no caminho indicado
	 * 
	 * @param arquivo
	 * @throws NumberFormatException
	 * @throws IOException
	 * @throws DocumentException
	 * @throws ParseException
	 */
	public void toPNG(String arquivo) throws NumberFormatException,
			IOException, DocumentException, ParseException {
		File file = new File(arquivo);
		toPNG(file);
	}

	/**
	 * Gera um boleto em PNG, e grava no arquivo indicado
	 * 
	 * @param arquivo
	 * @throws NumberFormatException
	 * @throws IOException
	 * @throws DocumentException
	 * @throws ParseException
	 */
	public void toPNG(File arquivo) throws NumberFormatException, IOException,
			DocumentException, ParseException {
		this.writer = new PNGBoletoWriter();

		BoletoTransformer transformer = new BoletoTransformer(this.writer);

		InputStream is = transformer.transform(this.boleto);

		FileOutputStream fos = new FileOutputStream(arquivo);

		byte[] b = new byte[is.available()];
		is.read(b);

		fos.write(b);
		fos.close();
	}

}
