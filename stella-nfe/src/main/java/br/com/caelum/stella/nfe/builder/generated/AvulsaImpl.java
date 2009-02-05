package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

import br.com.caelum.stella.nfe.modelo.TUf;

public final class AvulsaImpl implements Avulsa, br.com.caelum.stella.nfe.ObjectCreator {

    private static final CalendarToStringConverter CONVERTER = new CalendarToStringConverter();
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
        // TODO : this.avulsa.setDEmi(CONVERTER.convertDateToString(calendar));
        return this;
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
        // TODO : this.avulsa.setDPag(CONVERTER.convertDateToString(calendar));
        return this;
    }
}