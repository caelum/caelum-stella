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
import br.com.caelum.stella.nfe.builder.enums.OrigemDoProcesso;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcRef ", propOrder = { "nProc", "indProc" })
@FluidName("ProcessoReferenciado")
public class ProcRef {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("identificadorDoProcesso")
    protected String nProc;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("origemDoProcesso")
    @FluidDataType(OrigemDoProcesso.class)
    protected String indProc;

    public String getNProc() {
        return nProc;
    }

    public void setNProc(final String value) {
        nProc = value;
    }

    public String getIndProc() {
        return indProc;
    }

    public void setIndProc(final String value) {
        indProc = value;
    }

}