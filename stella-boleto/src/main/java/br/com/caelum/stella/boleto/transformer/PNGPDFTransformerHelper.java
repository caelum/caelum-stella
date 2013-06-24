package br.com.caelum.stella.boleto.transformer;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;

import javax.imageio.ImageIO;

import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.bancos.GeradorDeLinhaDigitavel;
import br.com.caelum.stella.boleto.exception.CriacaoBoletoException;
import br.com.caelum.stella.boleto.exception.GeracaoBoletoException;

/**
 * Classe que centraliza a criação dos boletos que tem como template o
 * template.png e antes ficava no BoletoTransformer
 * 
 * 
 */

class PNGPDFTransformerHelper {
	/* Ainda precisa de um nome melhor!! */
	public static final float IMAGEM_BOLETO_WIDTH = 2144;
	public static final float IMAGEM_BOLETO_HEIGHT = 1604;
	public static final double BOLETO_TEMPLATE_SCALE = 1 / 2d;

	private TextWriter writer;
	private URL imagemTitulo;

	public PNGPDFTransformerHelper(TextWriter writer) {
		super();
		this.writer = writer;
		this.imagemTitulo = PNGPDFTransformerHelper.class.getResource("/br/com/caelum/stella/boleto/img/template.png");
	}

	/**
	 * 
	 * @param boleto
	 * @return
	 */
	public TextWriter transform(Boleto boleto) {
		geraTemplateComOFundoDoBoleto(boleto);

		imprimeReciboDeSacado(boleto);

		imprimeLinhaDigitavelEmNegrito(boleto);

		imprimeLocaisDePagamentoEVencimento(boleto);
		imprimeDadosDoCedente(boleto);
		imprimeDadosDoDocumento(boleto);
		imprimeDadosDoBoletoInclusiveValor(boleto);
		imprimeInstrucoesDePagamento(boleto);
		imprimeUnidadeCedente(boleto);
		imprimeDadosDoSacado(boleto);

		geraEImprimeCodigoDeBarras(boleto);
		return writer;
	}

	/**
	 * Converte um Image em um BufferedImage
	 * 
	 * @param image
	 * @param type
	 */
	private BufferedImage toBufferedImage(Image image, int type) {
		return BufferedImageGenerator.generateBufferedImageFor(image, type);
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
		return FormatadorDeBoleto.formataData(date);
	}

	private void geraTemplateComOFundoDoBoleto(Boleto boleto) {
		try {
			this.writer.writeImage(0, 55, imageFor(imagemTitulo), 514.22f, 385.109f);
			this.writer.writeImage(0, 805 - 486, imageFor(boleto.getBanco().getImage()), 100, 23);
		} catch (IOException e) {
			throw new GeracaoBoletoException("Erro na leitura das imagens do boleto", e);
		}
		
		for (int i = 0; i < boleto.getDescricoes().size(); i++) {
			this.writer.writeBold(5, 805 - 70 - i * 15, boleto.getDescricoes().get(i));
		}
	}
	
	private void imprimeReciboDeSacado(Boleto boleto) {
		final float LINHA1 = 434;
		final float LINHA_ENDERECO_CEDENTE = 423;
		final float LINHA2 = 400;
		final float LINHA3 = 378;
		
		this.writer.write(50, LINHA1, boleto.getEmissor().getCedente());
		this.writer.write(50, LINHA_ENDERECO_CEDENTE, nullToEmpty(boleto.getEmissor().getEndereco()));
		
		this.writer.write(5, LINHA2, boleto.getSacado().getNome());
		this.writer.write(290, LINHA2, formatDate(boleto.getDatas().getVencimento()));
		this.writer.write(377, LINHA2, FormatadorDeBoleto.formataValor(boleto.getValorBoleto().doubleValue()));
		
		this.writer.write(5, LINHA3, boleto.getAgenciaECodigoCedente());
		this.writer.write(146, LINHA3, boleto.getNossoNumeroECodDocumento());
	}
	
	private void imprimeLinhaDigitavelEmNegrito(Boleto boleto) {
		final float LINHA4 = 319;
		this.writer.writeBold(125, LINHA4, boleto.getBanco().getNumeroFormatadoComDigito());
		GeradorDeLinhaDigitavel linhaDigitavelGenerator = new GeradorDeLinhaDigitavel();
		String codigoDeBarras = boleto.getBanco().geraCodigoDeBarrasPara(boleto);
		this.writer.writeBold(175, LINHA4, linhaDigitavelGenerator.geraLinhaDigitavelPara(codigoDeBarras));
	}
	
