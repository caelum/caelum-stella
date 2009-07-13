package br.com.caelum.stella.boleto.transformer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.CriacaoBoletoException;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.GeracaoBoletoException;
import br.com.caelum.stella.boleto.Sacado;
import br.com.caelum.stella.boleto.bancos.LinhaDigitavelGenerator;

public class HTMLBoletoWriter implements BoletoWriter {

    private final URL urlServletBoleto;
    private Template template;
    private final Collection<BoletoTemplateWrapper> boletos;
    private final VelocityEngine velocityEngine;

    /**
     * 
     * @param urlServletBoleto
     *            url de sua app. Ex: http://www.algumsite.com.br/stella-boleto/
     */
    public HTMLBoletoWriter(final URL urlServletBoleto) {
        this.urlServletBoleto = urlServletBoleto;
        boletos = new ArrayList<BoletoTemplateWrapper>();
        velocityEngine = new VelocityEngine();
        Properties config = new Properties();
        config.setProperty("file.resource.loader.class",
                "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        try {
            velocityEngine.init(config);
            template = velocityEngine.getTemplate("/br/com/caelum/stella/boleto/template_html.vm");
        } catch (Exception e) {
            throw new GeracaoBoletoException("Não foi possivel iniciar a configuração do Velocity", e);
        }
    }

    /**
     * 
     * @param boleto
     * 
     */
    public void write(final Boleto boleto) {
        BoletoTemplateWrapper wrapper = new BoletoTemplateWrapper(boleto);
        boletos.add(wrapper);
    }

    public boolean newPage() {
        return true;
    }

    public InputStream toInputStream() {

        StringWriter writer = new StringWriter();
        VelocityContext context = new VelocityContext();
        context.put("boletos", boletos);
        context.put("urlServletBoleto", urlServletBoleto.toExternalForm());
        try {
            template.merge(context, writer);
        } catch (ResourceNotFoundException e) {
            throw new CriacaoBoletoException("Erro na criação do boleto", e);
        } catch (ParseErrorException e) {
            throw new CriacaoBoletoException("Erro na criação do boleto", e);
        } catch (MethodInvocationException e) {
            throw new CriacaoBoletoException("Erro na criação do boleto", e);
        } catch (IOException e) {
            throw new CriacaoBoletoException("Erro na criação do boleto", e);
        }
        return new ByteArrayInputStream(writer.toString().getBytes());
    }

    /**
     * Apenas para ajudar com algumas coisas que ficam meio complicadas se
     * colocadas diretas no template
     * 
     * @author Alberto Pc
     * 
     */
    public class BoletoTemplateWrapper {
        private final LinhaDigitavelGenerator linhaDigitavelGenerator;
        private final Boleto boleto;
        private final String linhaDigitavel;
        private final String codigoDeBarras;

        /**
         * Como a classe tinha que ter visibilidade p�blica, pois o template
         * fica em outro pacote, deixei o construtor privado para n�o correr o
         * risco de algu�m usar.
         */
        private BoletoTemplateWrapper(final Boleto boleto) {
            this.boleto = boleto;
            linhaDigitavelGenerator = new LinhaDigitavelGenerator();
            linhaDigitavel = linhaDigitavelGenerator.geraLinhaDigitavelPara(this.boleto);
            codigoDeBarras = this.boleto.getBanco().geraCodigoDeBarrasPara(this.boleto);
        }

        public char aceite() {
            return getAceite() ? 'S' : 'N';
        }

        public String formataData(final Calendar data) {
            return BoletoFormatter.formatDate(data);
        }

        public String formataValor() {
            return BoletoFormatter.formatValue(boleto.getValorBoleto().doubleValue());
        }

        public String nossoNumero() {
            return getBanco().getNossoNumeroDoEmissorFormatado(boleto.getEmissor());
        }

        public String carteira() {
            return getBanco().getCarteiraDoEmissorFormatado(boleto.getEmissor());
        }

        public String contaCorrente() {
            return getBanco().getContaCorrenteDoEmissorFormatado(boleto.getEmissor());
        }

        public String linhaDigitavel() {
            return linhaDigitavel;
        }

        public String codigoDeBarras() {
            return codigoDeBarras;
        }

        public boolean getAceite() {
            return boleto.getAceite();
        }

        public Banco getBanco() {
            return boleto.getBanco();
        }

        public int getCodEspecieMoeda() {
            return boleto.getCodEspecieMoeda();
        }

        public Datas getDatas() {
            return boleto.getDatas();
        }

        public List<String> getDescricoes() {
            return boleto.getDescricoes();
        }

        public Emissor getEmissor() {
            return boleto.getEmissor();
        }

        public String getEspecieDocumento() {
            return boleto.getEspecieDocumento();
        }

        public String getEspecieMoeda() {
            return boleto.getEspecieMoeda();
        }

        public String getFatorVencimento() {
            return boleto.getFatorVencimento();
        }

        public List<String> getInstrucoes() {
            return boleto.getInstrucoes();
        }

        public List<String> getLocaisDePagamento() {
            return boleto.getLocaisDePagamento();
        }

        public String getNoDocumento() {
            return boleto.getNoDocumento();
        }

        public String getNoDocumentoFormatado() {
            return boleto.getNoDocumentoFormatado();
        }

        public BigDecimal getQtdMoeda() {
            return boleto.getQtdMoeda();
        }

        public Sacado getSacado() {
            return boleto.getSacado();
        }

        public BigDecimal getValorBoleto() {
            return boleto.getValorBoleto();
        }

        public String getValorFormatado() {
            return boleto.getValorFormatado();
        }

        public BigDecimal getValorMoeda() {
            return boleto.getValorMoeda();
        }

        public String nomeArquivoCodigoDeBarras() {
            return codigoDeBarras + "_" + boleto.getBanco().getNumeroFormatado() + ".png";
        }

    }
}
