/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import net.vidageek.fluid.annotations.FluidName;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Det ", propOrder = { "prod", "imposto", "infAdProd" })
@FluidName("Detalhe")
public class Det {

    @XmlElement(required = true)
    @FluidName("produto")
    protected Prod prod;

    @XmlElement(required = true)
    @FluidName("imposto")
    protected Imposto imposto;

    @FluidName("informacaoAdicionalDoProduto")
    protected String infAdProd;

    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("numeroDoItemNaNF")
    protected String nItem;

    public Prod getProd() {
        return prod;
    }

    public void setProd(final Prod value) {
        prod = value;
    }

    public Imposto getImposto() {
        return imposto;
    }

    public void setImposto(final Imposto value) {
        imposto = value;
    }

    public String getInfAdProd() {
        return infAdProd;
    }

    public void setInfAdProd(final String value) {
        infAdProd = value;
    }

    public String getNItem() {
        return nItem;
    }

    public void setNItem(final String value) {
        nItem = value;
    }

}