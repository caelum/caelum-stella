package br.com.caelum.stella.boleto.transformer.template2;

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
import br.com.caelum.stella.boleto.transformer.BoletoTemplate;
import br.com.caelum.stella.boleto.transformer.BufferedImageGenerator;
import br.com.caelum.stella.boleto.transformer.FormatadorDeBoleto;
import br.com.caelum.stella.boleto.transformer.GeradorDeImagemDoCodigoDeBarras;

import br.com.caelum.stella.boleto.transformer.TextWriter;

/**
 * Classe que centraliza a criação dos boletos que tem como template o
 * template.png e antes ficava no BoletoTransformer
 *
 *
 */
class PNGPDFTransformerHelper2 {
    /* Ainda precisa de um nome melhor!! */

    public static final float IMAGEM_BOLETO_WIDTH = 2144;
    public static final float IMAGEM_BOLETO_HEIGHT = 1604;
    public static final double BOLETO_TEMPLATE_SCALE = 1 / 2d;
    private TextWriter writer;
    private URL imagemTitulo;

    private PNGPDFTransformerHelper2(TextWriter writer, BoletoTemplate boletoTemplate) {
        super();
        this.writer = writer;
        this.imagemTitulo = PNGPDFTransformerHelper2.class.getResource(boletoTemplate.getEnderecoTemplate());
    }

    public PNGPDFTransformerHelper2(TextWriter writer) {
        this(writer, BoletoTemplate.TEMPLATE_AVANCADO);
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
            this.writer.writeImage(0, 55, imageFor(imagemTitulo), 500.22f, 750.109f);
            this.writer.writeImage(30, 800 - 20, imageFor(boleto.getBanco().getImage()), 60, 23);
            this.writer.writeImage(30, 800 - 364, imageFor(boleto.getBanco().getImage()), 60, 23);
        } catch (IOException e) {
            throw new GeracaoBoletoException("Erro na leitura das imagens do boleto", e);
        }

