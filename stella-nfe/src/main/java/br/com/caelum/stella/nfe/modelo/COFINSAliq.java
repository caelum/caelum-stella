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
@XmlType(name = "COFINSAliq ", propOrder = { "cst", "vbc", "pcofins", "vcofins" })
public class COFINSAliq {

    @XmlElement(name = "CST", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cst;
    @XmlElement(name = "vBC", required = true)
    protected String vbc;
    @XmlElement(name = "pCOFINS", required = true)
    protected String pcofins;
    @XmlElement(name = "vCOFINS", required = true)
    protected String vcofins;

    public String getCST() {
        return cst;
    }

    public void setCST(String value) {
        this.cst = value;
    }

    public String getVBC() {
        return vbc;
    }

    public void setVBC(String value) {
        this.vbc = value;
    }

    public String getPCOFINS() {
        return pcofins;
    }

    public void setPCOFINS(String value) {
        this.pcofins = value;
    }

    public String getVCOFINS() {
        return vcofins;
    }

    public void setVCOFINS(String value) {
        this.vcofins = value;
    }

}