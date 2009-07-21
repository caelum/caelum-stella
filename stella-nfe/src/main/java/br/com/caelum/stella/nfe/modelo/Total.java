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
@XmlType(name = "Total ", propOrder = { "icmsTot", "issqNtot", "retTrib" })
@FluidName("TotalNFE")
public class Total {

    @XmlElement(name = "ICMSTot", required = true)
    @FluidName("ICMSTotal")
    protected ICMSTot icmsTot;

    @XmlElement(name = "ISSQNtot")
    @FluidName("ISSQNTotal")
    protected ISSQNtot issqNtot;

    @FluidName("retencaoDeTributosFederais")
    protected RetTrib retTrib;

    public ICMSTot getICMSTot() {
        return icmsTot;
    }

    public void setICMSTot(final ICMSTot value) {
        icmsTot = value;
    }

    public ISSQNtot getISSQNtot() {
        return issqNtot;
    }

    public void setISSQNtot(final ISSQNtot value) {
        issqNtot = value;
    }

    public RetTrib getRetTrib() {
        return retTrib;
    }

    public void setRetTrib(final RetTrib value) {
        retTrib = value;
    }

}