/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "vbc", "vicms", "vbcst", "vst", "vProd", "vFrete", "vSeg", "vDesc", "vii", "vipi",
        "vpis", "vcofins", "vOutro", "vnf" })
public class ICMSTot {

    @XmlElement(name = "vBC", required = true)
    protected String vbc;
    @XmlElement(name = "vICMS", required = true)
    protected String vicms;
    @XmlElement(name = "vBCST", required = true)
    protected String vbcst;
    @XmlElement(name = "vST", required = true)
    protected String vst;
    @XmlElement(required = true)
    protected String vProd;
    @XmlElement(required = true)
    protected String vFrete;
    @XmlElement(required = true)
    protected String vSeg;
    @XmlElement(required = true)
    protected String vDesc;
    @XmlElement(name = "vII", required = true)
    protected String vii;
    @XmlElement(name = "vIPI", required = true)
    protected String vipi;
    @XmlElement(name = "vPIS", required = true)
    protected String vpis;
    @XmlElement(name = "vCOFINS", required = true)
    protected String vcofins;
    @XmlElement(required = true)
    protected String vOutro;
    @XmlElement(name = "vNF", required = true)
    protected String vnf;

    public String getVBC() {
        return vbc;
    }

    public void setVBC(String value) {
        this.vbc = value;
    }

    public String getVICMS() {
        return vicms;
    }

    public void setVICMS(String value) {
        this.vicms = value;
    }

    public String getVBCST() {
        return vbcst;
    }

    public void setVBCST(String value) {
        this.vbcst = value;
    }

    public String getVST() {
        return vst;
    }

    public void setVST(String value) {
        this.vst = value;
    }

    public String getVProd() {
        return vProd;
    }

    public void setVProd(String value) {
        this.vProd = value;
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

    public String getVII() {
        return vii;
    }

    public void setVII(String value) {
        this.vii = value;
    }

    public String getVIPI() {
        return vipi;
    }

    public void setVIPI(String value) {
        this.vipi = value;
    }

    public String getVPIS() {
        return vpis;
    }

    public void setVPIS(String value) {
        this.vpis = value;
    }

    public String getVCOFINS() {
        return vcofins;
    }

    public void setVCOFINS(String value) {
        this.vcofins = value;
    }

    public String getVOutro() {
        return vOutro;
    }

    public void setVOutro(String value) {
        this.vOutro = value;
    }

    public String getVNF() {
        return vnf;
    }

    public void setVNF(String value) {
        this.vnf = value;
    }

}