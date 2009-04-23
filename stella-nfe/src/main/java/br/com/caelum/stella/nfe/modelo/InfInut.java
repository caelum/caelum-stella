/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

final @XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "tpAmb", "verAplic", "cStat", "xMotivo", "cuf", "ano", "cnpj", "mod", "serie",
        "nnfIni", "nnfFin", "dhRecbto", "nProt" })
public class InfInut {

    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String tpAmb;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String verAplic;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cStat;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String xMotivo;
    @XmlElement(name = "cUF", namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cuf;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String ano;
    @XmlElement(name = "CNPJ", namespace = "http://www.portalfiscal.inf.br/nfe")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cnpj;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String mod;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String serie;
    @XmlElement(name = "nNFIni", namespace = "http://www.portalfiscal.inf.br/nfe")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String nnfIni;
    @XmlElement(name = "nNFFin", namespace = "http://www.portalfiscal.inf.br/nfe")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String nnfFin;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe")
    protected String dhRecbto;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String nProt;
    @XmlAttribute(name = "Id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    public String getTpAmb() {
        return tpAmb;
    }

    public void setTpAmb(final String value) {
        tpAmb = value;
    }

    public String getVerAplic() {
        return verAplic;
    }

    public void setVerAplic(final String value) {
        verAplic = value;
    }

    public String getCStat() {
        return cStat;
    }

    public void setCStat(final String value) {
        cStat = value;
    }

    public String getXMotivo() {
        return xMotivo;
    }

    public void setXMotivo(final String value) {
        xMotivo = value;
    }

    public String getCUF() {
        return cuf;
    }

    public void setCUF(final String value) {
        cuf = value;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(final String value) {
        ano = value;
    }

    public String getCNPJ() {
        return cnpj;
    }

    public void setCNPJ(final String value) {
        cnpj = value;
    }

    public String getMod() {
        return mod;
    }

    public void setMod(final String value) {
        mod = value;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(final String value) {
        serie = value;
    }

    public String getNNFIni() {
        return nnfIni;
    }

    public void setNNFIni(final String value) {
        nnfIni = value;
    }

    public String getNNFFin() {
        return nnfFin;
    }

    public void setNNFFin(final String value) {
        nnfFin = value;
    }

    public String getDhRecbto() {
        return dhRecbto;
    }

    public void setDhRecbto(final String string) {
        dhRecbto = string;
    }

    public String getNProt() {
        return nProt;
    }

    public void setNProt(final String value) {
        nProt = value;
    }

    public String getId() {
        return id;
    }

    public void setId(final String value) {
        id = value;
    }

}