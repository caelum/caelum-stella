package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import br.com.caelum.stella.nfe.modelo.TUf;

public final class AvulsaImpl implements Avulsa, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Avulsa avulsa;

    public AvulsaImpl() {
        this.avulsa = new br.com.caelum.stella.nfe.modelo.Avulsa();
    }

    public br.com.caelum.stella.nfe.modelo.Avulsa getInstance() {
        return this.avulsa;
    }

    public Avulsa withCNPJ(String string) {
        this.avulsa.setCNPJ(string);
        return this;
    }

    public Avulsa withXOrgao(String string) {
        this.avulsa.setXOrgao(string);
        return this;
    }

    public Avulsa withMatr(String string) {
        this.avulsa.setMatr(string);
        return this;
    }

    public Avulsa withXAgente(String string) {
        this.avulsa.setXAgente(string);
        return this;
    }

    public Avulsa withFone(String string) {
        this.avulsa.setFone(string);
        return this;
    }

    public Avulsa withUF(TUf tUf) {
        this.avulsa.setUF(tUf);
        return this;
    }

    public Avulsa withNDAR(String string) {
        this.avulsa.setNDAR(string);
        return this;
    }

    public Avulsa withDEmi(Calendar calendar) {
        this.avulsa.setDEmi(toXMLGregorianCalendar(calendar));
        return this;
    }

    private XMLGregorianCalendar toXMLGregorianCalendar(Calendar calendar) {
        try {
            // TODO: return
            // String lexicalRepresentation = calendar.toString();
            // DatatypeFactory.newInstance().newXMLGregorianCalendar(lexicalRepresentation);
            return DatatypeFactory.newInstance().newXMLGregorianCalendar();
        } catch (DatatypeConfigurationException e) {
            throw new IllegalStateException(e);
        }
    }

    public Avulsa withVDAR(String string) {
        this.avulsa.setVDAR(string);
        return this;
    }

    public Avulsa withRepEmi(String string) {
        this.avulsa.setRepEmi(string);
        return this;
    }

    public Avulsa withDPag(Calendar calendar) {
        this.avulsa.setDPag(toXMLGregorianCalendar(calendar));
        return this;
    }
}