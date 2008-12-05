/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PISST ", propOrder = { "vbc", "ppis", "qbcProd", "vAliqProd", "vpis" })
public class PISST {

    @XmlElement(name = "vBC")
    protected String vbc;
    @XmlElement(name = "pPIS")
    protected String ppis;
    @XmlElement(name = "qBCProd")
    protected String qbcProd;
    protected String vAliqProd;
    @XmlElement(name = "vPIS", required = true)
    protected String vpis;

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

    public String getVPIS() {
        return vpis;
    }

    public void setVPIS(String value) {
        this.vpis = value;
    }

}