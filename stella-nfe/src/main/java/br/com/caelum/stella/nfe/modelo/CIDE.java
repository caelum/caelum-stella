/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CIDE ", propOrder = { "qbcProd", "vAliqProd", "vcide" })
public class CIDE {

    @XmlElement(name = "qBCProd", required = true)
    protected String qbcProd;
    @XmlElement(required = true)
    protected String vAliqProd;
    @XmlElement(name = "vCIDE", required = true)
    protected String vcide;

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

    public String getVCIDE() {
        return vcide;
    }

    public void setVCIDE(String value) {
        this.vcide = value;
    }

}