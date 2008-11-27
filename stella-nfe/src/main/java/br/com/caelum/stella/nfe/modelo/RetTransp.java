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
@XmlType(name = "", propOrder = { "vServ", "vbcRet", "picmsRet", "vicmsRet", "cfop", "cMunFG" })
public class RetTransp {

    @XmlElement(required = true)
    protected String vServ;
    @XmlElement(name = "vBCRet", required = true)
    protected String vbcRet;
    @XmlElement(name = "pICMSRet", required = true)
    protected String picmsRet;
    @XmlElement(name = "vICMSRet", required = true)
    protected String vicmsRet;
    @XmlElement(name = "CFOP", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cfop;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cMunFG;

    public String getVServ() {
        return vServ;
    }

    public void setVServ(String value) {
        this.vServ = value;
    }

    public String getVBCRet() {
        return vbcRet;
    }

    public void setVBCRet(String value) {
        this.vbcRet = value;
    }

    public String getPICMSRet() {
        return picmsRet;
    }

    public void setPICMSRet(String value) {
        this.picmsRet = value;
    }

    public String getVICMSRet() {
        return vicmsRet;
    }

    public void setVICMSRet(String value) {
        this.vicmsRet = value;
    }

    public String getCFOP() {
        return cfop;
    }

    public void setCFOP(String value) {
        this.cfop = value;
    }

    public String getCMunFG() {
        return cMunFG;
    }

    public void setCMunFG(String value) {
        this.cMunFG = value;
    }

}