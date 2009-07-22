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
@XmlType(name = "ICMSCons ", propOrder = { "vbcicmsstCons", "vicmsstCons", "ufCons" })
@FluidName("ICMSSobreConsumo")
public class ICMSCons {

    @XmlElement(name = "vBCICMSSTCons", required = true)
    @FluidName("valorDaBaseDeCalculoDoICMSDeSubstituicaoTributariaSobreConsumo")
    @FluidDataType(BigDecimal.class)
    protected String vbcicmsstCons;

    @XmlElement(name = "vICMSSTCons", required = true)
    @FluidName("valorDoICMSSubstituicaoTributariaSobreConsumo")
    @FluidDataType(BigDecimal.class)
    protected String vicmsstCons;

    @XmlElement(name = "UFCons", required = true)
    @FluidName("UF")
    @FluidDataType(UF.class)
    protected UF ufCons;

    public String getVBCICMSSTCons() {
        return vbcicmsstCons;
    }

    public void setVBCICMSSTCons(final String value) {
        vbcicmsstCons = value;
    }

    public String getVICMSSTCons() {
        return vicmsstCons;
    }

    public void setVICMSSTCons(final String value) {
        vicmsstCons = value;
    }

    public UF getUFCons() {
        return ufCons;
    }

    public void setUFCons(final UF value) {
        ufCons = value;
    }

}