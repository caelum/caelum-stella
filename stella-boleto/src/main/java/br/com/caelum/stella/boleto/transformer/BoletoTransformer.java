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

		writer.writeImage(0, 0, imageFor(imagemTitulo),
				514.22f, 385.109f);
		writer.writeImage(0, 750 - 486, imageFor(boleto.getBanco().getImage()),
				100, 23);

		for (int i = 0; i < boleto.getDescricoes().size(); i++) {
			writer.writeBold(5, 750 - 70 + i * 15, boleto.getDescricoes().get(i));
		}
		
		writer.writeBold(125, 750 - 486, boleto.getBanco().getNumeroFormatado());
		
		writer.write(50, 400 - 21, boleto.getEmissor().getCedente());
		
		writer.write(5, 400 - 43, boleto.getSacado().getNome());
		
		writer.write(230, 400 - 43, formatDate(boleto.getDatas().getDataDeVencimento()));

		writer.write(400, 400 - 43, formatter.valueToString(new Double(boleto.getValorBoleto())));
		
		writer.write(5, 400 - 43 - 21, boleto.getEmissor().getAgencia() + " / " +
									   boleto.getEmissor().getContaCorrente() + "-" +
									   boleto.getEmissor().getDvContaCorrente());
		
		//writer.write(146, 400 - 43 - 21, boleto.getEmissor().getNossoNumero());
		
		//writer.writeBold(175, 400 - 43 - 87, boleto.getBanco().geraLinhaDigitavelPara(boleto));
		
		for (int i = 0; i < boleto.getLocaisDePagamento().size(); i++) {
			writer.write(5, 400 - 250 - i * 10, boleto.getLocaisDePagamento().get(i));
		}
		
		writer.write(425, 400 - 43 - 121, formatDate(boleto.getDatas().getDataDeVencimento()));
		
		writer.write(5, 400 - 43 - 141, boleto.getEmissor().getCedente());
		
		writer.write(420, 400 - 43 - 141, boleto.getEmissor().getAgencia() + " / " +
										  boleto.getEmissor().getContaCorrente() + "-" +
										  boleto.getEmissor().getDvContaCorrente());
		
		/*
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
