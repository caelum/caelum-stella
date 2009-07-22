/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import net.vidageek.fluid.annotations.FluidDataType;
import net.vidageek.fluid.annotations.FluidName;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Adi ", propOrder = { "nAdicao", "nSeqAdic", "cFabricante", "vDescDI" })
@FluidName("Adicao")
public class Adi {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("numeroDaAdicao")
    @FluidDataType(Integer.class)
    protected String nAdicao;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("numeroSequencialDoItemDaAdicao")
    @FluidDataType(Integer.class)
    protected String nSeqAdic;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("codigoDoFabricanteEstrangeiro")
    protected String cFabricante;

    @FluidName("valorDeDescontoDoItemDaDI")
    @FluidDataType(BigDecimal.class)
    protected String vDescDI;

    public String getNAdicao() {
        return nAdicao;
    }

    public void setNAdicao(final String value) {
        nAdicao = value;
    }

    public String getNSeqAdic() {
        return nSeqAdic;
    }

    public void setNSeqAdic(final String value) {
        nSeqAdic = value;
    }

    public String getCFabricante() {
        return cFabricante;
    }

    public void setCFabricante(final String value) {
        cFabricante = value;
    }

    public String getVDescDI() {
        return vDescDI;
    }

    public void setVDescDI(final String value) {
        vDescDI = value;
    }

}