/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import net.vidageek.fluid.annotations.FluidDataType;
import net.vidageek.fluid.annotations.FluidName;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Fat ", propOrder = { "nFat", "vOrig", "vDesc", "vLiq" })
@FluidName("Fatura")
public class Fat {

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("numeroDaFatura")
    protected String nFat;

    @FluidName("valorOriginal")
    @FluidDataType(BigDecimal.class)
    protected String vOrig;

    @FluidName("valorDeDesconto")
    @FluidDataType(BigDecimal.class)
    protected String vDesc;

    @FluidName("valorLiquido")
    @FluidDataType(BigDecimal.class)
    protected String vLiq;

    public String getNFat() {
        return nFat;
    }

    public void setNFat(final String value) {
        nFat = value;
    }

    public String getVOrig() {
        return vOrig;
    }

    public void setVOrig(final String value) {
        vOrig = value;
    }

    public String getVDesc() {
        return vDesc;
    }

    public void setVDesc(final String value) {
        vDesc = value;
    }

    public String getVLiq() {
        return vLiq;
    }

    public void setVLiq(final String value) {
        vLiq = value;
    }

}