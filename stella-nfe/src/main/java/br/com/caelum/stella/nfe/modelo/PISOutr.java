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
@XmlType(name = "PISOutr ", propOrder = { "cst", "vbc", "ppis", "qbcProd", "vAliqProd", "vpis" })
@FluidName("PISOutrasOperacoes")
public class PISOutr {

    @XmlElement(name = "CST", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    // TODO auto set
    protected String cst;

    @XmlElement(name = "vBC")
    @FluidName("valorDaBaseDeCalculo")
    @FluidDataType(BigDecimal.class)
    protected String vbc;

    @XmlElement(name = "pPIS")
    @FluidName("aliquota")
    @FluidDataType(BigDecimal.class)
    protected String ppis;

    @XmlElement(name = "qBCProd")
    @FluidName("quantidadeVendida")
    @FluidDataType(BigDecimal.class)
    protected String qbcProd;

    @FluidName("aliquotaDoProduto")
    @FluidDataType(BigDecimal.class)
    protected String vAliqProd;

    @XmlElement(name = "vPIS", required = true)
    @FluidName("valor")
    @FluidDataType(BigDecimal.class)
    protected String vpis;

    public String getCST() {
        return cst;
    }

    public void setCST(final String value) {
        cst = value;
    }

    public String getVBC() {
        return vbc;
    }

    public void setVBC(final String value) {
        vbc = value;
    }

    public String getPPIS() {
        return ppis;
    }

    public void setPPIS(final String value) {
        ppis = value;
    }

    public String getQBCProd() {
        return qbcProd;
    }

    public void setQBCProd(final String value) {
        qbcProd = value;
    }

    public String getVAliqProd() {
        return vAliqProd;
    }

    public void setVAliqProd(final String value) {
        vAliqProd = value;
    }

    public String getVPIS() {
        return vpis;
    }

    public void setVPIS(final String value) {
        vpis = value;
    }

}