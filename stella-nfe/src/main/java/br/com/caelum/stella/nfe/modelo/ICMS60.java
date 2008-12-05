/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ICMS60 ", propOrder = { "orig", "cst", "vbcst", "vicmsst" })
public class ICMS60 {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String orig;
    @XmlElement(name = "CST", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cst;
    @XmlElement(name = "vBCST", required = true)
    protected String vbcst;
    @XmlElement(name = "vICMSST", required = true)
    protected String vicmsst;

    public String getOrig() {
        return orig;
    }

    public void setOrig(String value) {
        this.orig = value;
    }

    public String getCST() {
        return cst;
    }

    public void setCST(String value) {
        this.cst = value;
    }

    public String getVBCST() {
        return vbcst;
    }

    public void setVBCST(String value) {
        this.vbcst = value;
    }

    public String getVICMSST() {
        return vicmsst;
    }

    public void setVICMSST(String value) {
        this.vicmsst = value;
    }

}