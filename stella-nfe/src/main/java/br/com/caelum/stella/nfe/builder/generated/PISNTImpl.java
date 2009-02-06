package br.com.caelum.stella.nfe.builder.generated;

public final class PISNTImpl implements PISNT, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.PISNT pISNT;

    public PISNTImpl() {
        this.pISNT = new br.com.caelum.stella.nfe.modelo.PISNT();
    }

    public br.com.caelum.stella.nfe.modelo.PISNT getInstance() {
        return this.pISNT;
    }

    public PISNT withCST(String string) {
        this.pISNT.setCST(string);
        return this;
    }
}