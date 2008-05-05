package br.com.caelum.stella.boleto.transformer;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.text.NumberFormatter;

import br.com.caelum.stella.boleto.Boleto;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.pdf.BarcodeInter25;

public class BoletoTransformer {

	public static final float IMAGEM_BOLETO_WIDTH = 2144;
	public static final float IMAGEM_BOLETO_HEIGHT = 1604;
	public static final double BOLETO_TEMPLATE_SCALE = 1/2d;

	private static final float IMAGEM_BANCO_WIDTH = 100.0f;
	private static final float IMAGEM_BANCO_HEIGHT = 23.0f;

	private static final float ALTURA = 412;
	private static final float LEFT_MARGIN = 0;

	private BoletoWriter writer;

	public BoletoTransformer(BoletoWriter writer) {
		this.writer = writer;
	}

	/**
	 * Gera o PDF em memoria e aloca-o em um InputStream.
	 * 
	 */
	public InputStream transform(Boleto boleto) throws IOException,
			DocumentException, NumberFormatException, ParseException {

		NumberFormatter formatter = new NumberFormatter(new DecimalFormat(
				"#,##0.00"));

		// gera template com o fundo do boleto
		// TODO: talvez fazer isso so uma vez e deixar em memoria, ou ainda
		// receber no construtor
		URL imagemTitulo = BoletoTransformer.class
				.getResource("/br/com/caelum/stella/boleto/img/template.png");

		writer.writeImage(0, 0, scaleTo(imageFor(imagemTitulo),
				BOLETO_TEMPLATE_SCALE));
		writer.writeImage(0, 0, scaleTo(imageFor(boleto.getBanco().getImage()),
				100, 23));

		for (int i = 0; i < boleto.getDescricoes().size(); i++) {
			writer.write(0, 500 - 150 + i * 15, boleto.getDescricoes().get(i));
		}

		// cb.addTemplate(imagemBoleto, LEFT_MARGIN, document.top() - 750);
		// cb.addTemplate(imagemBanco, LEFT_MARGIN, document.top() - 486);

		/*
		 * List<String> descricoes = boleto.getDescricoes();
		 * 
		 * for (int i = 0; i < descricoes.size(); i++) {
		 * cb.setTextMatrix(LEFT_MARGIN, document.top() - 70 + i * 15);
		 * cb.showText(String.valueOf(descricoes.get(i))); }
		 * 
		 * cb.endText(); // fim descricoes
		 * 
		 * cb.beginText(); cb.setFontAndSize(fonteBold, 13);
		 * 
		 * cb.setTextMatrix(LEFT_MARGIN + 125, ALTURA - 87);
		 * 
		 * cb.showText(boleto.getBanco().getNumeroFormatado()); cb.endText();
		 * 
		 * cb.beginText(); cb.setFontAndSize(fonteSimples, 8);
		 * 
		 * cb.setTextMatrix(LEFT_MARGIN + 50, ALTURA + 23);
		 * cb.showText(boleto.getEmissor().getCedente()); // imprime o cedente
		 * 
		 * cb.setTextMatrix(LEFT_MARGIN + 5, ALTURA);
		 * cb.showText(boleto.getSacado().getNome());
		 * 
		 * cb.setTextMatrix(LEFT_MARGIN + 230, ALTURA);
		 * cb.showText(formatDate(boleto.getDatas().getDataDeVencimento()));
		 * 
		 * cb.setTextMatrix(LEFT_MARGIN + 400, ALTURA); cb.showText(formatter
		 * .valueToString(new Double(boleto.getValorBoleto())));
		 * 
		 * cb.setTextMatrix(LEFT_MARGIN + 5, ALTURA - 19);
		 * cb.showText(boleto.getEmissor().getAgencia() + " / " +
		 * boleto.getEmissor().getContaCorrente() + "-" +
		 * boleto.getEmissor().getDvContaCorrente());
		 * 
		 * cb.setTextMatrix(LEFT_MARGIN + 146, ALTURA - 19);
		 * cb.showText(boleto.getEmissor().getNossoNumero()); cb.endText();
		 * 
		 * cb.beginText(); cb.setFontAndSize(fonteBold, 10);
		 * 
		 * cb.setTextMatrix(LEFT_MARGIN + 175, ALTURA - 87);
		 * cb.showText(boleto.getBanco().getLinhaDigitavelPara(boleto));
		 * cb.endText();
		 * 
		 * cb.beginText(); cb.setFontAndSize(fonteSimples, 8); // TODO ver se
		 * cada local de pagamento nao ultrapassa margem. medir // length da
		 * string // inicio dos locais de pagamento do boleto cb.beginText();
		 * cb.setFontAndSize(fonteBold, 10);
		 * 
		 * List<String> locaisDePagamento = boleto.getLocaisDePagamento();
		 * 
		 * for (int i = 0; i < locaisDePagamento.size(); i++) {
		 * cb.setTextMatrix(LEFT_MARGIN + 5, document.top() - 111 - i * 10);
		 * cb.showText(String.valueOf(locaisDePagamento.get(i))); }
		 * 
		 * cb.endText(); // fim locais de pagamento
		 * 
		 * cb.setTextMatrix(LEFT_MARGIN + 425, ALTURA - 121);
		 * cb.showText(formatDate(boleto.getDatas().getDataDeVencimento()));
		 * 
		 * cb.setTextMatrix(LEFT_MARGIN + 5, ALTURA - 141);
		 * cb.showText(boleto.getEmissor().getCedente());
		 * 
		 * cb.setTextMatrix(LEFT_MARGIN + 420, ALTURA - 141);
		 * cb.showText(boleto.getEmissor().getAgencia() + " / " +
		 * boleto.getEmissor().getContaCorrente() + "-" +
		 * boleto.getEmissor().getDvContaCorrente());
		 * 
		 * cb.setTextMatrix(LEFT_MARGIN + 5, ALTURA - 162);
		 * cb.showText(formatDate(boleto.getDatas().getDataDoDocumento()));
		 * 
		 * cb.setTextMatrix(LEFT_MARGIN + 70, ALTURA - 162);
		 * cb.showText((!boleto.getNoDocumento().isEmpty()) ? boleto
		 * .getNoDocumento() : boleto.getEmissor().getNossoNumero());
		 * 
		 * cb.setTextMatrix(LEFT_MARGIN + 180, ALTURA - 162);
		 * cb.showText(boleto.getEspecieDocumento());
		 * 
		 * cb.setTextMatrix(LEFT_MARGIN + 250, ALTURA - 162);
		 * cb.showText(boleto.getAceite());
		 * 
		 * cb.setTextMatrix(LEFT_MARGIN + 300, ALTURA - 162);
		 * cb.showText(formatDate(boleto.getDatas().getDataDoProcessamento()));
		 * 
		 * cb.setTextMatrix(LEFT_MARGIN + 410, ALTURA - 162);
		 * cb.showText(boleto.getEmissor().getCarteira() + " / " +
		 * boleto.getEmissor().getNossoNumero());
		 * 
		 * cb.setTextMatrix(LEFT_MARGIN + 122, ALTURA - 185);
		 * cb.showText(boleto.getEmissor().getCarteira());
		 * 
		 * cb.setTextMatrix(LEFT_MARGIN + 430, ALTURA - 185);
		 * cb.showText(formatter .valueToString(new
		 * Double(boleto.getValorBoleto()))); // TODO ver se cada instrucao nao
		 * ultrapassa margem. medir length da // string // inicio das instrucoes
		 * do boleto cb.beginText(); cb.setFontAndSize(fonteBold, 10);
		 * 
		 * List<String> instrucoes = boleto.getInstrucoes();
		 * 
		 * for (int i = 0; i < instrucoes.size(); i++) {
		 * cb.setTextMatrix(LEFT_MARGIN + 5, document.top() - 207 - i * 10);
		 * cb.showText(String.valueOf(instrucoes.get(i))); }
		 * 
		 * cb.endText(); // fim instrucoes
		 * 
		 * cb.setTextMatrix(LEFT_MARGIN + 5, ALTURA - 277);
		 * cb.showText(boleto.getEmissor().getCedente());
		 * 
		 * cb.setTextMatrix(LEFT_MARGIN + 100, ALTURA - 302);
		 * cb.showText(boleto.getSacado().getNome() + " " +
		 * boleto.getSacado().getCpf());
		 * 
		 * cb.setTextMatrix(LEFT_MARGIN + 100, ALTURA - 312);
		 * cb.showText(boleto.getSacado().getEndereco()); // TODO: talvez isso
		 * aqui estoure a margem, nao? precisa medir o length // da string.
		 * cb.setTextMatrix(LEFT_MARGIN + 100, ALTURA - 322);
		 * cb.showText(boleto.getSacado().getCep() + " " +
		 * boleto.getSacado().getBairro() + " - " +
		 * boleto.getSacado().getCidade() + " " + boleto.getSacado().getUf());
		 * 
		 * cb.endText();
		 * 
		 * BarcodeInter25 code = getBarCode(boleto);
		 * 
		 * PdfTemplate imgCB = code.createTemplateWithBarcode(cb, null, null);
		 * cb.addTemplate(imgCB, 40, 10);
		 * 
		 */
		return writer.toInputStream();
	}

