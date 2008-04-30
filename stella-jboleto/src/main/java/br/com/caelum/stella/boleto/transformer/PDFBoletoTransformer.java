package br.com.caelum.stella.boleto.transformer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.util.Vector;

import javax.swing.text.NumberFormatter;

import br.com.caelum.stella.boleto.Boleto;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.BarcodeInter25;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Dada as informações de um boleto, gera um PDF desde.
 * 
 * 
 * @author Paulo Silveira
 * 
 */
public class PDFBoletoTransformer implements BoletoTransformer {

	private static final float IMAGEM_BOLETO_WIDTH = 514.22f;
	private static final float IMAGEM_BOLETO_HEIGHT = 385.109f;

	private static final float IMAGEM_BANCO_WIDTH = 100.0f;
	private static final float IMAGEM_BANCO_HEIGHT = 23.0f;

	private static final float ALTURA = 412;
	private static final float LEFT_MARGIN = 0;

	/**
	 * Gera o PDF em memoria e aloca-o em um InputStream.
	 * 
	 * @throws IOException
	 * @throws MalformedURLException
	 * @throws BadElementException
	 * 
	 */
	public InputStream transform(Boleto boleto) throws IOException {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		NumberFormatter formatter = new NumberFormatter(new DecimalFormat(
				"#,##0.00"));

		Document document = new Document(PageSize.A4);
		System.out.println(document.left());
		
		PdfWriter writer = PdfWriter.getInstance(document, baos);

		document.open();

		PdfContentByte cb = writer.getDirectContent();

		// gera template com o fundo do boleto
		Image imagemTitulo = Image.getInstance(getClass().getResource(
				"/br/com/stlla/boleto/img/template.png"));
		imagemTitulo.scaleToFit(IMAGEM_BOLETO_WIDTH, IMAGEM_BOLETO_HEIGHT);
		imagemTitulo.setAbsolutePosition(0, 0);

		PdfTemplate imagemBoleto = cb.createTemplate(IMAGEM_BOLETO_WIDTH,
				IMAGEM_BOLETO_HEIGHT);
		imagemBoleto.addImage(imagemTitulo);

		PdfTemplate imagemBanco = cb.createTemplate(IMAGEM_BANCO_WIDTH,
				IMAGEM_BANCO_HEIGHT);
		imagemBanco.addImage(getImagemDoBanco(boleto));

		document.newPage();

		cb.addTemplate(imagemBoleto, LEFT_MARGIN, document.top() - 750);
		cb.addTemplate(imagemBanco, LEFT_MARGIN, document.top() - 486);

		BaseFont bfTextoSimples = BaseFont.createFont(BaseFont.HELVETICA,
				BaseFont.WINANSI, BaseFont.EMBEDDED);
		BaseFont bfTextoCB = BaseFont.createFont(BaseFont.HELVETICA_BOLD,
				BaseFont.WINANSI, BaseFont.EMBEDDED);

		// inicio das descricoes do boleto
		cb.beginText();
		cb.setFontAndSize(bfTextoCB, 10);

		Vector descricoes = boleto.getDescricoes();

		for (int i = 0; i < descricoes.size(); i++) {
			cb.setTextMatrix(LEFT_MARGIN, document.top() - 70 + i * 15);
			cb.showText(String.valueOf(descricoes.elementAt(i)));
		}

		cb.endText();

		// fim descricoes

		cb.beginText();
		cb.setFontAndSize(bfTextoCB, 13);

		cb.setTextMatrix(LEFT_MARGIN + 125, ALTURA - 87);

		cb.showText(boleto.getBanco().getNumeroFormatado());
		cb.endText();

		cb.beginText();
		cb.setFontAndSize(bfTextoSimples, 8);

		cb.setTextMatrix(LEFT_MARGIN + 50, ALTURA + 23);
		cb.showText(boleto.getCedente()); // imprime o cedente

		cb.setTextMatrix(LEFT_MARGIN + 5, ALTURA);
		cb.showText(boleto.getNomeSacado());

		cb.setTextMatrix(LEFT_MARGIN + 230, ALTURA);
		cb.showText(boleto.getDataVencimento());

		cb.setTextMatrix(LEFT_MARGIN + 400, ALTURA);
		cb.showText(formatter
				.valueToString(new Double(boleto.getValorBoleto())));

		cb.setTextMatrix(LEFT_MARGIN + 5, ALTURA - 19);
		cb.showText(boleto.getAgencia() + " / " + boleto.getContaCorrente()
				+ "-" + boleto.getDvContaCorrente());

		cb.setTextMatrix(LEFT_MARGIN + 146, ALTURA - 19);
		cb.showText(boleto.getNossoNumero());
		cb.endText();

		cb.beginText();
		cb.setFontAndSize(bfTextoCB, 10);

		cb.setTextMatrix(LEFT_MARGIN + 175, ALTURA - 87);
		cb.showText(boleto.getBanco().getLinhaDigitavelPara(boleto));
		cb.endText();

		cb.beginText();
		cb.setFontAndSize(bfTextoSimples, 8);

		cb.setTextMatrix(LEFT_MARGIN + 5, ALTURA - 111);
		cb.showText(boleto.getLocalPagamento());

		cb.setTextMatrix(LEFT_MARGIN + 5, ALTURA - 121);
		cb.showText(boleto.getLocalPagamento2());

		cb.setTextMatrix(LEFT_MARGIN + 425, ALTURA - 121);
		cb.showText(boleto.getDataVencimento());

		cb.setTextMatrix(LEFT_MARGIN + 5, ALTURA - 141);
		cb.showText(boleto.getCedente());

		cb.setTextMatrix(LEFT_MARGIN + 420, ALTURA - 141);
		cb.showText(boleto.getAgencia() + " / " + boleto.getContaCorrente()
				+ "-" + boleto.getDvContaCorrente());

		cb.setTextMatrix(LEFT_MARGIN + 5, ALTURA - 162);
		cb.showText(boleto.getDataDocumento());

		cb.setTextMatrix(LEFT_MARGIN + 70, ALTURA - 162);
		cb.showText((!boleto.getNoDocumento().isEmpty()) ? boleto
				.getNoDocumento() : boleto.getNossoNumero());

		cb.setTextMatrix(LEFT_MARGIN + 180, ALTURA - 162);
		cb.showText(boleto.getEspecieDocumento());

		cb.setTextMatrix(LEFT_MARGIN + 250, ALTURA - 162);
		cb.showText(boleto.getAceite());

		cb.setTextMatrix(LEFT_MARGIN + 300, ALTURA - 162);
		cb.showText(boleto.getDataProcessamento());

		cb.setTextMatrix(LEFT_MARGIN + 410, ALTURA - 162);
		cb.showText(boleto.getCarteira() + " / " + boleto.getNossoNumero());

		cb.setTextMatrix(LEFT_MARGIN + 122, ALTURA - 185);
		cb.showText(boleto.getCarteira());

		cb.setTextMatrix(LEFT_MARGIN + 430, ALTURA - 185);
		cb.showText(formatter
				.valueToString(new Double(boleto.getValorBoleto())));

		cb.setTextMatrix(LEFT_MARGIN + 5, ALTURA - 207);
		cb.showText(boleto.getInstrucao1());

		cb.setTextMatrix(LEFT_MARGIN + 5, ALTURA - 217);
		cb.showText(boleto.getInstrucao2());

		cb.setTextMatrix(LEFT_MARGIN + 5, ALTURA - 227);
		cb.showText(boleto.getInstrucao3());

		cb.setTextMatrix(LEFT_MARGIN + 5, ALTURA - 237);
		cb.showText(boleto.getInstrucao4());

		cb.setTextMatrix(LEFT_MARGIN + 5, ALTURA - 247);
		cb.showText(boleto.getInstrucao5());

		cb.setTextMatrix(LEFT_MARGIN + 5, ALTURA - 277);
		cb.showText(boleto.getCedente());

		cb.setTextMatrix(LEFT_MARGIN + 100, ALTURA - 302);
		cb.showText(boleto.getNomeSacado() + "     " + boleto.getCpfSacado());

		cb.setTextMatrix(LEFT_MARGIN + 100, ALTURA - 312);
		cb.showText(boleto.getEnderecoSacado());

		cb.setTextMatrix(LEFT_MARGIN + 100, ALTURA - 322);
		cb
				.showText(boleto.getCepSacado() + " "
						+ boleto.getBairroSacado() + " - "
						+ boleto.getCidadeSacado() + " " + boleto.getUfSacado());

		cb.endText();

		
		BarcodeInter25 code = getBarCode(boleto);

		PdfTemplate imgCB = code.createTemplateWithBarcode(cb, null, null);
		cb.addTemplate(imgCB, 40, 10);

		return new ByteArrayInputStream(baos.toByteArray());
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

	/**
	 * Gera template de imagem PDF com a imagem do banco para este boleto
	 * @param boleto
	 * @return
	 * @throws BadElementException
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	static private Image getImagemDoBanco(Boleto boleto) throws BadElementException,
			MalformedURLException, IOException {
		Image imgBanco = Image.getInstance(boleto.getBanco().getImage());
		imgBanco.scaleToFit(IMAGEM_BANCO_WIDTH, IMAGEM_BANCO_HEIGHT);
		imgBanco.setAbsolutePosition(0, 0);
		return imgBanco;
	}

}
