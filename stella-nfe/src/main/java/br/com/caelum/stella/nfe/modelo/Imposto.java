/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "icms", "ipi", "ii", "pis", "pisst", "cofins", "cofinsst", "issqn" })
public class Imposto {

    @XmlElement(name = "ICMS", required = true)
    protected ICMS icms;
    @XmlElement(name = "IPI")
    protected IPI ipi;
    @XmlElement(name = "II")
    protected II ii;
    @XmlElement(name = "PIS", required = true)
    protected PIS pis;
    @XmlElement(name = "PISST")
    protected PISST pisst;
    @XmlElement(name = "COFINS", required = true)
    protected COFINS cofins;
    @XmlElement(name = "COFINSST")
    protected COFINSST cofinsst;
    @XmlElement(name = "ISSQN")
    protected ISSQN issqn;

    public ICMS getICMS() {
        return icms;
    }

    public void setICMS(ICMS value) {
        this.icms = value;
    }

    public IPI getIPI() {
        return ipi;
    }

    public void setIPI(IPI value) {
        this.ipi = value;
    }

    public II getII() {
        return ii;
    }

    public void setII(II value) {
        this.ii = value;
    }

    public PIS getPIS() {
        return pis;
    }

    public void setPIS(PIS value) {
        this.pis = value;
    }

    public PISST getPISST() {
        return pisst;
    }

    public void setPISST(PISST value) {
        this.pisst = value;
    }

    public COFINS getCOFINS() {
        return cofins;
    }

    public void setCOFINS(COFINS value) {
        this.cofins = value;
    }

    public COFINSST getCOFINSST() {
        return cofinsst;
    }

    public void setCOFINSST(COFINSST value) {
        this.cofinsst = value;
    }

    public ISSQN getISSQN() {
        return issqn;
    }

    public void setISSQN(ISSQN value) {
        this.issqn = value;
    }

}