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

import net.vidageek.fluid.annotations.FluidName;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Transp ", propOrder = { "modFrete", "transporta", "retTransp", "veicTransp", "reboque", "vol" })
@FluidName("Transporte")
public class Transp {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("modalidadeDoFrete")
    protected String modFrete;

    @FluidName("transportador")
    protected Transporta transporta;

    @FluidName("ICMSRetidoPeloTransporte")
    protected RetTransp retTransp;

    @FluidName("veiculoUsado")
    protected TVeiculo veicTransp;

    @FluidName("reboque")
    protected List<TVeiculo> reboque;

    @FluidName("volume")
    protected List<Vol> vol;

    public String getModFrete() {
        return modFrete;
    }

    public void setModFrete(final String value) {
        modFrete = value;
    }

    public Transporta getTransporta() {
        return transporta;
    }

    public void setTransporta(final Transporta value) {
        transporta = value;
    }

    public RetTransp getRetTransp() {
        return retTransp;
    }

    public void setRetTransp(final RetTransp value) {
        retTransp = value;
    }

    public TVeiculo getVeicTransp() {
        return veicTransp;
    }

    public void setVeicTransp(final TVeiculo value) {
        veicTransp = value;
    }

    public List<TVeiculo> getReboque() {
        if (reboque == null) {
            reboque = new ArrayList<TVeiculo>();
        }
        return reboque;
    }

    public List<Vol> getVol() {
        if (vol == null) {
            vol = new ArrayList<Vol>();
        }
        return vol;
    }

    public void setReboques(final List<TVeiculo> reboques) {
        reboque = reboques;
    }

    public void setVol(final List<Vol> vol) {
        this.vol = vol;
    }

}