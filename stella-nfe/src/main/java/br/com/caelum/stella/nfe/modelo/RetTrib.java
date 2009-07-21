/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import net.vidageek.fluid.annotations.FluidName;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetTrib ", propOrder = { "vRetPIS", "vRetCOFINS", "vRetCSLL", "vbcirrf", "virrf", "vbcRetPrev",
        "vRetPrev" })
@FluidName("RetencaoDeTributosFederais")
public class RetTrib {

    @FluidName("valorRetencaoPIS")
    protected String vRetPIS;

    @FluidName("valorRetencaoCOFINS")
    protected String vRetCOFINS;

    protected String vRetCSLL;

    @XmlElement(name = "vBCIRRF")
    protected String vbcirrf;

    @XmlElement(name = "vIRRF")
    protected String virrf;

    @XmlElement(name = "vBCRetPrev")
    protected String vbcRetPrev;

    protected String vRetPrev;

    public String getVRetPIS() {
        return vRetPIS;
    }

    public void setVRetPIS(final String value) {
        vRetPIS = value;
    }

    public String getVRetCOFINS() {
        return vRetCOFINS;
    }

    public void setVRetCOFINS(final String value) {
        vRetCOFINS = value;
    }

    public String getVRetCSLL() {
        return vRetCSLL;
    }

    public void setVRetCSLL(final String value) {
        vRetCSLL = value;
    }

    public String getVBCIRRF() {
        return vbcirrf;
    }

    public void setVBCIRRF(final String value) {
        vbcirrf = value;
    }

    public String getVIRRF() {
        return virrf;
    }

    public void setVIRRF(final String value) {
        virrf = value;
    }

    public String getVBCRetPrev() {
        return vbcRetPrev;
    }

    public void setVBCRetPrev(final String value) {
        vbcRetPrev = value;
    }

    public String getVRetPrev() {
        return vRetPrev;
    }

    public void setVRetPrev(final String value) {
        vRetPrev = value;
    }

}