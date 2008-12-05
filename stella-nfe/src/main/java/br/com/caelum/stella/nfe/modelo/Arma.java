/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Arma ", propOrder = { "tpArma", "nSerie", "nCano", "descr" })
public class Arma {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String tpArma;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String nSerie;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String nCano;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String descr;

    public String getTpArma() {
        return tpArma;
    }

    public void setTpArma(String value) {
        this.tpArma = value;
    }

    public String getNSerie() {
        return nSerie;
    }

    public void setNSerie(String value) {
        this.nSerie = value;
    }

    public String getNCano() {
        return nCano;
    }

    public void setNCano(String value) {
        this.nCano = value;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String value) {
        this.descr = value;
    }

}