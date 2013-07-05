package br.com.caelum.stella.boleto.transformer;

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
		File file = new File(arquivo);
		geraPDF(file);
	}

	/**
	 * Gera um boleto em PDF, e grava no arquivo indicado
	 * 
	 * @param arquivo
	 */
	public void geraPDF(File arquivo) {
		new StreamHelper().escreveArquivo(arquivo, geraStream(new PDFBoletoWriter()));
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
		new StreamHelper().escreveArquivo(arquivo, geraStream(new PNGBoletoWriter()));
	}

	/**
	 * Devolve um array de bytes representando o PDF desse boleto ja gerado.
	 */
	public byte[] geraPDF() {
		return new StreamHelper().geraBytes(geraStream(new PDFBoletoWriter()));
	}

	/**
	 * Devolve um array de bytes representando o PNG desse boleto ja gerado.
	 */
	public byte[] geraPNG() {
		return new StreamHelper().geraBytes(geraStream(new PNGBoletoWriter()));
	}

	/**
	 * Devolve um array de bytes representando o HTML desse boleto ja gerado.
	 * 
	 * @return
	 */
	public byte[] geraHTML() {
		return new StreamHelper().geraBytes(geraStream(new HTMLBoletoWriter()));
	}

	/**
	 * Gera o boleto no formato html e salva no arquivo indicado
	 * @param arquivo onde será salvo o conteúdo do boleto
	 */
	public void geraHTML(File arquivo) {
		new StreamHelper().escreveArquivo(arquivo, geraStream(new HTMLBoletoWriter()));
	}
	/**
	 * Gera o boleto no formato html e salva em um arquivo no local indicado
	 * @param arquivo onde será salvo o conteúdo do boleto
	 */
	public void geraHTML(String arquivo) {
		File file = new File(arquivo);
		geraHTML(file);
	}

	/**
	 * Gera o boleto no formato html 
	 * @return inputStream com o conteúdo do arquivo
	 */
	public InputStream geraHTMLStream() {
		return geraStream(new HTMLBoletoWriter());
	}
	
	/**
	 * Gera o boleto no formato pdf 
	 * @return inputStream com o conteúdo do arquivo
	 */
	public InputStream geraPDFStream() {
		return geraStream(new PDFBoletoWriter());
	}

	/**
	 * Gera o boleto no formato png 
	 * @return inputStream com o conteúdo do arquivo
	 */
	public InputStream geraPNGStream() {
		return geraStream(new PNGBoletoWriter());
	}

	/**
	 * Devolve o InputStream do boleto escrito pelo writer indicado.
	 * 
	 * @param writer
	 *            Tipo de writer para gerar o boleto
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
