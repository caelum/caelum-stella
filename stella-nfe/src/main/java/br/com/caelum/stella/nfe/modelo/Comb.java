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
@XmlType(name = "Comb ", propOrder = { "cProdANP", "codif", "qTemp", "cide", "icmsComb", "icmsInter", "icmsCons" })
public class Comb {

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cProdANP;

    @XmlElement(name = "CODIF")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String codif;

    protected String qTemp;

    @XmlElement(name = "CIDE")
    protected CIDE cide;

    @XmlElement(name = "ICMSComb", required = true)
    protected ICMSComb icmsComb;

    @XmlElement(name = "ICMSInter")
    protected ICMSInter icmsInter;

    @XmlElement(name = "ICMSCons")
    protected ICMSCons icmsCons;

    public String getCProdANP() {
        return cProdANP;
    }

    public void setCProdANP(String value) {
        this.cProdANP = value;
    }

    public String getCODIF() {
        return codif;
    }

    public void setCODIF(String value) {
        this.codif = value;
    }

    public String getQTemp() {
        return qTemp;
    }

    public void setQTemp(String value) {
        this.qTemp = value;
    }

    public CIDE getCIDE() {
        return cide;
    }

    public void setCIDE(CIDE value) {
        this.cide = value;
    }

    public ICMSComb getICMSComb() {
        return icmsComb;
    }

    public void setICMSComb(ICMSComb value) {
        this.icmsComb = value;
    }

    public ICMSInter getICMSInter() {
        return icmsInter;
    }

    public void setICMSInter(ICMSInter value) {
        this.icmsInter = value;
    }

    public ICMSCons getICMSCons() {
        return icmsCons;
    }

    public void setICMSCons(ICMSCons value) {
        this.icmsCons = value;
    }

}