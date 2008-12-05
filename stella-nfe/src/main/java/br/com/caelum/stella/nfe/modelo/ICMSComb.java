/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ICMSComb ", propOrder = { "vbcicms", "vicms", "vbcicmsst", "vicmsst" })
public class ICMSComb {

    @XmlElement(name = "vBCICMS", required = true)
    protected String vbcicms;
    @XmlElement(name = "vICMS", required = true)
    protected String vicms;
    @XmlElement(name = "vBCICMSST", required = true)
    protected String vbcicmsst;
    @XmlElement(name = "vICMSST", required = true)
    protected String vicmsst;

    public String getVBCICMS() {
        return vbcicms;
    }

    public void setVBCICMS(String value) {
        this.vbcicms = value;
    }

    public String getVICMS() {
        return vicms;
    }

    public void setVICMS(String value) {
        this.vicms = value;
    }

    public String getVBCICMSST() {
        return vbcicmsst;
    }

    public void setVBCICMSST(String value) {
        this.vbcicmsst = value;
    }

    public String getVICMSST() {
        return vicmsst;
    }

    public void setVICMSST(String value) {
        this.vicmsst = value;
    }

}