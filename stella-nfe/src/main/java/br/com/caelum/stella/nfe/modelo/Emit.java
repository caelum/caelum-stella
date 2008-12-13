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

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Emit ", propOrder = { "cnpj", "cpf", "xNome", "xFant", "enderEmit", "ie", "iest", "im", "cnae" })
public class Emit {

    @XmlElement(name = "CNPJ")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cnpj;

    @XmlElement(name = "CPF")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cpf;

    @XmlElement(required = true)
    protected String xNome;

    protected String xFant;

    @XmlElement(required = true)
    protected TEndereco enderEmit;

    @XmlElement(name = "IE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String ie;

    @XmlElement(name = "IEST")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String iest;

    @XmlElement(name = "IM")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String im;

    @XmlElement(name = "CNAE")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cnae;

    public String getCNPJ() {
        return cnpj;
    }

    public void setCNPJ(String value) {
        this.cnpj = value;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String value) {
        this.cpf = value;
    }

    public String getXNome() {
        return xNome;
    }

    public void setXNome(String value) {
        this.xNome = value;
    }

    public String getXFant() {
        return xFant;
    }

    public void setXFant(String value) {
        this.xFant = value;
    }

    public TEndereco getEnderEmit() {
        return enderEmit;
    }

    public void setEnderEmit(TEndereco value) {
        this.enderEmit = value;
    }

    public String getIE() {
        return ie;
    }

    public void setIE(String value) {
        this.ie = value;
    }

    public String getIEST() {
        return iest;
    }

    public void setIEST(String value) {
        this.iest = value;
    }

    public String getIM() {
        return im;
    }

    public void setIM(String value) {
        this.im = value;
    }

    public String getCNAE() {
        return cnae;
    }

    public void setCNAE(String value) {
        this.cnae = value;
    }

}