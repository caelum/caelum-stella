/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "prod", "imposto", "infAdProd" })
public class Det {

    @XmlElement(required = true)
    protected Prod prod;
    @XmlElement(required = true)
    protected Imposto imposto;
    protected String infAdProd;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String nItem;

    public Prod getProd() {
        return prod;
    }

    public void setProd(Prod value) {
        this.prod = value;
    }

    public Imposto getImposto() {
        return imposto;
    }

    public void setImposto(Imposto value) {
        this.imposto = value;
    }

    public String getInfAdProd() {
        return infAdProd;
    }

    public void setInfAdProd(String value) {
        this.infAdProd = value;
    }

    public String getNItem() {
        return nItem;
    }

    public void setNItem(String value) {
        this.nItem = value;
    }

}