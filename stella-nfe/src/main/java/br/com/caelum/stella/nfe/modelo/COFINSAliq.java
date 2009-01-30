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
@XmlType(name = "COFINSAliq ", propOrder = { "cst", "vbc", "pcofins", "vcofins" })
public class COFINSAliq {

    @XmlElement(name = "CST", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String codigoSituacaoTributaria;

    @XmlElement(name = "vBC", required = true)
    protected String valorBaseCalculo;

    @XmlElement(name = "pCOFINS", required = true)
    protected String aliquotaEmPercentual;

    @XmlElement(name = "vCOFINS", required = true)
    protected String valor;

    public String getCodigoSituacaoTributaria() {
        return codigoSituacaoTributaria;
    }

    public void setCodigoSituacaoTributaria(final String codigoSituacaoTributaria) {
        this.codigoSituacaoTributaria = codigoSituacaoTributaria;
    }

    public String getValorBaseCalculo() {
        return valorBaseCalculo;
    }

    public void setValorBaseCalculo(final String valorBaseCalculo) {
        this.valorBaseCalculo = valorBaseCalculo;
    }

    public String getAliquotaEmPercentual() {
        return aliquotaEmPercentual;
    }

    public void setAliquotaEmPercentual(final String aliquotaEmPercentual) {
        this.aliquotaEmPercentual = aliquotaEmPercentual;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(final String valor) {
        this.valor = valor;
    }

}