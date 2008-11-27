/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "vServ", "vbc", "viss", "vpis", "vcofins" })
public class ISSQNtot {

    protected String vServ;
    @XmlElement(name = "vBC")
    protected String vbc;
    @XmlElement(name = "vISS")
    protected String viss;
    @XmlElement(name = "vPIS")
    protected String vpis;
    @XmlElement(name = "vCOFINS")
    protected String vcofins;

    public String getVServ() {
        return vServ;
    }

    public void setVServ(String value) {
        this.vServ = value;
    }

    public String getVBC() {
        return vbc;
    }

    public void setVBC(String value) {
        this.vbc = value;
    }

    public String getVISS() {
        return viss;
    }

    public void setVISS(String value) {
        this.viss = value;
    }

    public String getVPIS() {
        return vpis;
    }

    public void setVPIS(String value) {
        this.vpis = value;
    }

    public String getVCOFINS() {
        return vcofins;
    }

    public void setVCOFINS(String value) {
        this.vcofins = value;
    }

}