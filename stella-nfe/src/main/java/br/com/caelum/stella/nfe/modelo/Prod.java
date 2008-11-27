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

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "cProd", "cean", "xProd", "ncm", "extipi", "genero", "cfop", "uCom", "qCom",
        "vUnCom", "vProd", "ceanTrib", "uTrib", "qTrib", "vUnTrib", "vFrete", "vSeg", "vDesc", "di", "veicProd", "med",
        "arma", "comb" })
public class Prod {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cProd;
    @XmlElement(name = "cEAN", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cean;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String xProd;
    @XmlElement(name = "NCM")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String ncm;
    @XmlElement(name = "EXTIPI")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String extipi;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String genero;
    @XmlElement(name = "CFOP", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cfop;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String uCom;
    @XmlElement(required = true)
    protected String qCom;
    @XmlElement(required = true)
    protected String vUnCom;
    @XmlElement(required = true)
    protected String vProd;
    @XmlElement(name = "cEANTrib", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String ceanTrib;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String uTrib;
    @XmlElement(required = true)
    protected String qTrib;
    @XmlElement(required = true)
    protected String vUnTrib;
    protected String vFrete;
    protected String vSeg;
    protected String vDesc;
    @XmlElement(name = "DI")
    protected List<DI> di;
    protected VeicProd veicProd;
    protected List<Med> med;
    protected List<Arma> arma;
    protected Comb comb;

    public String getCProd() {
        return cProd;
    }

    public void setCProd(String value) {
        this.cProd = value;
    }

    public String getCEAN() {
        return cean;
    }

    public void setCEAN(String value) {
        this.cean = value;
    }

    public String getXProd() {
        return xProd;
    }

    public void setXProd(String value) {
        this.xProd = value;
    }

    public String getNCM() {
        return ncm;
    }

    public void setNCM(String value) {
        this.ncm = value;
    }

    public String getEXTIPI() {
        return extipi;
    }

    public void setEXTIPI(String value) {
        this.extipi = value;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String value) {
        this.genero = value;
    }

    public String getCFOP() {
        return cfop;
    }

    public void setCFOP(String value) {
        this.cfop = value;
    }

    public String getUCom() {
        return uCom;
    }

    public void setUCom(String value) {
        this.uCom = value;
    }

    public String getQCom() {
        return qCom;
    }

    public void setQCom(String value) {
        this.qCom = value;
    }

    public String getVUnCom() {
        return vUnCom;
    }

    public void setVUnCom(String value) {
        this.vUnCom = value;
    }

    public String getVProd() {
        return vProd;
    }

    public void setVProd(String value) {
        this.vProd = value;
    }

    public String getCEANTrib() {
        return ceanTrib;
    }

    public void setCEANTrib(String value) {
        this.ceanTrib = value;
    }

    public String getUTrib() {
        return uTrib;
    }

    public void setUTrib(String value) {
        this.uTrib = value;
    }

    public String getQTrib() {
        return qTrib;
    }

    public void setQTrib(String value) {
        this.qTrib = value;
    }

    public String getVUnTrib() {
        return vUnTrib;
    }

    public void setVUnTrib(String value) {
        this.vUnTrib = value;
    }

    public String getVFrete() {
        return vFrete;
    }

    public void setVFrete(String value) {
        this.vFrete = value;
    }

    public String getVSeg() {
        return vSeg;
    }

    public void setVSeg(String value) {
        this.vSeg = value;
    }

    public String getVDesc() {
        return vDesc;
    }

    public void setVDesc(String value) {
        this.vDesc = value;
    }

    public List<DI> getDI() {
        if (di == null) {
            di = new ArrayList<DI>();
        }
        return this.di;
    }

    public VeicProd getVeicProd() {
        return veicProd;
    }

    public void setVeicProd(VeicProd value) {
        this.veicProd = value;
    }

    public List<Med> getMed() {
        if (med == null) {
            med = new ArrayList<Med>();
        }
        return this.med;
    }

    public List<Arma> getArma() {
        if (arma == null) {
            arma = new ArrayList<Arma>();
        }
        return this.arma;
    }

    public Comb getComb() {
        return comb;
    }

    public void setComb(Comb value) {
        this.comb = value;
    }

}