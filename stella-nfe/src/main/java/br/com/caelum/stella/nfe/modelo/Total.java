/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Total ", propOrder = { "icmsTot", "issqNtot", "retTrib" })
public class Total {

    @XmlElement(name = "ICMSTot", required = true)
    protected ICMSTot icmsTot;
    @XmlElement(name = "ISSQNtot")
    protected ISSQNtot issqNtot;
    protected RetTrib retTrib;

    public ICMSTot getICMSTot() {
        return icmsTot;
    }

    public void setICMSTot(ICMSTot value) {
        this.icmsTot = value;
    }

    public ISSQNtot getISSQNtot() {
        return issqNtot;
    }

    public void setISSQNtot(ISSQNtot value) {
        this.issqNtot = value;
    }

    public RetTrib getRetTrib() {
        return retTrib;
    }

    public void setRetTrib(RetTrib value) {
        this.retTrib = value;
    }

}