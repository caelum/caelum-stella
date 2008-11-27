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
@XmlType(name = "", propOrder = { "clEnq", "cnpjProd", "cSelo", "qSelo", "cEnq", "ipiTrib", "ipint" })
public class IPI {

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String clEnq;
    @XmlElement(name = "CNPJProd")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cnpjProd;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cSelo;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String qSelo;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cEnq;
    @XmlElement(name = "IPITrib")
    protected IPITrib ipiTrib;
    @XmlElement(name = "IPINT")
    protected IPINT ipint;

    public String getClEnq() {
        return clEnq;
    }

    public void setClEnq(String value) {
        this.clEnq = value;
    }

    public String getCNPJProd() {
        return cnpjProd;
    }

    public void setCNPJProd(String value) {
        this.cnpjProd = value;
    }

    public String getCSelo() {
        return cSelo;
    }

    public void setCSelo(String value) {
        this.cSelo = value;
    }

    public String getQSelo() {
        return qSelo;
    }

    public void setQSelo(String value) {
        this.qSelo = value;
    }

    public String getCEnq() {
        return cEnq;
    }

    public void setCEnq(String value) {
        this.cEnq = value;
    }

    public IPITrib getIPITrib() {
        return ipiTrib;
    }

    public void setIPITrib(IPITrib value) {
        this.ipiTrib = value;
    }

    public IPINT getIPINT() {
        return ipint;
    }

    public void setIPINT(IPINT value) {
        this.ipint = value;
    }

}