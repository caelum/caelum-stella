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

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IPI ", propOrder = { "clEnq", "cnpjProd", "cSelo", "qSelo", "cEnq", "ipiTrib", "ipint" })
public class IPI {

    @XmlElement(name = "clEnq")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String classeEnquadramento;

    @XmlElement(name = "CNPJProd")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cnpjProdutor;

    @XmlElement(name = "cSelo")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String codigoSelo;

    @XmlElement(name = "qSelo")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String quantidadeSelo;

    @XmlElement(required = true, name="cEnq")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String codigoEnquadramento;

    @XmlElement(name = "IPITrib")
    protected IPITrib ipiTributacao;

    @XmlElement(name = "IPINT")
    protected IPINT ipint;

    public String getClasseEnquadramento() {
        return classeEnquadramento;
    }

    public void setClasseEnquadramento(String classeEnquadramento) {
        this.classeEnquadramento = classeEnquadramento;
    }

    public String getCnpjProdutor() {
        return cnpjProdutor;
    }

    public void setCnpjProdutor(String cnpjProdutor) {
        this.cnpjProdutor = cnpjProdutor;
    }

    public String getCodigoSelo() {
        return codigoSelo;
    }

    public void setCodigoSelo(String codigoSelo) {
        this.codigoSelo = codigoSelo;
    }

    public String getQuantidadeSelo() {
        return quantidadeSelo;
    }

    public void setQuantidadeSelo(String quantidadeSelo) {
        this.quantidadeSelo = quantidadeSelo;
    }

    public String getCodigoEnquadramento() {
        return codigoEnquadramento;
    }

    public void setCodigoEnquadramento(String codigoEnquadramento) {
        this.codigoEnquadramento = codigoEnquadramento;
    }

    public IPITrib getIpiTributacao() {
        return ipiTributacao;
    }

    public void setIpiTributacao(IPITrib ipiTributacao) {
        this.ipiTributacao = ipiTributacao;
    }

    public IPINT getIpint() {
        return ipint;
    }

    public void setIpint(IPINT ipint) {
        this.ipint = ipint;
    }

}