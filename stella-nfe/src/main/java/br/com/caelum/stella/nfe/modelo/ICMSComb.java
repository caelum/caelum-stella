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
@XmlType(name = "ICMSComb ", propOrder = { "vbcicms", "vicms", "vbcicmsst", "vicmsst" })
@FluidName("ICMSSobreCombustiveis")
public class ICMSComb {

    @XmlElement(name = "vBCICMS", required = true)
    @FluidName("valorDaBaseDeCalculo")
    @FluidDataType(BigDecimal.class)
    protected String vbcicms;

    @XmlElement(name = "vICMS", required = true)
    @FluidName("valor")
    @FluidDataType(BigDecimal.class)
    protected String vicms;

    @XmlElement(name = "vBCICMSST", required = true)
    @FluidName("valorDaBaseDeCalculoDaSubstituicaoTributaria")
    @FluidDataType(BigDecimal.class)
    protected String vbcicmsst;

    @XmlElement(name = "vICMSST", required = true)
    @FluidName("valorDoICMSDaSubstituicaoTributaria")
    @FluidDataType(BigDecimal.class)
    protected String vicmsst;

    public String getVBCICMS() {
        return vbcicms;
    }

    public void setVBCICMS(final String value) {
        vbcicms = value;
    }

    public String getVICMS() {
        return vicms;
    }

    public void setVICMS(final String value) {
        vicms = value;
    }

    public String getVBCICMSST() {
        return vbcicmsst;
    }

    public void setVBCICMSST(final String value) {
        vbcicmsst = value;
    }

    public String getVICMSST() {
        return vicmsst;
    }

    public void setVICMSST(final String value) {
        vicmsst = value;
    }

}