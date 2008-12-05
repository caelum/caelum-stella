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
@XmlType(name = "Adi ", propOrder = { "nAdicao", "nSeqAdic", "cFabricante", "vDescDI" })
public class Adi {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String nAdicao;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String nSeqAdic;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cFabricante;
    protected String vDescDI;

    public String getNAdicao() {
        return nAdicao;
    }

    public void setNAdicao(String value) {
        this.nAdicao = value;
    }

    public String getNSeqAdic() {
        return nSeqAdic;
    }

    public void setNSeqAdic(String value) {
        this.nSeqAdic = value;
    }

    public String getCFabricante() {
        return cFabricante;
    }

    public void setCFabricante(String value) {
        this.cFabricante = value;
    }

    public String getVDescDI() {
        return vDescDI;
    }

    public void setVDescDI(String value) {
        this.vDescDI = value;
    }

}