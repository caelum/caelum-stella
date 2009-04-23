/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

final @XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "verAplic", "cStat", "xMotivo", "uf", "ie", "cnpj", "cpf", "dhCons", "cuf", "infCad" })
public class InfCons {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String verAplic;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cStat;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String xMotivo;
    @XmlElement(name = "UF", required = true)
    protected TUfCons uf;
    @XmlElement(name = "IE")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String ie;
    @XmlElement(name = "CNPJ")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cnpj;
    @XmlElement(name = "CPF")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cpf;
    @XmlElement(required = true)
    protected String dhCons;
    @XmlElement(name = "cUF", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cuf;
    protected List<InfCad> infCad;

    public String getVerAplic() {
        return verAplic;
    }

    public void setVerAplic(final String value) {
        verAplic = value;
    }

    public String getCStat() {
        return cStat;
    }

    public void setCStat(final String value) {
        cStat = value;
    }

    public String getXMotivo() {
        return xMotivo;
    }

    public void setXMotivo(final String value) {
        xMotivo = value;
    }

    public TUfCons getUF() {
        return uf;
    }

    public void setUF(final TUfCons value) {
        uf = value;
    }

    public String getIE() {
        return ie;
    }

    public void setIE(final String value) {
        ie = value;
    }

    public String getCNPJ() {
        return cnpj;
    }

    public void setCNPJ(final String value) {
        cnpj = value;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(final String value) {
        cpf = value;
    }

    public String getDhCons() {
        return dhCons;
    }

    public void setDhCons(final String string) {
        dhCons = string;
    }

    public String getCUF() {
        return cuf;
    }

    public void setCUF(final String value) {
        cuf = value;
    }

    public List<InfCad> getInfCad() {
        if (infCad == null) {
            infCad = new ArrayList<InfCad>();
        }
        return infCad;
    }

    public void setInfCad(final List<InfCad> list) {
        infCad = list;

    }

}