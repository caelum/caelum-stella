/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ICMSCons ", propOrder = { "vbcicmsstCons", "vicmsstCons", "ufCons" })
public class ICMSCons {

    @XmlElement(name = "vBCICMSSTCons", required = true)
    protected String vbcicmsstCons;

    @XmlElement(name = "vICMSSTCons", required = true)
    protected String vicmsstCons;

    @XmlElement(name = "UFCons", required = true)
    protected UF ufCons;

    public String getVBCICMSSTCons() {
        return vbcicmsstCons;
    }

    public void setVBCICMSSTCons(String value) {
        this.vbcicmsstCons = value;
    }

    public String getVICMSSTCons() {
        return vicmsstCons;
    }

    public void setVICMSSTCons(String value) {
        this.vicmsstCons = value;
    }

    public UF getUFCons() {
        return ufCons;
    }

    public void setUFCons(UF value) {
        this.ufCons = value;
    }

}