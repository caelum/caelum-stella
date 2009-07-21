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

import net.vidageek.fluid.annotations.FluidName;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Vol ", propOrder = { "qVol", "esp", "marca", "nVol", "pesoL", "pesoB", "lacres" })
@FluidName("Volume")
public class Vol {

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("quantidade")
    protected String qVol;

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("especie")
    protected String esp;

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("marca")
    protected String marca;

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("numeracao")
    protected String nVol;

    @FluidName("pesoLiquido")
    protected String pesoL;

    @FluidName("pesoBruto")
    protected String pesoB;

    @FluidName("lacres")
    protected List<Lacres> lacres;

    public String getQVol() {
        return qVol;
    }

    public void setQVol(final String value) {
        qVol = value;
    }

    public String getEsp() {
        return esp;
    }

    public void setEsp(final String value) {
        esp = value;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(final String value) {
        marca = value;
    }

    public String getNVol() {
        return nVol;
    }

    public void setNVol(final String value) {
        nVol = value;
    }

    public String getPesoL() {
        return pesoL;
    }

    public void setPesoL(final String value) {
        pesoL = value;
    }

    public String getPesoB() {
        return pesoB;
    }

    public void setPesoB(final String value) {
        pesoB = value;
    }

    public List<Lacres> getLacres() {
        if (lacres == null) {
            lacres = new ArrayList<Lacres>();
        }
        return lacres;
    }

    public void setLacres(final List<Lacres> lacres) {
        this.lacres = lacres;
    }

}