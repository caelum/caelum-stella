package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import net.vidageek.fluid.annotations.FluidDataType;
import br.com.caelum.stella.tinytype.CNPJ;

final @XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "uf", "cnpj", "ope", "resOpe" })
public class InfRetAtuCadEmiDFe {

    @XmlElement(name = "UF", namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    protected TUf uf;
    @XmlElement(name = "CNPJ", namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    @FluidDataType(CNPJ.class)
    protected Object cnpj;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String ope;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String resOpe;
    @XmlAttribute(name = "Id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    public TUf getUF() {
        return uf;
    }

    public void setUF(final TUf value) {
        uf = value;
    }

    public Object getCNPJ() {
        return cnpj;
    }

    public void setCNPJ(final Object value) {
        cnpj = value;
    }

    public String getOpe() {
        return ope;
    }

    public void setOpe(final String value) {
        ope = value;
    }

    public String getResOpe() {
        return resOpe;
    }

    public void setResOpe(final String value) {
        resOpe = value;
    }

    public String getId() {
        return id;
    }

    public void setId(final String value) {
        id = value;
    }

}