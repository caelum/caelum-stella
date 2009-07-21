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
@XmlType(name = "Transporta ", propOrder = { "cnpj", "cpf", "xNome", "ie", "xEnder", "xMun", "uf" })
@FluidName("transportador")
public class Transporta {

    @XmlElement(name = "CNPJ")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("CNPJ")
    protected String cnpj;

    @XmlElement(name = "CPF")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("CPF")
    protected String cpf;

    @FluidName("nome")
    protected String xNome;

    @XmlElement(name = "IE")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("inscricaoEstadual")
    protected String ie;

    @FluidName("enderecoCompleto")
    protected String xEnder;

    @FluidName("nomeDoMunicipio")
    protected String xMun;

    @XmlElement(name = "UF")
    @FluidName("UF")
    protected UF uf;

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

    public String getIE() {
        return ie;
    }

    public void setIE(final String value) {
        ie = value;
    }

    public String getXEnder() {
        return xEnder;
    }

    public void setXEnder(final String value) {
        xEnder = value;
    }

    public String getXMun() {
        return xMun;
    }

    public void setXMun(final String value) {
        xMun = value;
    }

    public UF getUF() {
        return uf;
    }

    public void setUF(final UF value) {
        uf = value;
    }

}