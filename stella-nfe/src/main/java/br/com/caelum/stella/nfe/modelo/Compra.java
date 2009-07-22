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
@XmlType(name = "Compra ", propOrder = { "xnEmp", "xPed", "xCont" })
@FluidName("Compra")
public class Compra {

    @XmlElement(name = "xNEmp")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("informacoesDaNotaDeEmpenhoDeComprasPublicas")
    protected String xnEmp;

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("informacaoDoPedido")
    protected String xPed;

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("informacaoDoContrato")
    protected String xCont;

    public String getXNEmp() {
        return xnEmp;
    }

    public void setXNEmp(final String value) {
        xnEmp = value;
    }

    public String getXPed() {
        return xPed;
    }

    public void setXPed(final String value) {
        xPed = value;
    }

    public String getXCont() {
        return xCont;
    }

    public void setXCont(final String value) {
        xCont = value;
    }

}