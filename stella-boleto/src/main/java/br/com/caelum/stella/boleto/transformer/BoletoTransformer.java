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

		writer.writeImage(0, 55, imageFor(imagemTitulo),
				514.22f, 385.109f);
		writer.writeImage(0, 805 - 486, imageFor(boleto.getBanco().getImage()),
				100, 23);

		for (int i = 0; i < boleto.getDescricoes().size(); i++) {
			writer.writeBold(5, 805 - 70 + i * 15, boleto.getDescricoes().get(i));
		}
		
		writer.writeBold(125, 805 - 486, boleto.getBanco().getNumeroFormatado());
		
		writer.write(50, 455 - 21, boleto.getEmissor().getCedente());
		
		writer.write(5, 455 - 43, boleto.getSacado().getNome());
		
		writer.write(230, 455 - 43, formatDate(boleto.getDatas().getDataDeVencimento()));

		writer.write(400, 455 - 43, formatter.valueToString(new Double(boleto.getValorBoleto())));
		
		writer.write(5, 455 - 43 - 21, boleto.getEmissor().getAgencia() + " / " +
									   boleto.getEmissor().getContaCorrente() + "-" +
									   boleto.getEmissor().getDvContaCorrente());
		
		//writer.write(146, 455 - 43 - 21, boleto.getEmissor().getNossoNumero());
		
		//writer.writeBold(175, 455 - 43 - 87, boleto.getBanco().geraLinhaDigitavelPara(boleto));
		
		for (int i = 0; i < boleto.getLocaisDePagamento().size(); i++) {
			writer.write(5, 455 - 154 - i * 10, boleto.getLocaisDePagamento().get(i));
		}
		
		writer.write(425, 455 - 43 - 121, formatDate(boleto.getDatas().getDataDeVencimento()));
		
		writer.write(5, 455 - 43 - 141, boleto.getEmissor().getCedente());
		
		writer.write(420, 455 - 43 - 141, boleto.getEmissor().getAgencia() + " / " +
										  boleto.getEmissor().getContaCorrente() + "-" +
										  boleto.getEmissor().getDvContaCorrente());
		
		writer.write(5, 455 - 43 - 162, formatDate(boleto.getDatas().getDataDoDocumento()));
		
		writer.write(70, 455 - 43 - 162, !boleto.getNoDocumento().isEmpty() ? boleto
		 .getNoDocumento() : boleto.getEmissor().getNossoNumero());
		
		//writer.write(180, 455 - 43 - 162, boleto.getEspecieDocumento());
		
		//writer.write(250, 455 - 43 - 162, boleto.getAceite());
		
		writer.write(300, 455 - 43 - 162, formatDate(boleto.getDatas().getDataDoProcessamento()));
		
		writer.write(410, 455 - 43 - 162, boleto.getEmissor().getCarteira() + " / " +
										  boleto.getEmissor().getNossoNumero());
		
		writer.write(122, 455 - 43 - 185, boleto.getEmissor().getCarteira());
		
		writer.write(430, 455 - 43 - 185, formatter.valueToString(new Double(boleto.getValorBoleto())));
		
		for (int i = 0; i < boleto.getInstrucoes().size(); i++) {
			writer.write(5, 455 - 250 - i * 10, boleto.getInstrucoes().get(i));
		}
		
		writer.write(5, 455 - 43 - 280, boleto.getEmissor().getCedente());
		
		writer.write(100, 455 - 43 - 315, boleto.getSacado().getNome() + " " +
										  boleto.getSacado().getCpf());
		
		writer.write(100, 455 - 43 - 325, boleto.getSacado().getEndereco());
		
		writer.write(100, 455 - 43 - 335, boleto.getSacado().getCep() + " " +
										  boleto.getSacado().getBairro() + " - " + 
										  boleto.getSacado().getCidade() + " " +
										  boleto.getSacado().getUf());

		/*
		 * 
		 * BarcodeInter25 code = getBarCode(boleto);
		 * 
		 * PdfTemplate imgCB = code.createTemplateWithBarcode(cb, null, null);
		 * cb.addTemplate(imgCB, 40, 10);
		 * 
		 */
		return writer.toInputStream();
	}



	private BufferedImage imageFor(URL file) throws IOException {
		return ImageIO.read(file);
	}

	private String formatDate(Calendar date) {
		return String.format("%1$td/%1$tm/%1$tY", date);
	}

	/**
	 * Gera o codigo de barra via IText
	 * 
	 * @param boleto
	 * @return
	 */
	static private BarcodeInter25 getBarCode(Boleto boleto) {
		BarcodeInter25 code = new BarcodeInter25();
		code.setCode(boleto.getBanco().geraCodigoDeBarrasPara(boleto));
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
