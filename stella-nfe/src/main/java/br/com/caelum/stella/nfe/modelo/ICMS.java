/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ICMS ", propOrder = { "icms00", "icms10", "icms20", "icms30", "icms40", "icms51", "icms60", "icms70",
        "icms90" })
public class ICMS {

    @XmlElement(name = "ICMS00")
    protected ICMS00 icms00;
    @XmlElement(name = "ICMS10")
    protected ICMS10 icms10;
    @XmlElement(name = "ICMS20")
    protected ICMS20 icms20;
    @XmlElement(name = "ICMS30")
    protected ICMS30 icms30;
    @XmlElement(name = "ICMS40")
    protected ICMS40 icms40;
    @XmlElement(name = "ICMS51")
    protected ICMS51 icms51;
    @XmlElement(name = "ICMS60")
    protected ICMS60 icms60;
    @XmlElement(name = "ICMS70")
    protected ICMS70 icms70;
    @XmlElement(name = "ICMS90")
    protected ICMS90 icms90;

    public ICMS00 getICMS00() {
        return icms00;
    }

    public void setICMS00(ICMS00 value) {
        this.icms00 = value;
    }

    public ICMS10 getICMS10() {
        return icms10;
    }

    public void setICMS10(ICMS10 value) {
        this.icms10 = value;
    }

    public ICMS20 getICMS20() {
        return icms20;
    }

    public void setICMS20(ICMS20 value) {
        this.icms20 = value;
    }

    public ICMS30 getICMS30() {
        return icms30;
    }

    public void setICMS30(ICMS30 value) {
        this.icms30 = value;
    }

    public ICMS40 getICMS40() {
        return icms40;
    }

    public void setICMS40(ICMS40 value) {
        this.icms40 = value;
    }

    public ICMS51 getICMS51() {
        return icms51;
    }

    public void setICMS51(ICMS51 value) {
        this.icms51 = value;
    }

    public ICMS60 getICMS60() {
        return icms60;
    }

    public void setICMS60(ICMS60 value) {
        this.icms60 = value;
    }

    public ICMS70 getICMS70() {
        return icms70;
    }

    public void setICMS70(ICMS70 value) {
        this.icms70 = value;
    }

    public ICMS90 getICMS90() {
        return icms90;
    }

    public void setICMS90(ICMS90 value) {
        this.icms90 = value;
    }

}