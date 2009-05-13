package br.com.caelum.stella.boleto.transformer;

import java.io.InputStream;

import br.com.caelum.stella.boleto.Boleto;

/**
 * Classe responsável por escrever os dados de um Boleto em um Writer. Um
 * Writer, como é uma interface, pode acabar escrevendo em um PNG, JPG, PDF,
 * HTML ou mesmo TXT, de acordo com sua implementação
 * 
 * @author Paulo Silveira
 * 
 */
public class BoletoTransformer {

	private final BoletoWriter writer;

	public BoletoTransformer(BoletoWriter writer) {
		this.writer = writer;
	}

	/**
	 * Gera o boleto em memoria e aloca-o em um InputStream.
	 * 
	 * @param boleto
	 * 
	 */
	public InputStream transform(Boleto... boletos) {

		boolean firstPage = true;
		for (Boleto boleto : boletos) {
			if (!firstPage) {
				this.writer.newPage();
			}
			this.writer.write(boleto);
			firstPage = false;
		}
		return this.writer.toInputStream();
	}

}
