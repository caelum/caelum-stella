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

import net.vidageek.fluid.annotations.FluidName;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VeicProd ", propOrder = { "tpOp", "chassi", "cCor", "xCor", "pot", "cm3", "pesoL", "pesoB", "nSerie",
        "tpComb", "nMotor", "cmkg", "dist", "renavam", "anoMod", "anoFab", "tpPint", "tpVeic", "espVeic", "vin",
        "condVeic", "cMod" })
@FluidName("VeiculoNovo")
public class VeicProd {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("tipoDeOperacao")
    protected String tpOp;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("chassi")
    protected String chassi;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("codigoDaCor")
    protected String cCor;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("descricaoDaCor")
    protected String xCor;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("potenciaDoMotor")
    protected String pot;

    @XmlElement(name = "CM3", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("CM3")
    protected String cm3;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("pesoLiquido")
    protected String pesoL;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("pesoBruto")
    protected String pesoB;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("numeroDeSerie")
    protected String nSerie;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("tipoDeCombustivel")
    protected String tpComb;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("numeroDoMotor")
    protected String nMotor;

    @XmlElement(name = "CMKG", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("CMKG")
    protected String cmkg;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("distanciaEntreEixos")
    protected String dist;

    @XmlElement(name = "RENAVAM")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("RENAVAM")
    protected String renavam;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("anoDoModelo")
    protected String anoMod;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("anoDeFabricacao")
    protected String anoFab;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("tipoDePintura")
    protected String tpPint;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("tipoDeVeiculo")
    protected String tpVeic;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("especieDeVeiculo")
    protected String espVeic;

    @XmlElement(name = "VIN", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("vehicleIdentificationNumber")
    protected String vin;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("condicaoDoVeiculo")
    protected String condVeic;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("codigoDaMarcaDoModelo")
    protected String cMod;

    public String getTpOp() {
        return tpOp;
    }

    public void setTpOp(final String value) {
        tpOp = value;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(final String value) {
        chassi = value;
    }

    public String getCCor() {
        return cCor;
    }

    public void setCCor(final String value) {
        cCor = value;
    }

    public String getXCor() {
        return xCor;
    }

    public void setXCor(final String value) {
        xCor = value;
    }

    public String getPot() {
        return pot;
    }

    public void setPot(final String value) {
        pot = value;
    }

    public String getCM3() {
        return cm3;
    }

    public void setCM3(final String value) {
        cm3 = value;
    }

    public String getPesoL() {
        return pesoL;
    }

    public void setPesoL(final String value) {
        pesoL = value;
    }

    public String getPesoB() {
        return pesoB;
    }

    public void setPesoB(final String value) {
        pesoB = value;
    }

    public String getNSerie() {
        return nSerie;
    }

    public void setNSerie(final String value) {
        nSerie = value;
    }

    public String getTpComb() {
        return tpComb;
    }

    public void setTpComb(final String value) {
        tpComb = value;
    }

    public String getNMotor() {
        return nMotor;
    }

    public void setNMotor(final String value) {
        nMotor = value;
    }

    public String getCMKG() {
        return cmkg;
    }

    public void setCMKG(final String value) {
        cmkg = value;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(final String value) {
        dist = value;
    }

    public String getRENAVAM() {
        return renavam;
    }

    public void setRENAVAM(final String value) {
        renavam = value;
    }

    public String getAnoMod() {
        return anoMod;
    }

    public void setAnoMod(final String value) {
        anoMod = value;
    }

    public String getAnoFab() {
        return anoFab;
    }

    public void setAnoFab(final String value) {
        anoFab = value;
    }

    public String getTpPint() {
        return tpPint;
    }

    public void setTpPint(final String value) {
        tpPint = value;
    }

    public String getTpVeic() {
        return tpVeic;
    }

    public void setTpVeic(final String value) {
        tpVeic = value;
    }

    public String getEspVeic() {
        return espVeic;
    }

    public void setEspVeic(final String value) {
        espVeic = value;
    }

    public String getVIN() {
        return vin;
    }

    public void setVIN(final String value) {
        vin = value;
    }

    public String getCondVeic() {
        return condVeic;
    }

    public void setCondVeic(final String value) {
        condVeic = value;
    }

    public String getCMod() {
        return cMod;
    }

    public void setCMod(final String value) {
        cMod = value;
    }

}