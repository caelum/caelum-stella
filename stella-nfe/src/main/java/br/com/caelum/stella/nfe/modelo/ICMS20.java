/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ICMS20 ", propOrder = { "orig", "cst", "modBC", "pRedBC", "vbc", "picms", "vicms" })
public class ICMS20 {

    @XmlElement(name = "orig", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String origem;

    @XmlElement(name = "CST", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String tipoTributacao;

    @XmlElement(name = "modBC", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String modalidadeBaseCalculo;

    @XmlElement(name = "pRedBC", required = true)
    protected String percentualReducaoBaseCalculo;

    @XmlElement(name = "vBC", required = true)
    protected String valorBaseCalculo;

    @XmlElement(name = "pICMS", required = true)
    protected String aliquota;

    @XmlElement(name = "vICMS", required = true)
    protected String valor;

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(final String value) {
        origem = value;
    }

    public String getCST() {
        return tipoTributacao;
    }

    public void setCST(final String value) {
        tipoTributacao = value;
    }

    public String getModalidadeBaseCalculo() {
        return modalidadeBaseCalculo;
    }

    public void setModalidadeBaseCalculo(final String value) {
        modalidadeBaseCalculo = value;
    }

    public String getPercentualReducaoBaseCalculo() {
        return percentualReducaoBaseCalculo;
    }

    public void setPercentualReducaoBaseCalculo(final String value) {
        percentualReducaoBaseCalculo = value;
    }

    public String getVBC() {
        return valorBaseCalculo;
    }

    public void setVBC(final String value) {
        valorBaseCalculo = value;
    }

    public String getPICMS() {
        return aliquota;
    }

    public void setPICMS(final String value) {
        aliquota = value;
    }

    public String getVICMS() {
        return valor;
    }

    public void setVICMS(final String value) {
        valor = value;
    }

}