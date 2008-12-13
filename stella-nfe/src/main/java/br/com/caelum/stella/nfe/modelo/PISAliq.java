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
@XmlType(name = "PISAliq ", propOrder = { "cst", "vbc", "ppis", "vpis" })
public class PISAliq {

    @XmlElement(name = "CST", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cst;

    @XmlElement(name = "vBC", required = true)
    protected String vbc;

    @XmlElement(name = "pPIS", required = true)
    protected String ppis;

    @XmlElement(name = "vPIS", required = true)
    protected String vpis;

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

    public String getPPIS() {
        return ppis;
    }

    public void setPPIS(String value) {
        this.ppis = value;
    }

    public String getVPIS() {
        return vpis;
    }

    public void setVPIS(String value) {
        this.vpis = value;
    }

}