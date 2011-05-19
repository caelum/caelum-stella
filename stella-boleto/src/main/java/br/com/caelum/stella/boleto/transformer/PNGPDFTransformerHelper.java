package br.com.caelum.stella.boleto.transformer;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;

import javax.imageio.ImageIO;

import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.CriacaoBoletoException;
import br.com.caelum.stella.boleto.GeracaoBoletoException;
import br.com.caelum.stella.boleto.bancos.LinhaDigitavelGenerator;

/**
 * Classe que centraliza a cria��o dos boletos que tem como template o
 * template.png e antes ficava no BoletoTransformer
 * 
 * 
 */

class PNGPDFTransformerHelper {
	/*Ainda precisa de um nome melhor!!*/

	public static final float IMAGEM_BOLETO_WIDTH = 2144;
	public static final float IMAGEM_BOLETO_HEIGHT = 1604;
	public static final double BOLETO_TEMPLATE_SCALE = 1 / 2d;

	private static final float LINHA1 = 434;
	private static final float LINHA2 = 412;
	private static final float LINHA3 = 391;
	private static final float LINHA4 = 319;
	private static final float LINHA5 = 291;
	private static final float LINHA6 = 271;
	private static final float LINHA7 = 250;
	private static final float LINHA8 = 227;
	private static final float LINHA9 = 205;
	private static final float LINHA10 = 132;
	private static final float LINHA11 = 97;
	private static final float LINHA12 = 87;
	private static final float LINHA13 = 77;
	private TextWriter writer;
	private URL imagemTitulo;


	public PNGPDFTransformerHelper(TextWriter writer) {
		super();
		this.writer = writer;
		this.imagemTitulo = PNGPDFTransformerHelper.class
				.getResource("/br/com/caelum/stella/boleto/img/template.png");		
	}

