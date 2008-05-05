package br.com.caelum.stella.boleto.transformer;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class PNGBoletoWriter implements BoletoWriter {

	private BufferedImage image;
	private InputStream stream;
	private Graphics2D graphics;

	public PNGBoletoWriter() {
		this(514.22f, 385.109f);
	}

	public PNGBoletoWriter(double w, double h) {
		this.image = new BufferedImage((int) w, (int) h,
				BufferedImage.TYPE_INT_ARGB);
		this.graphics = image.createGraphics();
	}

	public InputStream toInputStream() {
		if (this.stream == null) {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			try {
				ImageIO.write(this.image, "PNG", baos);
			} catch (IOException e) {
				throw new RuntimeException(e); // nao esperado
			}
			this.stream = new ByteArrayInputStream(baos.toByteArray());
		}
		return this.stream;
	}

	public void write(float x, float y, String text) {
		checkIfDocIsClosed();
		this.graphics.drawString(text, (int) scaleX(x), (int) scaleY(y));
	}


	public void writeBold(float x, float y, String text) {
		checkIfDocIsClosed();
		this.graphics.drawString(text, (int) scaleX(x), (int) scaleY(y));
	}

	public void writeImage(float x, float y, BufferedImage image, float width,
			float height) throws IOException {

		checkIfDocIsClosed();

		image = scaleTo(image, (int) width, (int) height);
		graphics.drawImage(image, (int) scaleX(x), (int) scaleY(y), image.getWidth(), image
				.getHeight(), null);
	}

	private void checkIfDocIsClosed() {
		if (stream != null) {
			throw new IllegalStateException(
					"boleto ja gerado, voce nao pode mais escrever na imagem");
		}
	}


	/*
	 * Convertendo coordenadas PDF para PNG
	 */
	private float scaleY(float y) {
		//System.out.println(y);
		y = this.image.getHeight() - y;
		return y * 1.3f;
	}

	private float scaleX(float x) {
		return x * 1.3f;
	}

	/*
	 * Metodos auxiliares para trabalhar com BufferedImages com Java 2D
	 */

	private BufferedImage scaleTo(BufferedImage image, double scale) {
		if (scale == 1)
			return image;
		return scaleTo(image, (int) (image.getWidth() * scale), (int) (image
				.getHeight() * scale));
	}

	static BufferedImage scaleTo(BufferedImage image, int width, int height) {
		return getScaledInstance(image, width, height,
				RenderingHints.VALUE_INTERPOLATION_BILINEAR, true);
	}

	/**
	 * Convenience method that returns a scaled instance of the provided
	 * {@code BufferedImage}.
	 * 
	 * @param img
	 *            the original image to be scaled
	 * @param targetWidth
	 *            the desired width of the scaled instance, in pixels
	 * @param targetHeight
	 *            the desired height of the scaled instance, in pixels
	 * @param hint
	 *            one of the rendering hints that corresponds to
	 *            {@code RenderingHints.KEY_INTERPOLATION} (e.g.
	 *            {@code RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR},
	 *            {@code RenderingHints.VALUE_INTERPOLATION_BILINEAR},
	 *            {@code RenderingHints.VALUE_INTERPOLATION_BICUBIC})
	 * @param higherQuality
	 *            if true, this method will use a multi-step scaling technique
	 *            that provides higher quality than the usual one-step technique
	 *            (only useful in down-scaling cases, where {@code targetWidth}
	 *            or {@code targetHeight} is smaller than the original
	 *            dimensions, and generally only when the {@code BILINEAR} hint
	 *            is specified)
	 * @return a scaled version of the original {@codey BufferedImage}
	 */
	public static BufferedImage getScaledInstance(BufferedImage img,
			int targetWidth, int targetHeight, Object hint,
			boolean higherQuality) {
		int type = (img.getTransparency() == Transparency.OPAQUE) ? BufferedImage.TYPE_INT_RGB
				: BufferedImage.TYPE_INT_ARGB;
		BufferedImage ret = img;
		int w, h;
		if (higherQuality) {
			// Use multi-step technique: start with original size, then
			// scale down in multiple passes with drawImage()
			// until the target size is reached
			w = img.getWidth();
			h = img.getHeight();
		} else {
			// Use one-step technique: scale directly from original
			// size to target size with a single drawImage() call
			w = targetWidth;
			h = targetHeight;
		}

		do {
			if (higherQuality && w > targetWidth) {
				w /= 2;
				if (w < targetWidth) {
					w = targetWidth;
				}
			}

			if (higherQuality && h > targetHeight) {
				h /= 2;
				if (h < targetHeight) {
					h = targetHeight;
				}
			}

			BufferedImage tmp = new BufferedImage(w, h, type);
			Graphics2D g2 = tmp.createGraphics();
			g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, hint);
			g2.drawImage(ret, 0, 0, w, h, null);
			g2.dispose();

			ret = tmp;
		} while (w != targetWidth || h != targetHeight);

		return ret;
	}

}
