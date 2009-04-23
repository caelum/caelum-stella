package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

public final class InfInutImpl implements InfInut, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.InfInut infInut;

    public InfInutImpl() {
        infInut = new br.com.caelum.stella.nfe.modelo.InfInut();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) infInut;
    }

    public InfInut withTpAmb(final String string) {
        infInut.setTpAmb(string);
        return this;
    }

    public InfInut withVerAplic(final String string) {
        infInut.setVerAplic(string);
        return this;
    }

    public InfInut withCStat(final String string) {
        infInut.setCStat(string);
        return this;
    }

    public InfInut withXMotivo(final String string) {
        infInut.setXMotivo(string);
        return this;
    }

    public InfInut withCUF(final String string) {
        infInut.setCUF(string);
        return this;
    }

    public InfInut withAno(final String string) {
        infInut.setAno(string);
        return this;
    }

    public InfInut withCNPJ(final String string) {
        infInut.setCNPJ(string);
        return this;
    }

    public InfInut withMod(final String string) {
        infInut.setMod(string);
        return this;
    }

    public InfInut withSerie(final String string) {
        infInut.setSerie(string);
        return this;
    }

    public InfInut withNNFIni(final String string) {
        infInut.setNNFIni(string);
        return this;
    }

    public InfInut withNNFFin(final String string) {
        infInut.setNNFFin(string);
        return this;
    }

    public InfInut withDhRecbto(final Calendar calendar) {
        infInut.setDhRecbto(calendar.toString());
        return this;
    }

    public InfInut withNProt(final String string) {
        infInut.setNProt(string);
        return this;
    }

    public InfInut withId(final String string) {
        infInut.setId(string);
        return this;
    }
}