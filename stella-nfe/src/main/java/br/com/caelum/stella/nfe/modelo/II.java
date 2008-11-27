/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "vbc", "vDespAdu", "vii", "viof" })
public class II {

    @XmlElement(name = "vBC", required = true)
    protected String vbc;
    @XmlElement(required = true)
    protected String vDespAdu;
    @XmlElement(name = "vII", required = true)
    protected String vii;
    @XmlElement(name = "vIOF", required = true)
    protected String viof;

    public String getVBC() {
        return vbc;
    }

    public void setVBC(String value) {
        this.vbc = value;
    }

    public String getVDespAdu() {
        return vDespAdu;
    }

    public void setVDespAdu(String value) {
        this.vDespAdu = value;
    }

    public String getVII() {
        return vii;
    }

    public void setVII(String value) {
        this.vii = value;
    }

    public String getVIOF() {
        return viof;
    }

    public void setVIOF(String value) {
        this.viof = value;
    }

}