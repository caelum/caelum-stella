package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

public final class InfProtImpl implements InfProt, br.com.caelum.stella.nfe.ObjectCreator {

    private final br.com.caelum.stella.nfe.modelo.InfProt infProt;

    public InfProtImpl() {
        infProt = new br.com.caelum.stella.nfe.modelo.InfProt();
    }

    public br.com.caelum.stella.nfe.modelo.InfProt getInstance() {
        return infProt;
    }

    public InfProt withTpAmb(final String string) {
        infProt.setTpAmb(string);
        return this;
    }

    public InfProt withVerAplic(final String string) {
        infProt.setVerAplic(string);
        return this;
    }

    public InfProt withChNFe(final String string) {
        infProt.setChNFe(string);
        return this;
    }

    public InfProt withDhRecbto(final Calendar calendar) {
        infProt.setDhRecbto(calendar);
        return this;
    }

    public InfProt withNProt(final String string) {
        infProt.setNProt(string);
        return this;
    }

    public InfProt withDigVal(final byte[] b) {
        infProt.setDigVal(b);
        return this;
    }

    public InfProt withCStat(final String string) {
        infProt.setCStat(string);
        return this;
    }

    public InfProt withXMotivo(final String string) {
        infProt.setXMotivo(string);
        return this;
    }

    public InfProt withId(final String string) {
        infProt.setId(string);
        return this;
    }

}