        for (int i = 0; i < boleto.getDescricoes().size(); i++) {
            this.writer.writeBold(5, 805 - 70 - i * 15, boleto.getDescricoes().get(i));
        }
    }

    private void imprimeReciboDeSacado(Boleto boleto) {
        final float LINHA08 = 800 - 20;
        final float LINHA09 = 800 - 38;
        final float LINHA10 = 800 - 51;
        final float LINHA11 = 800 - 65;
        final float LINHA12 = 800 - 78;
        final float LINHA13 = 800 - 92;
        final float LINHA17 = 800 - 130;
        final float LINHA18 = 800 - 144;
        final float LINHA19 = 800 - 157;
        final float LINHA20 = 800 - 170;


        final float LINHA27 = 800 - 237;
        final float LINHA28 = 800 - 247;
        final float LINHA29 = 800 - 257;
        final float LINHA30 = 800 - 267;


        this.writer.writeBold(105, LINHA08, boleto.getBanco().getNumeroFormatadoComDigito());
        this.writer.write(26, LINHA09, boleto.getLocaisDePagamento().get(0));
        this.writer.write(26, LINHA10, boleto.getEmissor().getCedente());
        this.writer.write(65, LINHA27, boleto.getEmissor().getEndereco());


        this.writer.write(65, LINHA28, boleto.getSacado().getNome());
        this.writer.write(65, LINHA29, boleto.getSacado().getEndereco());
        this.writer.write(65, LINHA30, boleto.getSacado().getCep());
        this.writer.write(130, LINHA30, boleto.getSacado().getBairro());
        this.writer.write(190, LINHA30, boleto.getSacado().getCidade());
        this.writer.write(280, LINHA30, boleto.getSacado().getUf());

        this.writer.write(26, LINHA11, formatDate(boleto.getDatas().getDocumento()));
        this.writer.write(100, LINHA11, boleto.getNumeroDoDocumento());
        this.writer.write(240, LINHA11, boleto.getAceite() ? "Sim" : "Não");

        this.writer.write(95, LINHA12, boleto.getBanco().getCarteiraDoEmissorFormatado(boleto.getEmissor()));
        this.writer.write(140, LINHA12, boleto.getEspecieMoeda());
        if (boleto.getParcela() != null) {
            this.writer.write(365, LINHA17, boleto.getParcela());
        }
        this.writer.write(430, LINHA17, formatDate(boleto.getDatas().getVencimento()));
        this.writer.write(400, LINHA18, boleto.getAgenciaECodigoCedente());
        this.writer.write(373, LINHA19, boleto.getNossoNumeroECodDocumento());
        this.writer.write(405, LINHA20, FormatadorDeBoleto.formataValor(boleto.getValorBoleto().doubleValue()));


        for (int i = 0; i < boleto.getInstrucoes().size(); i++) {
            this.writer.write(26, LINHA13 - i * 10, boleto.getInstrucoes().get(i));
        }


    }

    private void imprimeLinhaDigitavelEmNegrito(Boleto boleto) {
        final float LINHA36 = 800 - 365;
        this.writer.writeBold(148, LINHA36, boleto.getBanco().getNumeroFormatado());
        GeradorDeLinhaDigitavel linhaDigitavelGenerator = new GeradorDeLinhaDigitavel();
        String codigoDeBarras = boleto.getBanco().geraCodigoDeBarrasPara(boleto);
        this.writer.writeBold(148, LINHA36, linhaDigitavelGenerator.geraLinhaDigitavelPara(codigoDeBarras));
        this.writer.writeBold(105, LINHA36, boleto.getBanco().getNumeroFormatadoComDigito());
    }

    private void imprimeLocaisDePagamentoEVencimento(Boleto boleto) {
        final float LINHA37 = 800 - 381;
//		for (int i = 0; i < boleto.getLocaisDePagamento().size(); i++) {
//			this.writer.write(5, LINHA5 - (i - 1) * 10, boleto.getLocaisDePagamento().get(i));
//		}
        if (boleto.getParcela() != null) {
            this.writer.write(365, LINHA37, boleto.getParcela());
        }
        this.writer.write(26, LINHA37, boleto.getLocaisDePagamento().get(0));
        this.writer.write(425, LINHA37, formatDate(boleto.getDatas().getVencimento()));
    }

    private void imprimeDadosDoCedente(Boleto boleto) {
        final float LINHA38 = 800 - 394;
        this.writer.write(26, LINHA38, boleto.getEmissor().getCedente());
        this.writer.write(400, LINHA38, boleto.getAgenciaECodigoCedente());
    }

    private void imprimeDadosDoDocumento(Boleto boleto) {
        final float LINHA39 = 800 - 408;
        this.writer.write(26, LINHA39, formatDate(boleto.getDatas().getDocumento()));
        this.writer.write(100, LINHA39, boleto.getNumeroDoDocumento().equals("")
                ? boleto.getBanco().getNossoNumeroDoEmissorFormatado(boleto.getEmissor())
                : boleto.getNumeroDoDocumentoFormatado());
        //this.writer.write(180, LINHA39, boleto.getEspecieDocumento());
        this.writer.write(240, LINHA39, boleto.getAceite() ? "Sim" : "Não");
        //this.writer.write(300, LINHA39, formatDate(boleto.getDatas().getProcessamento()));
        this.writer.write(373, LINHA39, boleto.getNossoNumeroECodDocumento());
    }

    private void imprimeDadosDoBoletoInclusiveValor(Boleto boleto) {
        final float LINHA40 = 800 - 420;
        this.writer.write(95, LINHA40, boleto.getBanco().getCarteiraDoEmissorFormatado(boleto.getEmissor()));
        this.writer.write(140, LINHA40, boleto.getEspecieMoeda());
        this.writer.write(405, LINHA40, FormatadorDeBoleto.formataValor(boleto.getValorBoleto().doubleValue()));
    }

    private void imprimeInstrucoesDePagamento(Boleto boleto) {
        final float LINHA41 = 800 - 435;

        for (int i = 0; i < boleto.getInstrucoes().size(); i++) {
            this.writer.write(26, LINHA41 - i * 10, boleto.getInstrucoes().get(i));
        }
    }

    private void imprimeUnidadeCedente(Boleto boleto) {
        final float LINHA44 = 800 - 487;
        this.writer.write(65, LINHA44, boleto.getEmissor().getEndereco());
    }

    private void imprimeDadosDoSacado(Boleto boleto) {
        final float LINHA45 = 800 - 497;
        final float LINHA46 = 800 - 507;
        final float LINHA47 = 800 - 517;


        this.writer.write(65, LINHA45, boleto.getSacado().getNome());
        this.writer.write(65, LINHA46, boleto.getSacado().getEndereco());
        this.writer.write(65, LINHA47, boleto.getSacado().getCep());
        this.writer.write(130, LINHA47, boleto.getSacado().getBairro());
        this.writer.write(190, LINHA47, boleto.getSacado().getCidade());
        this.writer.write(280, LINHA47, boleto.getSacado().getUf());
    }

    private void geraEImprimeCodigoDeBarras(Boleto boleto) {
        Image imagemDoCodigoDeBarras = GeradorDeImagemDoCodigoDeBarras.geraImagemDoCodigoDeBarrasPara(
                boleto.getBanco().geraCodigoDeBarrasPara(boleto), 45.00f);

        try {
            this.writer.writeImage(26, 800 - 590, toBufferedImage(imagemDoCodigoDeBarras, BufferedImage.TYPE_INT_ARGB),
                    310, imagemDoCodigoDeBarras.getHeight(null));
        } catch (IOException e) {
            throw new CriacaoBoletoException("Erro na geração do código de barras", e);
        }
    }

    private String nullToEmpty(String str) {
        return str == null ? "" : str;
    }
}
