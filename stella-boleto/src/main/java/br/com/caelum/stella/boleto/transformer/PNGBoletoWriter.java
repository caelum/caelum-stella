package br.com.caelum.stella.boleto.transformer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.exception.GeracaoBoletoException;

import com.itextpdf.text.pdf.BaseFont;

/**
 * Writer que sabe escrever num PNG
 * 
 * @see <a
 *      href="http://stella.caelum.com.br/boleto-setup.html">http://stella.caelum

 *      .com.br/boleto-setup.html</a>
 * 
 * @author Cauê Guerra
 * @author Paulo Silveira
 * 
 */
public class PNGBoletoWriter implements BoletoWriter, TextWriter {

	private static final int NORMAL_SIZE = 36;

	private static final int BIG_SIZE = 45;

	private final Font fonteSimples;

	private final Font fonteBold;

	private final BufferedImage PNGimage;

	private InputStream stream;

	private final Graphics2D graphics;

	private final PNGPDFTransformerHelper writerHelper;

	public PNGBoletoWriter() {
		this(2144f, 1900);
	}

	public PNGBoletoWriter(final double w, final double h) {

		PNGimage = new BufferedImage((int) w, (int) h, BufferedImage.TYPE_INT_RGB);
		graphics = PNGimage.createGraphics();

		graphics.setColor(Color.white);
		graphics.fillRect(0, 0, (int) w, (int) h);
		graphics.drawImage(PNGimage, 0, 0, null);

		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		graphics.setColor(Color.BLACK);

		fonteBold = new Font(BaseFont.HELVETICA_BOLD, Font.BOLD, BIG_SIZE);

		fonteSimples = new Font(BaseFont.HELVETICA, Font.PLAIN, NORMAL_SIZE);

		writerHelper = new PNGPDFTransformerHelper(this);
	}

	@Override
	public InputStream toInputStream() {
		if (stream == null) {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			try {
				ImageIO.write(PNGimage, "PNG", baos);
			} catch (IOException e) {
				throw new GeracaoBoletoException(e); // nao esperado
			}
			stream = new ByteArrayInputStream(baos.toByteArray());
		}
		return stream;
	}

	@Override
	public void write(final float x, final float y, final String text) {
		checkIfDocIsClosed();
		graphics.setFont(fonteSimples);
		graphics.drawString(text, scaleX(x), scaleY(y));
	}

	@Override
	public void writeBold(final float x, final float y, final String text) {
		checkIfDocIsClosed();
		graphics.setFont(fonteBold);
		graphics.drawString(text, scaleX(x), scaleY(y));
	}

	@Override
	public void writeImage(final float x, final float y, final BufferedImage image, final float width,
			final float height) throws IOException {

		checkIfDocIsClosed();

		graphics.drawImage(image, (int) x, (int) (PNGimage.getHeight() - (height * 4.16f) - (y * 4.16f)),
				(int) (width * 4.16f), (int) (height * 4.16f), null);
	}

	private void checkIfDocIsClosed() {
		if (stream != null) {
			throw new IllegalStateException("boleto ja gerado, voce nao pode mais escrever na imagem");
		}
	}

	/*
	 * Convertendo coordenadas PDF para PNG
	 */
	private float scaleX(final float x) {
		return x * 4.16f;
	}

	private float scaleY(float y) {
		y = PNGimage.getHeight() - y;
		return y * 4.16f - 6005;
	}

	@Override
	public boolean newPage() {
		throw new IllegalStateException("Nao é possivel criar uma nova pagina em um arquivo png.");
	}

	@Override
	public void write(final Boleto boleto) {
		writerHelper.transform(boleto);
	}
}
