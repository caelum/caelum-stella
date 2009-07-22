/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import net.vidageek.fluid.annotations.FluidDataType;
import net.vidageek.fluid.annotations.FluidName;
import br.com.caelum.stella.tinytype.CNPJ;

final @XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "uf", "cnpj" })
@FluidName("Exclui")
public class Exclui {

    @XmlElement(name = "UF", namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    @FluidName("UF")
    protected TUf uf;
    @XmlElement(name = "CNPJ", namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    @FluidName("CNPJ")
    @FluidDataType(CNPJ.class)
    protected CNPJ cnpj;

    public TUf getUF() {
        return uf;
    }

    public void setUF(final TUf value) {
        uf = value;
    }

    public CNPJ getCNPJ() {
        return cnpj;
    }

    public void setCNPJ(final CNPJ value) {
        cnpj = value;
    }

}