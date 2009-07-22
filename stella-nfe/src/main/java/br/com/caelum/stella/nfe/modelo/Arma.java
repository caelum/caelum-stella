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

import net.vidageek.fluid.annotations.FluidDataType;
import net.vidageek.fluid.annotations.FluidName;
import br.com.caelum.stella.nfe.builder.generated.enums.TipoDeArmamento;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Arma ", propOrder = { "tpArma", "nSerie", "nCano", "descr" })
@FluidName("Armamento")
public class Arma {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("tipo")
    @FluidDataType(TipoDeArmamento.class)
    protected String tpArma;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("numeroDeSerie")
    @FluidDataType(Integer.class)
    protected String nSerie;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("numeroDeSerieDoCano")
    @FluidDataType(Integer.class)
    protected String nCano;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("descricao")
    protected String descr;

    public String getTpArma() {
        return tpArma;
    }

    public void setTpArma(final String value) {
        tpArma = value;
    }

    public String getNSerie() {
        return nSerie;
    }

    public void setNSerie(final String value) {
        nSerie = value;
    }

    public String getNCano() {
        return nCano;
    }

    public void setNCano(final String value) {
        nCano = value;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(final String value) {
        descr = value;
    }

}