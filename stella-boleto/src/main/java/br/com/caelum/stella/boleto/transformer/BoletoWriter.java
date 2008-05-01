package br.com.caelum.stella.boleto.transformer;

import java.net.URL;

public interface BoletoWriter {
	void write(int x, int y, String text);
	void writeBold(int x, int y, String text);
	void writeImage(int x, int y, URL image);
}
