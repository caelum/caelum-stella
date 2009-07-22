/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import net.vidageek.fluid.annotations.FluidDataType;
import net.vidageek.fluid.annotations.FluidName;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Exporta ", propOrder = { "ufEmbarq", "xLocEmbarq" })
@FluidName("Exportacao")
public class Exporta {

    @XmlElement(name = "UFEmbarq", required = true)
    @FluidName("UFDoEmbarque")
    @FluidDataType(UF.class)
    protected UF ufEmbarq;

    @XmlElement(required = true)
    @FluidName("localDoEmbarque")
    protected String xLocEmbarq;

    public UF getUFEmbarq() {
        return ufEmbarq;
    }

    public void setUFEmbarq(final UF value) {
        ufEmbarq = value;
    }

    public String getXLocEmbarq() {
        return xLocEmbarq;
    }

    public void setXLocEmbarq(final String value) {
        xLocEmbarq = value;
    }

}