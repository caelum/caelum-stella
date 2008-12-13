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
@XmlType(name = "VeicProd ", propOrder = { "tpOp", "chassi", "cCor", "xCor", "pot", "cm3", "pesoL", "pesoB", "nSerie",
        "tpComb", "nMotor", "cmkg", "dist", "renavam", "anoMod", "anoFab", "tpPint", "tpVeic", "espVeic", "vin",
        "condVeic", "cMod" })
public class VeicProd {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String tpOp;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String chassi;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cCor;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String xCor;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String pot;

    @XmlElement(name = "CM3", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cm3;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String pesoL;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String pesoB;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String nSerie;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String tpComb;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String nMotor;

    @XmlElement(name = "CMKG", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cmkg;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String dist;

    @XmlElement(name = "RENAVAM")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String renavam;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String anoMod;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String anoFab;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String tpPint;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String tpVeic;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String espVeic;

    @XmlElement(name = "VIN", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String vin;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String condVeic;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cMod;

    public String getTpOp() {
        return tpOp;
    }

    public void setTpOp(String value) {
        this.tpOp = value;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String value) {
        this.chassi = value;
    }

    public String getCCor() {
        return cCor;
    }

    public void setCCor(String value) {
        this.cCor = value;
    }

    public String getXCor() {
        return xCor;
    }

    public void setXCor(String value) {
        this.xCor = value;
    }

    public String getPot() {
        return pot;
    }

    public void setPot(String value) {
        this.pot = value;
    }

    public String getCM3() {
        return cm3;
    }

    public void setCM3(String value) {
        this.cm3 = value;
    }

    public String getPesoL() {
        return pesoL;
    }

    public void setPesoL(String value) {
        this.pesoL = value;
    }

    public String getPesoB() {
        return pesoB;
    }

    public void setPesoB(String value) {
        this.pesoB = value;
    }

    public String getNSerie() {
        return nSerie;
    }

    public void setNSerie(String value) {
        this.nSerie = value;
    }

    public String getTpComb() {
        return tpComb;
    }

    public void setTpComb(String value) {
        this.tpComb = value;
    }

    public String getNMotor() {
        return nMotor;
    }

    public void setNMotor(String value) {
        this.nMotor = value;
    }

    public String getCMKG() {
        return cmkg;
    }

    public void setCMKG(String value) {
        this.cmkg = value;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String value) {
        this.dist = value;
    }

    public String getRENAVAM() {
        return renavam;
    }

    public void setRENAVAM(String value) {
        this.renavam = value;
    }

    public String getAnoMod() {
        return anoMod;
    }

    public void setAnoMod(String value) {
        this.anoMod = value;
    }

    public String getAnoFab() {
        return anoFab;
    }

    public void setAnoFab(String value) {
        this.anoFab = value;
    }

    public String getTpPint() {
        return tpPint;
    }

    public void setTpPint(String value) {
        this.tpPint = value;
    }

    public String getTpVeic() {
        return tpVeic;
    }

    public void setTpVeic(String value) {
        this.tpVeic = value;
    }

    public String getEspVeic() {
        return espVeic;
    }

    public void setEspVeic(String value) {
        this.espVeic = value;
    }

    public String getVIN() {
        return vin;
    }

    public void setVIN(String value) {
        this.vin = value;
    }

    public String getCondVeic() {
        return condVeic;
    }

    public void setCondVeic(String value) {
        this.condVeic = value;
    }

    public String getCMod() {
        return cMod;
    }

    public void setCMod(String value) {
        this.cMod = value;
    }

}