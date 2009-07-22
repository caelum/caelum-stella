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

import net.vidageek.fluid.annotations.FluidName;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RefNF ", propOrder = { "cuf", "aamm", "cnpj", "mod", "serie", "nnf" })
@FluidName("NFReferenciada")
public class RefNF {

    @XmlElement(name = "cUF", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("codigoUF")
    protected String cuf;

    @XmlElement(name = "AAMM", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("AAMM")
    protected String aamm;

    @XmlElement(name = "CNPJ", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("CNPJ")
    protected String cnpj;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    // TODO Não estava na interface
    protected String mod;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("serie")
    protected String serie;

    @XmlElement(name = "nNF", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("numero")
    protected String nnf;

    public String getCUF() {
        return cuf;
    }

    public void setCUF(final String value) {
        cuf = value;
    }

    public String getAAMM() {
        return aamm;
    }

    public void setAAMM(final String value) {
        aamm = value;
    }

    public String getCNPJ() {
        return cnpj;
    }

    public void setCNPJ(final String value) {
        cnpj = value;
    }

    public String getMod() {
        return mod;
    }

    public void setMod(final String value) {
        mod = value;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(final String value) {
        serie = value;
    }

    public String getNNF() {
        return nnf;
    }

    public void setNNF(final String value) {
        nnf = value;
    }

}