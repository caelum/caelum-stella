/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ICMSInter ", propOrder = { "vbcicmsstDest", "vicmsstDest" })
public class ICMSInter {

    @XmlElement(name = "vBCICMSSTDest", required = true)
    protected String vbcicmsstDest;
    @XmlElement(name = "vICMSSTDest", required = true)
    protected String vicmsstDest;

    public String getVBCICMSSTDest() {
        return vbcicmsstDest;
    }

    public void setVBCICMSSTDest(String value) {
        this.vbcicmsstDest = value;
    }

    public String getVICMSSTDest() {
        return vicmsstDest;
    }

    public void setVICMSSTDest(String value) {
        this.vicmsstDest = value;
    }

}