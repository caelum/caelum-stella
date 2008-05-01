package br.com.caelum.stella.boleto.transformer;

import java.io.InputStream;
import java.net.URL;

/**
 * Writer que sabe escrever num PDF usando IText como dependencia.
 * 
 * @author Paulo Silveira
 *
 */
public class PDFBoletoWriter implements BoletoWriter {

	private InputStream stream;
	public InputStream getInputStream() {
		if(stream == null) {
			
		}
		return stream;
	}

	public void write(int x, int y, String text) {
		checkIfDocIsClosed();
	}

	private void checkIfDocIsClosed() {
		if(stream != null) {
			throw new IllegalStateException("boleto já gerado, você não pode mais escrever na imagem");
		}
	}

	public void writeBold(int x, int y, String text) {
		checkIfDocIsClosed();
	}

	public void writeImage(int x, int y, URL image) {
		checkIfDocIsClosed();
		
	}

}