	private BufferedImage scaleTo(BufferedImage image, double scale) {
		if (scale == 1)
			return image;
		return scaleTo(image, (int) (image.getWidth() * scale), (int) (image
				.getHeight() * scale));
	}

	private BufferedImage imageFor(URL file) throws IOException {
		return ImageIO.read(file);
	}

	private String formatDate(Calendar date) {
		return String.format("%1$te/%1$tm/%1$tY", date);
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

	/**
	 * Gera o codigo de barra via IText
	 * 
	 * @param boleto
	 * @return
	 */
	static private BarcodeInter25 getBarCode(Boleto boleto) {
		BarcodeInter25 code = new BarcodeInter25();
		code.setCode(boleto.getBanco().getCodigoBarras(boleto));
		code.setExtended(true);

		code.setTextAlignment(Element.ALIGN_LEFT);
		code.setBarHeight(37.00f);
		code.setFont(null);
		code.setX(0.73f);
		code.setN(3);

		return code;
	}

	static private java.awt.Image generateBarcodeFor(String code) {
		BarcodeInter25 bar = new BarcodeInter25();
		bar.setCode(code);
		bar.setExtended(true);

		bar.setTextAlignment(Element.ALIGN_LEFT);
		bar.setBarHeight(37.00f);
		bar.setFont(null);
		bar.setX(0.73f);
		bar.setN(3);
		return bar.createAwtImage(null, null);
	}

}
