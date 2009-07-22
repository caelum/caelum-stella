/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import net.vidageek.fluid.annotations.FluidDataType;
import net.vidageek.fluid.annotations.FluidName;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COFINSQtde ", propOrder = { "cst", "qbcProd", "vAliqProd", "vcofins" })
@FluidName("COFINSTributadoPelaQuantidade")
public class COFINSQtde {

    @XmlElement(name = "CST", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("codigoSituacaoTributaria")
    protected String codigoSituacaoTributaria;

    @XmlElement(name = "qBCProd", required = true)
    @FluidName("quantidadeVendida")
    @FluidDataType(BigDecimal.class)
    protected String quantidadeVendida;

    @XmlElement(name = "vAliqProd", required = true)
    @FluidName("aliquota")
    @FluidDataType(BigDecimal.class)
    protected String aliquota;

    @XmlElement(name = "vCOFINS", required = true)
    @FluidName("valor")
    @FluidDataType(BigDecimal.class)
    protected String valor;

    public String getCodigoSituacaoTributaria() {
        return codigoSituacaoTributaria;
    }

    public void setCodigoSituacaoTributaria(final String codigoSituacaoTributaria) {
        this.codigoSituacaoTributaria = codigoSituacaoTributaria;
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