/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetTrib ", propOrder = { "vRetPIS", "vRetCOFINS", "vRetCSLL", "vbcirrf", "virrf", "vbcRetPrev",
        "vRetPrev" })
public class RetTrib {

    protected String vRetPIS;
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

    public void setVRetPIS(String value) {
        this.vRetPIS = value;
    }

    public String getVRetCOFINS() {
        return vRetCOFINS;
    }

    public void setVRetCOFINS(String value) {
        this.vRetCOFINS = value;
    }

    public String getVRetCSLL() {
        return vRetCSLL;
    }

    public void setVRetCSLL(String value) {
        this.vRetCSLL = value;
    }

    public String getVBCIRRF() {
        return vbcirrf;
    }

    public void setVBCIRRF(String value) {
        this.vbcirrf = value;
    }

    public String getVIRRF() {
        return virrf;
    }

    public void setVIRRF(String value) {
        this.virrf = value;
    }

    public String getVBCRetPrev() {
        return vbcRetPrev;
    }

    public void setVBCRetPrev(String value) {
        this.vbcRetPrev = value;
    }

    public String getVRetPrev() {
        return vRetPrev;
    }

    public void setVRetPrev(String value) {
        this.vRetPrev = value;
    }

}