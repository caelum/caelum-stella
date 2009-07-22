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
@XmlType(name = "PISQtde ", propOrder = { "cst", "qbcProd", "vAliqProd", "vpis" })
@FluidName("PISTributadoPorQuantidade")
public class PISQtde {

    @XmlElement(name = "CST", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    // TODO Fluid must support auto-setting of values
    protected String cst;

    @XmlElement(name = "qBCProd", required = true)
    @FluidName("quantidadeVendida")
    @FluidDataType(BigDecimal.class)
    protected String qbcProd;

    @XmlElement(required = true)
    @FluidName("aliquota")
    @FluidDataType(BigDecimal.class)
    protected String vAliqProd;

    @XmlElement(name = "vPIS", required = true)
    @FluidName("valorDoPIS")
    @FluidDataType(BigDecimal.class)
    protected String vpis;

    public String getCST() {
        return cst;
    }

    public void setCST(final String value) {
        cst = value;
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