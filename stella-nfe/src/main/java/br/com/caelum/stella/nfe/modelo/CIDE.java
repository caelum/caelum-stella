/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import net.vidageek.fluid.annotations.FluidDataType;
import net.vidageek.fluid.annotations.FluidName;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CIDE ", propOrder = { "qbcProd", "vAliqProd", "vcide" })
@FluidName("CIDESobreCombustiveis")
public class CIDE {

    @XmlElement(name = "qBCProd", required = true)
    @FluidName("baseDeCalculo")
    @FluidDataType(BigDecimal.class)
    protected String qbcProd;

    @XmlElement(required = true)
    @FluidName("aliquota")
    @FluidDataType(BigDecimal.class)
    protected String vAliqProd;

    @XmlElement(name = "vCIDE", required = true)
    @FluidName("valor")
    @FluidDataType(BigDecimal.class)
    protected String vcide;

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

    public String getVCIDE() {
        return vcide;
    }

    public void setVCIDE(final String value) {
        vcide = value;
    }

}