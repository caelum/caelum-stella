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
@XmlType(name = "IPITrib ", propOrder = { "cst", "vbc", "pipi", "qUnid", "vUnid", "vipi" })
public class IPITrib {

    @XmlElement(name = "CST", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cst;
    @XmlElement(name = "vBC")
    protected String vbc;
    @XmlElement(name = "pIPI")
    protected String pipi;
    protected String qUnid;
    protected String vUnid;
    @XmlElement(name = "vIPI", required = true)
    protected String vipi;

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

    public String getPIPI() {
        return pipi;
    }

    public void setPIPI(String value) {
        this.pipi = value;
    }

    public String getQUnid() {
        return qUnid;
    }

    public void setQUnid(String value) {
        this.qUnid = value;
    }

    public String getVUnid() {
        return vUnid;
    }

    public void setVUnid(String value) {
        this.vUnid = value;
    }

    public String getVIPI() {
        return vipi;
    }

    public void setVIPI(String value) {
        this.vipi = value;
    }

}