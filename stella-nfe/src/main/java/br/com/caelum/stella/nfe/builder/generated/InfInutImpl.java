package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

public final class InfInutImpl<T> implements InfInut<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.InfInut infInut;
    private final T parent;

    public InfInutImpl(final T parent) {
        this.parent = parent;
        infInut = new br.com.caelum.stella.nfe.modelo.InfInut();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) infInut;
    }

    public InfInut<T> withTpAmb(final String string) {
        infInut.setTpAmb(string);
        return this;
    }

    public InfInut<T> withVerAplic(final String string) {
        infInut.setVerAplic(string);
        return this;
    }

    public InfInut<T> withCStat(final String string) {
        infInut.setCStat(string);
        return this;
    }

    public InfInut<T> withXMotivo(final String string) {
        infInut.setXMotivo(string);
        return this;
    }

    public InfInut<T> withCUF(final String string) {
        infInut.setCUF(string);
        return this;
    }

    public InfInut<T> withAno(final String string) {
        infInut.setAno(string);
        return this;
    }

    public InfInut<T> withCNPJ(final String string) {
        infInut.setCNPJ(string);
        return this;
    }

    public InfInut<T> withMod(final String string) {
        infInut.setMod(string);
        return this;
    }

    public InfInut<T> withSerie(final String string) {
        infInut.setSerie(string);
        return this;
    }

    public InfInut<T> withNNFIni(final String string) {
        infInut.setNNFIni(string);
        return this;
    }

    public InfInut<T> withNNFFin(final String string) {
        infInut.setNNFFin(string);
        return this;
    }

    public InfInut<T> withDhRecbto(final Calendar calendar) {
        infInut.setDhRecbto(calendar.toString());
        return this;
    }

    public InfInut<T> withNProt(final String string) {
        infInut.setNProt(string);
        return this;
    }

    public InfInut<T> withId(final String string) {
        infInut.setId(string);
        return this;
    }
}