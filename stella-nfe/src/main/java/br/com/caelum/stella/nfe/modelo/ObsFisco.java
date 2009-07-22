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
@XmlType(name = "ObsFisco ", propOrder = { "xTexto" })
@FluidName("ObservacaoFisco")
public class ObsFisco {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("descricaoDoTexto")
    protected String xTexto;

    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("descricaoDoCampo")
    protected String xCampo;

    public String getXTexto() {
        return xTexto;
    }

    public void setXTexto(final String value) {
        xTexto = value;
    }

    public String getXCampo() {
        return xCampo;
    }

    public void setXCampo(final String value) {
        xCampo = value;
    }

}