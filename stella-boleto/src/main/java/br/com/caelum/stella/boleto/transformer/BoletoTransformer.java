package br.com.caelum.stella.boleto.transformer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
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
	public static final double BOLETO_TEMPLATE_SCALE = 1 / 2d;

	private static final float IMAGEM_BANCO_WIDTH = 100.0f;
	private static final float IMAGEM_BANCO_HEIGHT = 23.0f;

	private static final float LINHA1 = 434;
	private static final float LINHA2 = 412;
	private static final float LINHA3 = 391;
	private static final float LINHA4 = 325;
	private static final float LINHA5 = 291;
	private static final float LINHA6 = 271;
	private static final float LINHA7 = 250;
	private static final float LINHA8 = 227;
	private static final float LINHA9 = 205;
	private static final float LINHA10 = 132;
	private static final float LINHA11 = 97;
	private static final float LINHA12 = 87;
	private static final float LINHA13 = 77;
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

		writer.writeImage(0, 55, imageFor(imagemTitulo), 514.22f, 385.109f);
		writer.writeImage(0, 805 - 486, imageFor(boleto.getBanco().getImage()),
				100, 23);

		for (int i = 0; i < boleto.getDescricoes().size(); i++) {
			writer.writeBold(5, 805 - 70 - i * 15, boleto.getDescricoes()
					.get(i));
		}

		writer
				.writeBold(125, 805 - 486, boleto.getBanco()
						.getNumeroFormatado());

		writer.write(50, LINHA1, boleto.getEmissor().getCedente());

		writer.write(5, LINHA2, boleto.getSacado().getNome());

		writer
				.write(230, LINHA2, formatDate(boleto.getDatas()
						.getVencimento()));

		writer.write(400, LINHA2, formatter.valueToString(new Double(boleto
				.getValorBoleto())));

		writer.write(5, LINHA3, boleto.getEmissor().getAgencia() + " / "
				+ boleto.getEmissor().getContaCorrente() + "-"
				+ boleto.getEmissor().getDvContaCorrente());

		// writer.write(146, LINHA3, boleto.getEmissor().getNossoNumero());

		// writer.writeBold(175, LINHA4,
		// boleto.getBanco().geraLinhaDigitavelPara(boleto));

		for (int i = 0; i < boleto.getLocaisDePagamento().size(); i++) {
			writer.write(5, LINHA5 - (i - 1) * 10, boleto
					.getLocaisDePagamento().get(i));
		}

		writer
				.write(425, LINHA5, formatDate(boleto.getDatas()
						.getVencimento()));

		writer.write(5, LINHA6, boleto.getEmissor().getCedente());

		writer.write(420, LINHA6, boleto.getEmissor().getAgencia() + " / "
				+ boleto.getEmissor().getContaCorrente() + "-"
				+ boleto.getEmissor().getDvContaCorrente());

		writer.write(5, LINHA7, formatDate(boleto.getDatas().getDocumento()));

		writer.write(70, LINHA7, !boleto.getNoDocumento().equals("") ? boleto
				.getNoDocumento() : boleto.getEmissor().getNossoNumero());

		// writer.write(180, LINHA7, boleto.getEspecieDocumento());

		// writer.write(250, LINHA7, boleto.getAceite());

		writer.write(300, LINHA7, formatDate(boleto.getDatas()
				.getProcessamento()));

		writer.write(410, LINHA7, boleto.getEmissor().getCarteira() + " / "
				+ boleto.getEmissor().getNossoNumero());

		writer.write(122, LINHA8, boleto.getEmissor().getCarteira());

		writer.write(190, LINHA8, boleto.getEspecieMoeda());

		// TODO: quantidade moeda, valor moeda

		writer.write(430, LINHA8, formatter.valueToString(new Double(boleto
				.getValorBoleto())));

		for (int i = 0; i < boleto.getInstrucoes().size(); i++) {
			writer.write(5, LINHA9 - i * 10, boleto.getInstrucoes().get(i));
		}

		// TODO: colocar desconto, outras deducoes, mora, outros acrescimos,
		// valor cobrado

		writer.write(5, LINHA10, boleto.getEmissor().getCedente());

		writer.write(100, LINHA11, boleto.getSacado().getNome() + " "
				+ boleto.getSacado().getCpf());

		writer.write(100, LINHA12, boleto.getSacado().getEndereco());

		writer.write(100, LINHA13, boleto.getSacado().getCep() + " "
				+ boleto.getSacado().getBairro() + " - "
				+ boleto.getSacado().getCidade() + " "
				+ boleto.getSacado().getUf());

		Image imagemDoCodigoDeBarras = generateBarcodeFor(boleto.getBanco()
				.geraCodigoDeBarrasPara(boleto));

		writer.writeImage(40, 10, toBufferedImage(imagemDoCodigoDeBarras, 1), imagemDoCodigoDeBarras.getWidth(null),
				imagemDoCodigoDeBarras.getHeight(null));

		return writer.toInputStream();
	}

	private BufferedImage toBufferedImage(Image image, int type) {
		int w = image.getWidth(null);
		int h = image.getHeight(null);
		BufferedImage result = new BufferedImage(w, h, type);
		Graphics2D g = result.createGraphics();
		g.drawImage(image, 0, 0, null);
		g.dispose();
		return result;
	}

	private BufferedImage imageFor(URL file) throws IOException {
		return ImageIO.read(file);
	}

	private String formatDate(Calendar date) {
		return String.format("%1$td/%1$tm/%1$tY", date);
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
		return bar.createAwtImage(Color.BLACK, Color.WHITE);
	}

}
