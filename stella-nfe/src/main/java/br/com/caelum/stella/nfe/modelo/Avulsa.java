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
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Avulsa ", propOrder = { "cnpj", "xOrgao", "matr", "xAgente", "fone", "uf", "ndar", "dEmi", "vdar",
        "repEmi", "dPag" })
public class Avulsa {

    @XmlElement(name = "CNPJ", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cnpj;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String xOrgao;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String matr;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String xAgente;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String fone;
    @XmlElement(name = "UF", required = true)
    protected TUf uf;
    @XmlElement(name = "nDAR", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String ndar;
    @XmlElement(required = true)
    protected XMLGregorianCalendar dEmi;
    @XmlElement(name = "vDAR", required = true)
    protected String vdar;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String repEmi;
    protected XMLGregorianCalendar dPag;

    public String getCNPJ() {
        return cnpj;
    }

    public void setCNPJ(String value) {
        this.cnpj = value;
    }

    public String getXOrgao() {
        return xOrgao;
    }

    public void setXOrgao(String value) {
        this.xOrgao = value;
    }

    public String getMatr() {
        return matr;
    }

    public void setMatr(String value) {
        this.matr = value;
    }

    public String getXAgente() {
        return xAgente;
    }

    public void setXAgente(String value) {
        this.xAgente = value;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String value) {
        this.fone = value;
    }

    public TUf getUF() {
        return uf;
    }

    public void setUF(TUf value) {
        this.uf = value;
    }

    public String getNDAR() {
        return ndar;
    }

    public void setNDAR(String value) {
        this.ndar = value;
    }

    public XMLGregorianCalendar getDEmi() {
        return dEmi;
    }

    public void setDEmi(XMLGregorianCalendar value) {
        this.dEmi = value;
    }

    public String getVDAR() {
        return vdar;
    }

    public void setVDAR(String value) {
        this.vdar = value;
    }

    public String getRepEmi() {
        return repEmi;
    }

    public void setRepEmi(String value) {
        this.repEmi = value;
    }

    public XMLGregorianCalendar getDPag() {
        return dPag;
    }

    public void setDPag(XMLGregorianCalendar value) {
        this.dPag = value;
    }

}