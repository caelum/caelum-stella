package br.com.caelum.stella.boleto.transformer;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public interface BoletoWriter {
	
	/**
	 * Escreve um texto na posição x, y com fonte normal (VERDANA, 8)
	 * 
	 * @param x
	 * @param y
	 * @param text
	 */
	void write(float x, float y, String text);
	
	/**
	 * Escreve um texto na posição x, y com fonte bold (VERDANA_BOLD, 10)
	 * 
	 * @param x
	 * @param y
	 * @param text
	 */
	void writeBold(float x, float y, String text);
	
	/**
	 * Escreve uma imagem na posição x, y
	 * 
	 * @param x
	 * @param y
	 * @param image
	 * @param width
	 * @param height
	 * @throws IOException
	 */
	void writeImage(float x, float y, BufferedImage image, float width, float height) throws IOException;
	
	/**
	 * Grava num InputStream
	 * 
	 * @return
	 */
	InputStream toInputStream();
}
