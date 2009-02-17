package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IPITrib ", propOrder = { "cst", "vbc", "pipi", "qUnid", "vUnid", "vipi" })
public class IPITrib {

    @XmlElement(name = "CST", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String codigoSituacaoTributaria;

    @XmlElement(name = "vBC")
    protected String valorDaBaseDeCalculo;

    @XmlElement(name = "pIPI")
    protected String aliquotaIPI;

    @XmlElement(name = "qUnid")
    protected String quantidade;

    @XmlElement(name = "vUnid")
    protected String valorUnidade;

    @XmlElement(name = "vIPI", required = true)
    protected String valorIPI;

    public String getCodigoSituacaoTributaria() {
        return codigoSituacaoTributaria;
    }

    public void setCodigoSituacaoTributaria(String codigoSituacaoTributaria) {
        this.codigoSituacaoTributaria = codigoSituacaoTributaria;
    }

    public String getvalorDaBaseDeCalculo() {
        return valorDaBaseDeCalculo;
    }

    public void setvalorDaBaseDeCalculo(String valorDaBaseDeCalculo) {
        this.valorDaBaseDeCalculo = valorDaBaseDeCalculo;
    }

    public String getAliquotaIPI() {
        return aliquotaIPI;
    }

    public void setAliquotaIPI(String aliquotaIPI) {
        this.aliquotaIPI = aliquotaIPI;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getValorUnidade() {
        return valorUnidade;
    }

    public void setValorUnidade(String valorUnidade) {
        this.valorUnidade = valorUnidade;
    }

    public String getValorIPI() {
        return valorIPI;
    }

    public void setValorIPI(String valorIPI) {
        this.valorIPI = valorIPI;
    }

}