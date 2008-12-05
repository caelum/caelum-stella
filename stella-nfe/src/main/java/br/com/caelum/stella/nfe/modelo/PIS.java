/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PIS ", propOrder = { "pisAliq", "pisQtde", "pisnt", "pisOutr" })
public class PIS {

    @XmlElement(name = "PISAliq")
    protected PISAliq pisAliq;
    @XmlElement(name = "PISQtde")
    protected PISQtde pisQtde;
    @XmlElement(name = "PISNT")
    protected PISNT pisnt;
    @XmlElement(name = "PISOutr")
    protected PISOutr pisOutr;

    public PISAliq getPISAliq() {
        return pisAliq;
    }

    public void setPISAliq(PISAliq value) {
        this.pisAliq = value;
    }

    public PISQtde getPISQtde() {
        return pisQtde;
    }

    public void setPISQtde(PISQtde value) {
        this.pisQtde = value;
    }

    public PISNT getPISNT() {
        return pisnt;
    }

    public void setPISNT(PISNT value) {
        this.pisnt = value;
    }

    public PISOutr getPISOutr() {
        return pisOutr;
    }

    public void setPISOutr(PISOutr value) {
        this.pisOutr = value;
    }

}