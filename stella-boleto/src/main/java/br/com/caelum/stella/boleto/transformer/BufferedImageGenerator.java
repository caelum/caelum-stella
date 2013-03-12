package br.com.caelum.stella.boleto.transformer;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 * Gerador de BufferedImage a partir de Image
 * 
 * @author Alberto Pc
 * 
 */
class BufferedImageGenerator {

	static BufferedImage generateBufferedImageFor(Image image, int type) {
		int w = image.getWidth(null);
		int h = image.getHeight(null);
		BufferedImage result = new BufferedImage(w, h, type);
		Graphics2D g = result.createGraphics();
		g.drawImage(image, 0, 0, null);
		g.dispose();
		return result;
	}
}
