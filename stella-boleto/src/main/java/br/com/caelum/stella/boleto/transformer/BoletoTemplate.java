/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.stella.boleto.transformer;

/**
 *
 * @author lucas.guedes
 */
public enum BoletoTemplate {
//    /br/com/caelum/stella/boleto/img/template.png

    TEMPLATE_BASICO("/br/com/caelum/stella/boleto/img/template.png"),
    TEMPLATE_AVANCADO("/br/com/caelum/stella/boleto/img/template2.png");
    private String enderecoTemplate;

    private BoletoTemplate(String enderecoTemplate) {
        this.enderecoTemplate = enderecoTemplate;
    }

    public String getEnderecoTemplate() {
        return enderecoTemplate;
    }
}
