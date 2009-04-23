package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

public final class TRetConsStatServImpl implements TRetConsStatServ, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TRetConsStatServ tRetConsStatServ;

    public TRetConsStatServImpl() {
        tRetConsStatServ = new br.com.caelum.stella.nfe.modelo.TRetConsStatServ();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.tRetConsStatServ;
    }

    public TRetConsStatServ withTpAmb(final String string) {
        tRetConsStatServ.setTpAmb(string);
        return this;
    }

    public TRetConsStatServ withVerAplic(final String string) {
        tRetConsStatServ.setVerAplic(string);
        return this;
    }

    public TRetConsStatServ withCStat(final String string) {
        tRetConsStatServ.setCStat(string);
        return this;
    }

    public TRetConsStatServ withXMotivo(final String string) {
        tRetConsStatServ.setXMotivo(string);
        return this;
    }

    public TRetConsStatServ withCUF(final String string) {
        tRetConsStatServ.setCUF(string);
        return this;
    }

    public TRetConsStatServ withDhRecbto(final Calendar calendar) {
        tRetConsStatServ.setDhRecbto(calendar.toString());
        return this;
    }

    public TRetConsStatServ withTMed(final String string) {
        tRetConsStatServ.setTMed(string);
        return this;
    }

    public TRetConsStatServ withDhRetorno(final Calendar calendar) {
        tRetConsStatServ.setDhRetorno(calendar.toString());
        return this;
    }

    public TRetConsStatServ withXObs(final String string) {
        tRetConsStatServ.setXObs(string);
        return this;
    }

    public TRetConsStatServ withVersao(final String string) {
        tRetConsStatServ.setVersao(string);
        return this;
    }
}