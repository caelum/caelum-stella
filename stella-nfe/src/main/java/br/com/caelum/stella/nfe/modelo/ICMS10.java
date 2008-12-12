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

import br.com.caelum.stella.nfe.builder.ICMS;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ICMS10 ", propOrder = { "orig", "cst", "modBC", "vbc", "picms", "vicms", "modBCST", "pmvast",
        "pRedBCST", "vbcst", "picmsst", "vicmsst" })
public class ICMS10 implements ICMS {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String orig;
    @XmlElement(name = "CST", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cst;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String modBC;
    @XmlElement(name = "vBC", required = true)
    protected String vbc;
    @XmlElement(name = "pICMS", required = true)
    protected String picms;
    @XmlElement(name = "vICMS", required = true)
    protected String vicms;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String modBCST;
    @XmlElement(name = "pMVAST")
    protected String pmvast;
    protected String pRedBCST;
    @XmlElement(name = "vBCST", required = true)
    protected String vbcst;
    @XmlElement(name = "pICMSST", required = true)
    protected String picmsst;
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

    public String getModBC() {
        return modBC;
    }

    public void setModBC(String value) {
        this.modBC = value;
    }

    public String getVBC() {
        return vbc;
    }

    public void setVBC(String value) {
        this.vbc = value;
    }

    public String getPICMS() {
        return picms;
    }

    public void setPICMS(String value) {
        this.picms = value;
    }

    public String getVICMS() {
        return vicms;
    }

    public void setVICMS(String value) {
        this.vicms = value;
    }

    public String getModBCST() {
        return modBCST;
    }

    public void setModBCST(String value) {
        this.modBCST = value;
    }

    public String getPMVAST() {
        return pmvast;
    }

    public void setPMVAST(String value) {
        this.pmvast = value;
    }

    public String getPRedBCST() {
        return pRedBCST;
    }

    public void setPRedBCST(String value) {
        this.pRedBCST = value;
    }

    public String getVBCST() {
        return vbcst;
    }

    public void setVBCST(String value) {
        this.vbcst = value;
    }

    public String getPICMSST() {
        return picmsst;
    }

    public void setPICMSST(String value) {
        this.picmsst = value;
    }

    public String getVICMSST() {
        return vicmsst;
    }

    public void setVICMSST(String value) {
        this.vicmsst = value;
    }

}