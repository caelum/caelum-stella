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
@XmlType(name = "", propOrder = { "cst", "qbcProd", "vAliqProd", "vcofins" })
public class COFINSQtde {

    @XmlElement(name = "CST", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cst;
    @XmlElement(name = "qBCProd", required = true)
    protected String qbcProd;
    @XmlElement(required = true)
    protected String vAliqProd;
    @XmlElement(name = "vCOFINS", required = true)
    protected String vcofins;

    public String getCST() {
        return cst;
    }

    public void setCST(String value) {
        this.cst = value;
    }

    public String getQBCProd() {
        return qbcProd;
    }

    public void setQBCProd(String value) {
        this.qbcProd = value;
    }

    public String getVAliqProd() {
        return vAliqProd;
    }

    public void setVAliqProd(String value) {
        this.vAliqProd = value;
    }

    public String getVCOFINS() {
        return vcofins;
    }

    public void setVCOFINS(String value) {
        this.vcofins = value;
    }

}