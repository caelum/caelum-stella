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
@XmlType(name = "RefNF ", propOrder = { "cuf", "aamm", "cnpj", "mod", "serie", "nnf" })
public class RefNF {

    @XmlElement(name = "cUF", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cuf;
    @XmlElement(name = "AAMM", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String aamm;
    @XmlElement(name = "CNPJ", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cnpj;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String mod;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String serie;
    @XmlElement(name = "nNF", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String nnf;

    public String getCUF() {
        return cuf;
    }

    public void setCUF(String value) {
        this.cuf = value;
    }

    public String getAAMM() {
        return aamm;
    }

    public void setAAMM(String value) {
        this.aamm = value;
    }

    public String getCNPJ() {
        return cnpj;
    }

    public void setCNPJ(String value) {
        this.cnpj = value;
    }

    public String getMod() {
        return mod;
    }

    public void setMod(String value) {
        this.mod = value;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String value) {
        this.serie = value;
    }

    public String getNNF() {
        return nnf;
    }

    public void setNNF(String value) {
        this.nnf = value;
    }

}