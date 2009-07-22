/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import net.vidageek.fluid.annotations.FluidName;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COFINS ", propOrder = { "cofinsAliq", "cofinsQtde", "cofinsnt", "cofinsOutr" })
@FluidName("COFINS")
public class COFINS {

    @XmlElement(name = "COFINSAliq")
    @FluidName("tributacaoPelaAliquota")
    protected COFINSAliq cofinsAliq;

    @XmlElement(name = "COFINSQtde")
    @FluidName("tributacaoPelaQuantidade")
    protected COFINSQtde cofinsQtde;

    @XmlElement(name = "COFINSNT")
    @FluidName("naoTributado")
    protected COFINSNT cofinsnt;

    @XmlElement(name = "COFINSOutr")
    @FluidName("tributacaoDeOutrasOperacoes")
    protected COFINSOutr cofinsOutr;

    public COFINSAliq getCOFINSAliq() {
        return cofinsAliq;
    }

    public void setCOFINSAliq(final COFINSAliq value) {
        cofinsAliq = value;
    }

    public COFINSQtde getCOFINSQtde() {
        return cofinsQtde;
    }

    public void setCOFINSQtde(final COFINSQtde value) {
        cofinsQtde = value;
    }

    public COFINSNT getCOFINSNT() {
        return cofinsnt;
    }

    public void setCOFINSNT(final COFINSNT value) {
        cofinsnt = value;
    }

    public COFINSOutr getCOFINSOutr() {
        return cofinsOutr;
    }

    public void setCOFINSOutr(final COFINSOutr value) {
        cofinsOutr = value;
    }

}