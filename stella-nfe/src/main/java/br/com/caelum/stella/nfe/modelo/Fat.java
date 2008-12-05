/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Fat ", propOrder = { "nFat", "vOrig", "vDesc", "vLiq" })
public class Fat {

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String nFat;
    protected String vOrig;
    protected String vDesc;
    protected String vLiq;

    public String getNFat() {
        return nFat;
    }

    public void setNFat(String value) {
        this.nFat = value;
    }

    public String getVOrig() {
        return vOrig;
    }

    public void setVOrig(String value) {
        this.vOrig = value;
    }

    public String getVDesc() {
        return vDesc;
    }

    public void setVDesc(String value) {
        this.vDesc = value;
    }

    public String getVLiq() {
        return vLiq;
    }

    public void setVLiq(String value) {
        this.vLiq = value;
    }

}