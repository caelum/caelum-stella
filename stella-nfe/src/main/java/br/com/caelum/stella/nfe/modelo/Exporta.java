/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Exporta ", propOrder = { "ufEmbarq", "xLocEmbarq" })
public class Exporta {

    @XmlElement(name = "UFEmbarq", required = true)
    protected UF ufEmbarq;

    @XmlElement(required = true)
    protected String xLocEmbarq;

    public UF getUFEmbarq() {
        return ufEmbarq;
    }

    public void setUFEmbarq(UF value) {
        this.ufEmbarq = value;
    }

    public String getXLocEmbarq() {
        return xLocEmbarq;
    }

    public void setXLocEmbarq(String value) {
        this.xLocEmbarq = value;
    }

}