	/**
	 * 
	 * @param boleto
	 * @return
	 */
	public TextWriter transform(Boleto boleto) {
		// gera template com o fundo do boleto
		try {
			this.writer.writeImage(0, 55, imageFor(imagemTitulo), 514.22f,
					385.109f);
			this.writer.writeImage(0, 805 - 486, imageFor(boleto.getBanco()
					.getImage()), 100, 23);
		} catch (IOException e) {
			throw new GeracaoBoletoException(
					"Erro na leitura das imagens do boleto", e);
		}

		for (int i = 0; i < boleto.getDescricoes().size(); i++) {
			this.writer.writeBold(5, 805 - 70 - i * 15, boleto.getDescricoes()
					.get(i));
		}

		this.writer.write(50, LINHA1, boleto.getEmissor().getCedente());

		this.writer.write(5, LINHA2, boleto.getSacado().getNome());

		this.writer.write(230, LINHA2, formatDate(boleto.getDatas()
				.getVencimento()));

		this.writer.write(400, LINHA2, BoletoFormatter.formatValue(boleto
				.getValorBoleto().doubleValue()));

		this.writer.write(5, LINHA3, boleto.getEmissor().getAgenciaFormatado()
				+ "-"
				+ boleto.getEmissor().getDvAgencia()
				+ " / "
				+ boleto.getBanco().getContaCorrenteDoEmissorFormatado(
						boleto.getEmissor()) + "-"
				+ boleto.getEmissor().getDvContaCorrente());

		this.writer.write(146, LINHA3, boleto.getBanco()
				.getNossoNumeroDoEmissorFormatado(boleto.getEmissor()));

		this.writer.writeBold(125, LINHA4, boleto.getBanco()
				.getNumeroFormatado());

		LinhaDigitavelGenerator linhaDigitavelGenerator = new LinhaDigitavelGenerator();
		this.writer.writeBold(175, LINHA4, linhaDigitavelGenerator
				.geraLinhaDigitavelPara(boleto));

		for (int i = 0; i < boleto.getLocaisDePagamento().size(); i++) {
			this.writer.write(5, LINHA5 - (i - 1) * 10, boleto
					.getLocaisDePagamento().get(i));
		}

		this.writer.write(425, LINHA5, formatDate(boleto.getDatas()
				.getVencimento()));

		this.writer.write(5, LINHA6, boleto.getEmissor().getCedente());

		this.writer.write(420, LINHA6, boleto.getEmissor()
				.getAgenciaFormatado()
				+ " - "
				+ boleto.getEmissor().getDvAgencia()
				+ " / "
				+ boleto.getBanco().getContaCorrenteDoEmissorFormatado(
						boleto.getEmissor())
				+ "-"
				+ boleto.getEmissor().getDvContaCorrente());

		this.writer.write(5, LINHA7, formatDate(boleto.getDatas()
				.getDocumento()));

		this.writer.write(70, LINHA7,
				!boleto.getNumeroDoDocumento().equals("") ? boleto
						.getNumeroDoDocumentoFormatado() : boleto.getBanco()
						.getNossoNumeroDoEmissorFormatado(boleto.getEmissor()));

		this.writer.write(180, LINHA7, boleto.getEspecieDocumento());

		this.writer.write(250, LINHA7, boleto.getAceite() ? "S" : "N");

		this.writer.write(300, LINHA7, formatDate(boleto.getDatas()
				.getProcessamento()));

		this.writer.write(410, LINHA7, boleto.getEmissor().getCarteira()
				+ " / "
				+ boleto.getBanco().getNossoNumeroDoEmissorFormatado(
						boleto.getEmissor()));

		this.writer.write(122, LINHA8, boleto.getBanco()
				.getCarteiraDoEmissorFormatado(boleto.getEmissor()));

		this.writer.write(190, LINHA8, boleto.getEspecieMoeda());

		this.writer.write(430, LINHA8, BoletoFormatter.formatValue(boleto
				.getValorBoleto().doubleValue()));

		for (int i = 0; i < boleto.getInstrucoes().size(); i++) {
			this.writer
					.write(5, LINHA9 - i * 10, boleto.getInstrucoes().get(i));
		}

		this.writer.write(5, LINHA10, boleto.getEmissor().getCedente());

		this.writer.write(100, LINHA11, (boleto.getSacado().getNome() != null ? boleto.getSacado().getNome() : "") + " "
				+ (boleto.getSacado().getCpf() != null ? boleto.getSacado().getCpf() : ""));

		this.writer.write(100, LINHA12, (boleto.getSacado().getEndereco() != null ? boleto.getSacado().getEndereco() : ""));

		this.writer.write(100, LINHA13, (boleto.getSacado().getCep() != null ? boleto.getSacado().getCep() : "") + " "
				+ (boleto.getSacado().getBairro() != null ? boleto.getSacado().getBairro() : "") + " - "
				+ (boleto.getSacado().getCidade() != null ? boleto.getSacado().getCidade() : "") + " "
				+ (boleto.getSacado().getUf() != null ? boleto.getSacado().getUf() : ""));

		Image imagemDoCodigoDeBarras = BarcodeGenerator
				.generateBarcodeFor(boleto.getBanco().geraCodigoDeBarrasPara(
						boleto),37.00f);		

		try {
			this.writer.writeImage(40, 10, toBufferedImage(
					imagemDoCodigoDeBarras, BufferedImage.TYPE_INT_ARGB),
					imagemDoCodigoDeBarras.getWidth(null),
					imagemDoCodigoDeBarras.getHeight(null));
		} catch (IOException e) {
			throw new CriacaoBoletoException(
					"Erro na geração do código de barras", e);
		}
		return writer;

	}

	/**
	 * Converte um Image em um BufferedImage
	 * 
	 * @param image
	 * @param type
	 */
	private BufferedImage toBufferedImage(Image image, int type) {
		return BufferedImageGenerator.generateBufferedImageFor(image,type);
	}

	/**
	 * Abre um arquivo em um BufferedImage
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	private BufferedImage imageFor(URL file) throws IOException {
		return ImageIO.read(file);
	}

	/**
	 * Formata uma data para dd/mm/yyyy
	 * 
	 * @param date
	 * @return
	 */
	private String formatDate(Calendar date) {
		return BoletoFormatter.formatDate(date);
	}

}
