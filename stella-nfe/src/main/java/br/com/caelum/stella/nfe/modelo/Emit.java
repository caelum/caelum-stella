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
@XmlType(name = "Emit ", propOrder = { "cnpj", "cpf", "xNome", "xFant", "enderEmit", "ie", "iest", "im", "cnae" })
@FluidName("Emitente")
public class Emit {

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

    @FluidName("nomeFantasia")
    protected String xFant;

    @XmlElement(required = true)
    @FluidName("enderecoDoEmitente")
    protected TEndereco enderEmit;

    @XmlElement(name = "IE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("inscricaoEstadual")
    protected String ie;

    @XmlElement(name = "IEST")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("inscricaoEstadualDoSubstitutoTributario")
    protected String iest;

    @XmlElement(name = "IM")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("inscricaoMunicipal")
    protected String im;

    @XmlElement(name = "CNAE")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("CNAEFiscal")
    protected String cnae;

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

    public String getXFant() {
        return xFant;
    }

    public void setXFant(final String value) {
        xFant = value;
    }

    public TEndereco getEnderEmit() {
        return enderEmit;
    }

    public void setEnderEmit(final TEndereco value) {
        enderEmit = value;
    }

    public String getIE() {
        return ie;
    }

    public void setIE(final String value) {
        ie = value;
    }

    public String getIEST() {
        return iest;
    }

    public void setIEST(final String value) {
        iest = value;
    }

    public String getIM() {
        return im;
    }

    public void setIM(final String value) {
        im = value;
    }

    public String getCNAE() {
        return cnae;
    }

    public void setCNAE(final String value) {
        cnae = value;
    }

}