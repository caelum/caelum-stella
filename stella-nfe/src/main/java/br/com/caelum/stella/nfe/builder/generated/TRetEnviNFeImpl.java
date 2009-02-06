package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class TRetEnviNFeImpl implements TRetEnviNFe, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TRetEnviNFe tRetEnviNFe;

    public TRetEnviNFeImpl() {
        tRetEnviNFe = new br.com.caelum.stella.nfe.modelo.TRetEnviNFe();
    }

    public br.com.caelum.stella.nfe.modelo.TRetEnviNFe getInstance() {
        return tRetEnviNFe;
    }

    public TRetEnviNFe withTpAmb(final String string) {
        tRetEnviNFe.setTpAmb(string);
        return this;
    }

    public TRetEnviNFe withVerAplic(final String string) {
        tRetEnviNFe.setVerAplic(string);
        return this;
    }

    public TRetEnviNFe withCStat(final String string) {
        tRetEnviNFe.setCStat(string);
        return this;
    }

    public TRetEnviNFe withXMotivo(final String string) {
        tRetEnviNFe.setXMotivo(string);
        return this;
    }

    public TRetEnviNFe withCUF(final String string) {
        tRetEnviNFe.setCUF(string);
        return this;
    }

    public TRetEnviNFe withInfRec(final InfRec infRec) {
        tRetEnviNFe.setInfRec((br.com.caelum.stella.nfe.modelo.InfRec) ((ObjectCreator) infRec).getInstance());
        return this;
    }

    public TRetEnviNFe withVersao(final String string) {
        tRetEnviNFe.setVersao(string);
        return this;
    }
}