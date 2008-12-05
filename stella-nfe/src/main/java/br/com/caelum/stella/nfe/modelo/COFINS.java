/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COFINS ", propOrder = { "cofinsAliq", "cofinsQtde", "cofinsnt", "cofinsOutr" })
public class COFINS {

    @XmlElement(name = "COFINSAliq")
    protected COFINSAliq cofinsAliq;
    @XmlElement(name = "COFINSQtde")
    protected COFINSQtde cofinsQtde;
    @XmlElement(name = "COFINSNT")
    protected COFINSNT cofinsnt;
    @XmlElement(name = "COFINSOutr")
    protected COFINSOutr cofinsOutr;

    public COFINSAliq getCOFINSAliq() {
        return cofinsAliq;
    }

    public void setCOFINSAliq(COFINSAliq value) {
        this.cofinsAliq = value;
    }

    public COFINSQtde getCOFINSQtde() {
        return cofinsQtde;
    }

    public void setCOFINSQtde(COFINSQtde value) {
        this.cofinsQtde = value;
    }

    public COFINSNT getCOFINSNT() {
        return cofinsnt;
    }

    public void setCOFINSNT(COFINSNT value) {
        this.cofinsnt = value;
    }

    public COFINSOutr getCOFINSOutr() {
        return cofinsOutr;
    }

    public void setCOFINSOutr(COFINSOutr value) {
        this.cofinsOutr = value;
    }

}