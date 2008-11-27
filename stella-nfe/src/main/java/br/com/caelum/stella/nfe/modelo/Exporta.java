/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "ufEmbarq", "xLocEmbarq" })
public class Exporta {

    @XmlElement(name = "UFEmbarq", required = true)
    protected TUf ufEmbarq;
    @XmlElement(required = true)
    protected String xLocEmbarq;

    public TUf getUFEmbarq() {
        return ufEmbarq;
    }

    public void setUFEmbarq(TUf value) {
        this.ufEmbarq = value;
    }

    public String getXLocEmbarq() {
        return xLocEmbarq;
    }

    public void setXLocEmbarq(String value) {
        this.xLocEmbarq = value;
    }

}