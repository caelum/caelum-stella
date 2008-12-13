/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NFref ", propOrder = { "refNFe", "refNF" })
public class NFref {

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String refNFe;

    protected RefNF refNF;

    public String getRefNFe() {
        return refNFe;
    }

    public void setRefNFe(String value) {
        this.refNFe = value;
    }

    public RefNF getRefNF() {
        return refNF;
    }

    public void setRefNF(RefNF value) {
        this.refNF = value;
    }

}