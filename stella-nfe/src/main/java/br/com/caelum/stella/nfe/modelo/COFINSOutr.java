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
@XmlType(name = "COFINSOutr ", propOrder = { "cst", "vbc", "pcofins", "qbcProd", "vAliqProd", "vcofins" })
public class COFINSOutr {

    @XmlElement(name = "CST", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String codigoSituacaoTributaria;

    @XmlElement(name = "vBC")
    protected String valorDaBaseDeCalculo;

    @XmlElement(name = "pCOFINS")
    protected String aliquotaEmPercentual;

    @XmlElement(name = "qbcProd")
    protected String quantidadeVendida;

    @XmlElement(name = "vAliqProd")
    protected String aliquota;

    @XmlElement(name = "vCOFINS", required = true)
    protected String valor;

    public String getCodigoSituacaoTributaria() {
        return codigoSituacaoTributaria;
    }

    public void setCodigoSituacaoTributaria(final String codigoSituacaoTributaria) {
        this.codigoSituacaoTributaria = codigoSituacaoTributaria;
    }

    public String getvalorDaBaseDeCalculo() {
        return valorDaBaseDeCalculo;
    }

    public void setvalorDaBaseDeCalculo(final String valorDaBaseDeCalculo) {
        this.valorDaBaseDeCalculo = valorDaBaseDeCalculo;
    }

    public String getAliquotaEmPercentual() {
        return aliquotaEmPercentual;
    }

    public void setAliquotaEmPercentual(final String aliquotaEmPercentual) {
        this.aliquotaEmPercentual = aliquotaEmPercentual;
    }

    public String getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(final String quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    public String getAliquota() {
        return aliquota;
    }

    public void setAliquota(final String aliquota) {
        this.aliquota = aliquota;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(final String valor) {
        this.valor = valor;
    }

}