	private void imprimeLocaisDePagamentoEVencimento(Boleto boleto) {
		final float LINHA5 = 291;
		for (int i = 0; i < boleto.getLocaisDePagamento().size(); i++) {
			this.writer.write(5, LINHA5 - (i - 1) * 10, boleto.getLocaisDePagamento().get(i));
		}
		this.writer.write(425, LINHA5, formatDate(boleto.getDatas().getVencimento()));
	}
	
	private void imprimeDadosDoCedente(Boleto boleto) {
		final float LINHA6 = 271;
		this.writer.write(5, LINHA6, boleto.getEmissor().getCedente());
		this.writer.write(420, LINHA6, boleto.getAgenciaECodigoCedente());
	}
	
	private void imprimeDadosDoDocumento(Boleto boleto) {
		final float LINHA7 = 250;
		this.writer.write(5, LINHA7, formatDate(boleto.getDatas().getDocumento()));
		this.writer.write(70, LINHA7, boleto.getNumeroDoDocumento().equals("") ? 
				boleto.getBanco().getNossoNumeroDoEmissorFormatado(boleto.getEmissor()) :
					boleto.getNumeroDoDocumentoFormatado());
		this.writer.write(180, LINHA7, boleto.getEspecieDocumento());
		this.writer.write(250, LINHA7, boleto.getAceite() ? "S" : "N");
		this.writer.write(300, LINHA7, formatDate(boleto.getDatas().getProcessamento()));
		this.writer.write(410, LINHA7, boleto.getNossoNumeroECodDocumento());
	}
	
	private void imprimeDadosDoBoletoInclusiveValor(Boleto boleto) {
		final float LINHA8 = 227;
		this.writer.write(122, LINHA8, boleto.getBanco().getCarteiraDoEmissorFormatado(boleto.getEmissor()));
		this.writer.write(190, LINHA8, boleto.getEspecieMoeda());
		this.writer.write(430, LINHA8, FormatadorDeBoleto.formataValor(boleto.getValorBoleto().doubleValue()));
	}
	
	private void imprimeInstrucoesDePagamento(Boleto boleto) {
		final float LINHA9 = 205;

		for (int i = 0; i < boleto.getInstrucoes().size(); i++) {
			this.writer.write(5, LINHA9 - i * 10, boleto.getInstrucoes().get(i));
		}
	}
	
	private void imprimeUnidadeCedente(Boleto boleto) {
		final float LINHA10 = 132;
		final float LINHA_ENDERECO = 122;

		this.writer.write(5, LINHA10, boleto.getEmissor().getCedente());
		this.writer.write(5, LINHA_ENDERECO, nullToEmpty(boleto.getEmissor().getEndereco()));
	}

	private void imprimeDadosDoSacado(Boleto boleto) {
		final float LINHA11 = 97;
		final float LINHA12 = 87;
		final float LINHA13 = 77;

		this.writer.write(50, LINHA11, (boleto.getSacado().getNome() != null ? boleto.getSacado().getNome() : "")
				+ " " + (boleto.getSacado().getCpf() != null ? boleto.getSacado().getCpf() : ""));
		
		this.writer.write(50, LINHA12, (boleto.getSacado().getEndereco() != null ? boleto.getSacado().getEndereco()
				: ""));
		
		this.writer.write(50, LINHA13, (boleto.getSacado().getCep() != null ? boleto.getSacado().getCep() : "") + " "
				+ (boleto.getSacado().getBairro() != null ? boleto.getSacado().getBairro() : "") + " - "
				+ (boleto.getSacado().getCidade() != null ? boleto.getSacado().getCidade() : "") + " "
				+ (boleto.getSacado().getUf() != null ? boleto.getSacado().getUf() : ""));
	}

	private void geraEImprimeCodigoDeBarras(Boleto boleto) {
		Image imagemDoCodigoDeBarras = GeradorDeImagemDoCodigoDeBarras.geraImagemDoCodigoDeBarrasPara(
				boleto.getBanco().geraCodigoDeBarrasPara(boleto), 39.00f);
		
		try {
			this.writer.writeImage(5, 10, toBufferedImage(imagemDoCodigoDeBarras, BufferedImage.TYPE_INT_ARGB),
					280, imagemDoCodigoDeBarras.getHeight(null));
		} catch (IOException e) {
			throw new CriacaoBoletoException("Erro na geração do código de barras", e);
		}
	}
	
	private String nullToEmpty(String str) {
	    return str == null ? "" : str;
	}
}

