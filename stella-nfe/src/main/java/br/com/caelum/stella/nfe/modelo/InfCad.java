/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

final @XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "ie", "cnpj", "cpf", "uf", "cSit", "xNome", "xFant", "xRegApur", "cnae", "dIniAtiv",
        "dUltSit", "dBaixa", "ieUnica", "ieAtual", "ender" })
public class InfCad {

    @XmlElement(name = "IE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String ie;
    @XmlElement(name = "CNPJ")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cnpj;
    @XmlElement(name = "CPF")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cpf;
    @XmlElement(name = "UF", required = true)
    protected TUf uf;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cSit;
    @XmlElement(required = true)
    protected String xNome;
    protected String xFant;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String xRegApur;
    @XmlElement(name = "CNAE")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cnae;
    @XmlSchemaType(name = "date")
    protected String dIniAtiv;
    @XmlSchemaType(name = "date")
    protected String dUltSit;
    @XmlSchemaType(name = "date")
    protected String dBaixa;
    @XmlElement(name = "IEUnica")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String ieUnica;
    @XmlElement(name = "IEAtual")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String ieAtual;
    protected TEndereco ender;

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

    public TUf getUF() {
        return uf;
    }

    public void setUF(final TUf value) {
        uf = value;
    }

    public String getCSit() {
        return cSit;
    }

    public void setCSit(final String value) {
        cSit = value;
    }

    public String getXNome() {
        return xNome;
    }

    public void setXNome(final String value) {
        xNome = value;
    }

    public String getXFant() {
        return xFant;
    }

    public void setXFant(final String value) {
        xFant = value;
    }

    public String getXRegApur() {
        return xRegApur;
    }

    public void setXRegApur(final String value) {
        xRegApur = value;
    }

    public String getCNAE() {
        return cnae;
    }

    public void setCNAE(final String value) {
        cnae = value;
    }

    public String getDIniAtiv() {
        return dIniAtiv;
    }

    public void setDIniAtiv(final String string) {
        dIniAtiv = string;
    }

    public String getDUltSit() {
        return dUltSit;
    }

    public void setDUltSit(final String string) {
        dUltSit = string;
    }

    public String getDBaixa() {
        return dBaixa;
    }

    public void setDBaixa(final String string) {
        dBaixa = string;
    }

    public String getIEUnica() {
        return ieUnica;
    }

    public void setIEUnica(final String value) {
        ieUnica = value;
    }

    public String getIEAtual() {
        return ieAtual;
    }

    public void setIEAtual(final String value) {
        ieAtual = value;
    }

    public TEndereco getEnder() {
        return ender;
    }

    public void setEnder(final TEndereco value) {
        ender = value;
    }

}