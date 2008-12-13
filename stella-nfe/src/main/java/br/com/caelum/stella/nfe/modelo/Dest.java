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
@XmlType(name = "Dest ", propOrder = { "cnpj", "cpf", "xNome", "enderDest", "ie", "isuf" })
public class Dest {

    @XmlElement(name = "CNPJ")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cnpj;

    @XmlElement(name = "CPF")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cpf;

    @XmlElement(required = true)
    protected String xNome;

    @XmlElement(required = true)
    protected TEndereco enderDest;

    @XmlElement(name = "IE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String ie;

    @XmlElement(name = "ISUF")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String isuf;

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

    public TEndereco getEnderDest() {
        return enderDest;
    }

    public void setEnderDest(TEndereco value) {
        this.enderDest = value;
    }

    public String getIE() {
        return ie;
    }

    public void setIE(String value) {
        this.ie = value;
    }

    public String getISUF() {
        return isuf;
    }

    public void setISUF(String value) {
        this.isuf = value;
    }

}