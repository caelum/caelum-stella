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
@XmlType(name = "ICMS00 ", propOrder = { "orig", "cst", "modBC", "vbc", "picms", "vicms" })
public class ICMS00 {

    @XmlElement(name = "orig", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String origem;

    @XmlElement(name = "CST", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String tipoTributacao;

    @XmlElement(name = "", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String modalidadeBaseCalculo;

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

    public String getTipoTributacao() {
        return tipoTributacao;
    }

    public void setTipoTributacao(final String cst) {
        this.tipoTributacao = cst;
    }

    public String getValorBaseCalculo() {
        return valorBaseCalculo;
    }

    public void setValorBaseCalculo(final String vbc) {
        this.valorBaseCalculo = vbc;
    }

    public String getAliquota() {
        return aliquota;
    }

    public void setAliquota(final String picms) {
        this.aliquota = picms;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(final String vicms) {
        this.valor = vicms;
    }

}