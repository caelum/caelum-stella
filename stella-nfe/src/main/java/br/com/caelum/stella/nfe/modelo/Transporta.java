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
@XmlType(name = "Transporta ", propOrder = { "cnpj", "cpf", "xNome", "ie", "xEnder", "xMun", "uf" })
public class Transporta {

    @XmlElement(name = "CNPJ")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cnpj;
    @XmlElement(name = "CPF")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cpf;
    protected String xNome;
    @XmlElement(name = "IE")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String ie;
    protected String xEnder;
    protected String xMun;
    @XmlElement(name = "UF")
    protected TUf uf;

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

    public String getIE() {
        return ie;
    }

    public void setIE(String value) {
        this.ie = value;
    }

    public String getXEnder() {
        return xEnder;
    }

    public void setXEnder(String value) {
        this.xEnder = value;
    }

    public String getXMun() {
        return xMun;
    }

    public void setXMun(String value) {
        this.xMun = value;
    }

    public TUf getUF() {
        return uf;
    }

    public void setUF(TUf value) {
        this.uf = value;
    }

}