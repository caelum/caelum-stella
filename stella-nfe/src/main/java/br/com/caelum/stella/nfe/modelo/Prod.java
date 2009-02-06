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
@XmlType(name = "Prod ", propOrder = { "cProd", "cean", "xProd", "ncm", "extipi", "genero", "cfop", "uCom", "qCom",
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

    public void setCProd(final String value) {
        cProd = value;
    }

    public String getCEAN() {
        return cean;
    }

    public void setCEAN(final String value) {
        cean = value;
    }

    public String getXProd() {
        return xProd;
    }

    public void setXProd(final String value) {
        xProd = value;
    }

    public String getNCM() {
        return ncm;
    }

    public void setNCM(final String value) {
        ncm = value;
    }

    public String getEXTIPI() {
        return extipi;
    }

    public void setEXTIPI(final String value) {
        extipi = value;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(final String value) {
        genero = value;
    }

    public String getCFOP() {
        return cfop;
    }

    public void setCFOP(final String value) {
        cfop = value;
    }

    public String getUCom() {
        return uCom;
    }

    public void setUCom(final String value) {
        uCom = value;
    }

    public String getQCom() {
        return qCom;
    }

    public void setQCom(final String value) {
        qCom = value;
    }

    public String getVUnCom() {
        return vUnCom;
    }

    public void setVUnCom(final String value) {
        vUnCom = value;
    }

    public String getVProd() {
        return vProd;
    }

    public void setVProd(final String value) {
        vProd = value;
    }

    public String getCEANTrib() {
        return ceanTrib;
    }

    public void setCEANTrib(final String value) {
        ceanTrib = value;
    }

    public String getUTrib() {
        return uTrib;
    }

    public void setUTrib(final String value) {
        uTrib = value;
    }

    public String getQTrib() {
        return qTrib;
    }

    public void setQTrib(final String value) {
        qTrib = value;
    }

    public String getVUnTrib() {
        return vUnTrib;
    }

    public void setVUnTrib(final String value) {
        vUnTrib = value;
    }

    public String getVFrete() {
        return vFrete;
    }

    public void setVFrete(final String value) {
        vFrete = value;
    }

    public String getVSeg() {
        return vSeg;
    }

    public void setVSeg(final String value) {
        vSeg = value;
    }

    public String getVDesc() {
        return vDesc;
    }

    public void setVDesc(final String value) {
        vDesc = value;
    }

    public List<DI> getDI() {
        if (di == null) {
            di = new ArrayList<DI>();
        }
        return di;
    }

    public VeicProd getVeicProd() {
        return veicProd;
    }

    public void setVeicProd(final VeicProd value) {
        veicProd = value;
    }

    public List<Med> getMed() {
        if (med == null) {
            med = new ArrayList<Med>();
        }
        return med;
    }

    public List<Arma> getArma() {
        if (arma == null) {
            arma = new ArrayList<Arma>();
        }
        return arma;
    }

    public Comb getComb() {
        return comb;
    }

    public void setComb(final Comb value) {
        comb = value;
    }

    public void setDI(final List<DI> di) {
        this.di = di;
    }

    public void setMed(final List<Med> meds) {
        med = meds;
    }

    public void setArma(final List<Arma> armas) {
        arma = armas;
    }

}