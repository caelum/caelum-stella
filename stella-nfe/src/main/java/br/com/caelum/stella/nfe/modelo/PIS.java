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
@XmlType(name = "PIS ", propOrder = { "pisAliq", "pisQtde", "pisnt", "pisOutr" })
@FluidName("PIS")
public class PIS {

    @XmlElement(name = "PISAliq")
    @FluidName("PISTributadoPelaAliquota")
    protected PISAliq pisAliq;

    @XmlElement(name = "PISQtde")
    @FluidName("PISTributadoPorQuantidade")
    protected PISQtde pisQtde;

    @XmlElement(name = "PISNT")
    @FluidName("PISNaoTributado")
    protected PISNT pisnt;

    @XmlElement(name = "PISOutr")
    @FluidName("PISOutrasOperacoes")
    protected PISOutr pisOutr;

    public PISAliq getPISAliq() {
        return pisAliq;
    }

    public void setPISAliq(final PISAliq value) {
        pisAliq = value;
    }

    public PISQtde getPISQtde() {
        return pisQtde;
    }

    public void setPISQtde(final PISQtde value) {
        pisQtde = value;
    }

    public PISNT getPISNT() {
        return pisnt;
    }

    public void setPISNT(final PISNT value) {
        pisnt = value;
    }

    public PISOutr getPISOutr() {
        return pisOutr;
    }

    public void setPISOutr(final PISOutr value) {
        pisOutr = value;
    }

}