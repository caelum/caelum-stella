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
import br.com.caelum.stella.tinytype.CNPJ;
import br.com.caelum.stella.tinytype.CPF;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Dest ", propOrder = { "cnpj", "cpf", "xNome", "enderDest", "ie", "isuf" })
@FluidName("Destinatario")
public class Dest {

    @XmlElement(name = "CNPJ")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("CNPJ")
    @FluidDataType(CNPJ.class)
    protected String cnpj;

    @XmlElement(name = "CPF")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("CPF")
    @FluidDataType(CPF.class)
    protected String cpf;

    @XmlElement(required = true)
    @FluidName("razaoSocial")
    protected String xNome;

    @XmlElement(required = true)
    @FluidName("endererecoDoDestinatario")
    protected TEndereco enderDest;

    @XmlElement(name = "IE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("inscricaoEstadual")
    protected String ie;

    @XmlElement(name = "ISUF")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("inscricaoNaSUFRAMA")
    protected String isuf;

    public String getCNPJ() {
        return cnpj;
    }

    public void setCNPJ(final String value) {
        cnpj = value;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(final String value) {
        cpf = value;
    }

    public String getXNome() {
        return xNome;
    }

    public void setXNome(final String value) {
        xNome = value;
    }

    public TEndereco getEnderDest() {
        return enderDest;
    }

    public void setEnderDest(final TEndereco value) {
        enderDest = value;
    }

    public String getIE() {
        return ie;
    }

    public void setIE(final String value) {
        ie = value;
    }

    public String getISUF() {
        return isuf;
    }

    public void setISUF(final String value) {
        isuf = value;
    }

}