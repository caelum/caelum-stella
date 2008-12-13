/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ide ", propOrder = { "cuf", "cnf", "natOp", "indPag", "mod", "serie", "nnf", "dEmi", "dSaiEnt",
        "tpNF", "cMunFG", "nFref", "tpImp", "tpEmis", "cdv", "tpAmb", "finNFe", "procEmi", "verProc" })
public class Ide {

    @XmlElement(name = "cUF", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cuf;

    @XmlElement(name = "cNF", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cnf;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String natOp;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String indPag;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String mod;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String serie;

    @XmlElement(name = "nNF", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String nnf;

    @XmlElement(required = true)
    protected XMLGregorianCalendar dEmi;

    protected XMLGregorianCalendar dSaiEnt;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String tpNF;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cMunFG;

    @XmlElement(name = "NFref")
    protected List<NFref> nFref;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String tpImp;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String tpEmis;

    @XmlElement(name = "cDV", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cdv;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String tpAmb;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String finNFe;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String procEmi;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String verProc;

    public String getCUF() {
        return cuf;
    }

    public void setCUF(String value) {
        this.cuf = value;
    }

    public String getCNF() {
        return cnf;
    }

    public void setCNF(String value) {
        this.cnf = value;
    }

    public String getNatOp() {
        return natOp;
    }

    public void setNatOp(String value) {
        this.natOp = value;
    }

    public String getIndPag() {
        return indPag;
    }

    public void setIndPag(String value) {
        this.indPag = value;
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

    public XMLGregorianCalendar getDEmi() {
        return dEmi;
    }

    public void setDEmi(XMLGregorianCalendar value) {
        this.dEmi = value;
    }

    public XMLGregorianCalendar getDSaiEnt() {
        return dSaiEnt;
    }

    public void setDSaiEnt(XMLGregorianCalendar value) {
        this.dSaiEnt = value;
    }

    public String getTpNF() {
        return tpNF;
    }

    public void setTpNF(String value) {
        this.tpNF = value;
    }

    public String getCMunFG() {
        return cMunFG;
    }

    public void setCMunFG(String value) {
        this.cMunFG = value;
    }

    public List<NFref> getNFref() {
        if (nFref == null) {
            nFref = new ArrayList<NFref>();
        }
        return this.nFref;
    }

    public String getTpImp() {
        return tpImp;
    }

    public void setTpImp(String value) {
        this.tpImp = value;
    }

    public String getTpEmis() {
        return tpEmis;
    }

    public void setTpEmis(String value) {
        this.tpEmis = value;
    }

    public String getCDV() {
        return cdv;
    }

    public void setCDV(String value) {
        this.cdv = value;
    }

    public String getTpAmb() {
        return tpAmb;
    }

    public void setTpAmb(String value) {
        this.tpAmb = value;
    }

    public String getFinNFe() {
        return finNFe;
    }

    public void setFinNFe(String value) {
        this.finNFe = value;
    }

    public String getProcEmi() {
        return procEmi;
    }

    public void setProcEmi(String value) {
        this.procEmi = value;
    }

    public String getVerProc() {
        return verProc;
    }

    public void setVerProc(String value) {
        this.verProc = value;
    }

}