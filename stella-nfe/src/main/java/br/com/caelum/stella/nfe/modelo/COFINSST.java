/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COFINSST ", propOrder = { "vbc", "pcofins", "qbcProd", "vAliqProd", "vcofins" })
public class COFINSST {

    @XmlElement(name = "vBC")
    protected String valorDaBaseDeCalculo;

    @XmlElement(name = "pCOFINS")
    protected String aliquotaEmPercentual;

    @XmlElement(name = "qBCProd")
    protected String quantidadeVendida;

    @XmlElement(name = "vAliqProd")
    protected String aliquota;

    @XmlElement(name = "vCOFINS", required = true)
    protected String valor;

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

    public void setAliquota(final String aliquotaEmReais) {
        this.aliquota = aliquotaEmReais;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(final String valor) {
        this.valor = valor;
    }

}