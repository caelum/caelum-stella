/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.stella.boleto.transformer;

import br.com.caelum.stella.boleto.transformer.template_avancado.PDFBoletoWriterTemplateAvancado;
import br.com.caelum.stella.boleto.transformer.template_avancado.PNGBoletoWriterTemplateAvancado;
import br.com.caelum.stella.boleto.transformer.template_basico.PDFBoletoWriter;
import br.com.caelum.stella.boleto.transformer.template_basico.PNGBoletoWriter;

/**
 *
 * @author lucas.guedes
 */
public enum BoletoTemplate {
//    /br/com/caelum/stella/boleto/img/template.png

    TEMPLATE_BASICO("/br/com/caelum/stella/boleto/img/template.png"),
    TEMPLATE_AVANCADO("/br/com/caelum/stella/boleto/img/template1.png");
    private String enderecoTemplate;

    private BoletoTemplate(String enderecoTemplate) {
        this.enderecoTemplate = enderecoTemplate;

    }

    public BoletoWriter getBoletoPNGWriter() {
        if (name().equalsIgnoreCase(TEMPLATE_BASICO.name())) {
            return new PNGBoletoWriter();
        } else {
            return new PNGBoletoWriterTemplateAvancado();
        }
    }

    public String getEnderecoTemplate() {
        return enderecoTemplate;
    }

    public BoletoWriter getBoletoPDFWriter() {
        if (name().equalsIgnoreCase(TEMPLATE_BASICO.name())) {
            return new PDFBoletoWriter();
        } else {
            return new PDFBoletoWriterTemplateAvancado();
        }
    }
}
