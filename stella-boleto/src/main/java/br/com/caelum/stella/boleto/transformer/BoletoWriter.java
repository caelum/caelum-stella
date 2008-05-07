package br.com.caelum.stella.boleto.transformer;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public interface BoletoWriter {
	void write(float x, float y, String text);
	void writeBold(float x, float y, String text);
	void writeImage(float x, float y, BufferedImage image, float width, float height) throws IOException;
	InputStream toInputStream();
}
