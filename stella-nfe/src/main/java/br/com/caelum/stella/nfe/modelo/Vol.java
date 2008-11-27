/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "qVol", "esp", "marca", "nVol", "pesoL", "pesoB", "lacres" })
public class Vol {

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String qVol;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String esp;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String marca;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String nVol;
    protected String pesoL;
    protected String pesoB;
    protected List<Lacres> lacres;

    public String getQVol() {
        return qVol;
    }

    public void setQVol(String value) {
        this.qVol = value;
    }

    public String getEsp() {
        return esp;
    }

    public void setEsp(String value) {
        this.esp = value;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String value) {
        this.marca = value;
    }

    public String getNVol() {
        return nVol;
    }

    public void setNVol(String value) {
        this.nVol = value;
    }

    public String getPesoL() {
        return pesoL;
    }

    public void setPesoL(String value) {
        this.pesoL = value;
    }

    public String getPesoB() {
        return pesoB;
    }

    public void setPesoB(String value) {
        this.pesoB = value;
    }

    public List<Lacres> getLacres() {
        if (lacres == null) {
            lacres = new ArrayList<Lacres>();
        }
        return this.lacres;
    }

}