package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

public final class TRetConsStatServImpl<T> implements TRetConsStatServ<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TRetConsStatServ tRetConsStatServ;
    private final T parent;

    public TRetConsStatServImpl(final T parent) {
        this.parent = parent;
        tRetConsStatServ = new br.com.caelum.stella.nfe.modelo.TRetConsStatServ();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.tRetConsStatServ;
    }

    public TRetConsStatServ<T> withTpAmb(final String string) {
        tRetConsStatServ.setTpAmb(string);
        return this;
    }

    public TRetConsStatServ<T> withVerAplic(final String string) {
        tRetConsStatServ.setVerAplic(string);
        return this;
    }

    public TRetConsStatServ<T> withCStat(final String string) {
        tRetConsStatServ.setCStat(string);
        return this;
    }

    public TRetConsStatServ<T> withXMotivo(final String string) {
        tRetConsStatServ.setXMotivo(string);
        return this;
    }

    public TRetConsStatServ<T> withCUF(final String string) {
        tRetConsStatServ.setCUF(string);
        return this;
    }

    public TRetConsStatServ<T> withDhRecbto(final Calendar calendar) {
        tRetConsStatServ.setDhRecbto(calendar.toString());
        return this;
    }

    public TRetConsStatServ<T> withTMed(final String string) {
        tRetConsStatServ.setTMed(string);
        return this;
    }

    public TRetConsStatServ<T> withDhRetorno(final Calendar calendar) {
        tRetConsStatServ.setDhRetorno(calendar.toString());
        return this;
    }

    public TRetConsStatServ<T> withXObs(final String string) {
        tRetConsStatServ.setXObs(string);
        return this;
    }

    public TRetConsStatServ<T> withVersao(final String string) {
        tRetConsStatServ.setVersao(string);
        return this;
    }
}