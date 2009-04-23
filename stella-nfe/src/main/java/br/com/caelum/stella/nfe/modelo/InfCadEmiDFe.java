package br.com.caelum.stella.nfe.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

final @XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "dPubCad", "emissor" })
public class InfCadEmiDFe {

    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    @XmlSchemaType(name = "date")
    protected String dPubCad;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    protected List<TEmissor> emissor;
    @XmlAttribute(name = "Id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    public String getDPubCad() {
        return dPubCad;
    }

    public void setDPubCad(final String string) {
        dPubCad = string;
    }

    public List<TEmissor> getEmissor() {
        if (emissor == null) {
            emissor = new ArrayList<TEmissor>();
        }
        return emissor;
    }

    public String getId() {
        return id;
    }

    public void setId(final String value) {
        id = value;
    }

    public void setEmissor(final List<TEmissor> list) {
        emissor = list;
    }

}