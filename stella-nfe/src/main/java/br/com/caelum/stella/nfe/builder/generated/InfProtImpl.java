package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

public final class InfProtImpl implements DadosDoProtocolo, br.com.caelum.stella.nfe.ObjectCreator {

    private final br.com.caelum.stella.nfe.modelo.InfProt infProt;

    public InfProtImpl() {
        infProt = new br.com.caelum.stella.nfe.modelo.InfProt();
    }

    public br.com.caelum.stella.nfe.modelo.InfProt getInstance() {
        return infProt;
    }

    public DadosDoProtocolo withTpAmb(final String string) {
        infProt.setTpAmb(string);
        return this;
    }

    public DadosDoProtocolo withVerAplic(final String string) {
        infProt.setVerAplic(string);
        return this;
    }

    public DadosDoProtocolo withChNFe(final String string) {
        infProt.setChNFe(string);
        return this;
    }

    public DadosDoProtocolo withDhRecbto(final Calendar calendar) {
        infProt.setDhRecbto(calendar);
        return this;
    }

    public DadosDoProtocolo withNProt(final String string) {
        infProt.setNProt(string);
        return this;
    }

    public DadosDoProtocolo withDigVal(final byte[] b) {
        infProt.setDigVal(b);
        return this;
    }

    public DadosDoProtocolo withCodigoDeStatus(final String string) {
        infProt.setCStat(string);
        return this;
    }

    public DadosDoProtocolo withXMotivo(final String string) {
        infProt.setXMotivo(string);
        return this;
    }

    public DadosDoProtocolo withId(final String string) {
        infProt.setId(string);
        return this;
    }

}