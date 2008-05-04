package br.com.caelum.stella.boleto.transformer;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
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
	public static final double BOLETO_TEMPLATE_SCALE = 1 / 4d;

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
		// TODO: usar altura tambem
		System.out.println((double)image.getWidth());
		if ((double)width / image.getWidth() < 0.5) {
			System.out.println("!!!");
	        Kernel kernel = createBlurKernel((double)image.getWidth() / width);
	        ConvolveOp op = new ConvolveOp(
	                kernel, ConvolveOp.EDGE_NO_OP, null);
	        image = op.filter(image, null);
	    }

		AffineTransformOp transform = new AffineTransformOp(AffineTransform.getScaleInstance(
				(double) width / image.getWidth(), (double) height
						/ image.getHeight()), AffineTransformOp.TYPE_BICUBIC);
		return transform.filter(image, null);
	}

	private static Kernel createBlurKernel(double scale) {
	    int size = 1 + (int) (0.25 / scale);
	    float[] data = new float[size * size];
	    float factor = 1 / (float) data.length;
	    for (int i = 0; i < data.length; i++) {
	        data[i] = factor;
	    }
	    return new Kernel(size, size, data);
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
