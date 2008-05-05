package br.com.caelum.stella.boleto.transformer;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
import javax.swing.text.NumberFormatter;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Writer que sabe escrever num PDF usando IText como dependencia.
 * 
 * @author Paulo Silveira
 * 
 */
public class PDFBoletoWriter implements BoletoWriter {

	private static final int NORMAL_SIZE = 8;
	private static final int BIG_SIZE = 10;

	private InputStream stream;
	private ByteArrayOutputStream bytes;
	private Document document;
	private PdfWriter writer;
	private BaseFont fonteSimples;
	private BaseFont fonteBold;
	private PdfContentByte contentByte;
	private final int scale = 1;
	private final float width;
	private final float height;

	public PDFBoletoWriter(double width, double height) {
		this.width = (float) width;
		this.height = (float) height;

		this.bytes = new ByteArrayOutputStream();
		this.document = new Document();

		NumberFormatter formatter = new NumberFormatter(new DecimalFormat(
				"#,##0.00"));

		try {
			this.writer = PdfWriter.getInstance(document, this.bytes);

			this.fonteSimples = BaseFont.createFont(BaseFont.HELVETICA,
					BaseFont.WINANSI, BaseFont.EMBEDDED);
			this.fonteBold = BaseFont.createFont(BaseFont.HELVETICA_BOLD,
					BaseFont.WINANSI, BaseFont.EMBEDDED);

		} catch (DocumentException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		this.document.open();
		this.contentByte = writer.getDirectContent();
		this.document.newPage();
	}

	public PDFBoletoWriter() {
		this(PageSize.A4.getWidth(), PageSize.A4.getHeight());
	}

	public InputStream toInputStream() {
		if (stream == null) {
			this.document.close();
			this.stream = new ByteArrayInputStream(this.bytes.toByteArray());
		}
		return stream;
	}

	public void write(float x, float y, String text) {
		write(x, y, text, fonteSimples, NORMAL_SIZE * scale);
	}

	public void writeBold(float x, float y, String text) {
		write(x, y, text, fonteBold, BIG_SIZE * scale);
	}

	private void write(float x, float y, String text, BaseFont font, int size) {
		checkIfDocIsClosed();
		contentByte.beginText();

		contentByte.setFontAndSize(font, size);
		contentByte.setTextMatrix(x, y);
		contentByte.showText(text);

		contentByte.endText();
	}

	private void checkIfDocIsClosed() {
		if (stream != null) {
			throw new IllegalStateException(
					"boleto ja gerado, voce nao pode mais escrever na imagem");
		}
	}

	public void writeImage(float x, float y, BufferedImage image, float width,
			float height) throws IOException {
		checkIfDocIsClosed();

		try {
			Image pdfImage = Image.getInstance(image, null);
			pdfImage.setAbsolutePosition(0, 0);
			pdfImage.scaleToFit(width, height);
			PdfTemplate template = contentByte.createTemplate(image.getWidth(),
					image.getHeight());
			template.addImage(pdfImage);
			contentByte.addTemplate(template, x, y);
		} catch (BadElementException e) {
			throw new RuntimeException(e);
		} catch (DocumentException e) {
			throw new RuntimeException(e);
		}
	}

}
