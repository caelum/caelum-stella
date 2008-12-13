/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Transp ", propOrder = { "modFrete", "transporta", "retTransp", "veicTransp", "reboque", "vol" })
public class Transp {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String modFrete;

    protected Transporta transporta;

    protected RetTransp retTransp;

    protected TVeiculo veicTransp;

    protected List<TVeiculo> reboque;

    protected List<Vol> vol;

    public String getModFrete() {
        return modFrete;
    }

    public void setModFrete(String value) {
        this.modFrete = value;
    }

    public Transporta getTransporta() {
        return transporta;
    }

    public void setTransporta(Transporta value) {
        this.transporta = value;
    }

    public RetTransp getRetTransp() {
        return retTransp;
    }

    public void setRetTransp(RetTransp value) {
        this.retTransp = value;
    }

    public TVeiculo getVeicTransp() {
        return veicTransp;
    }

    public void setVeicTransp(TVeiculo value) {
        this.veicTransp = value;
    }

    public List<TVeiculo> getReboque() {
        if (reboque == null) {
            reboque = new ArrayList<TVeiculo>();
        }
        return this.reboque;
    }

    public List<Vol> getVol() {
        if (vol == null) {
            vol = new ArrayList<Vol>();
        }
        return this.vol;
    }

}