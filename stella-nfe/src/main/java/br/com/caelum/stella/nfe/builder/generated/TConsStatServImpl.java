package br.com.caelum.stella.nfe.builder.generated;

public final class TConsStatServImpl implements TConsStatServ, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TConsStatServ tConsStatServ;

    public TConsStatServImpl() {
        this.tConsStatServ = new br.com.caelum.stella.nfe.modelo.TConsStatServ();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.tConsStatServ;
    }

    public TConsStatServ withTpAmb(String string) {
        this.tConsStatServ.setTpAmb(string);
        return this;
    }

    public TConsStatServ withCUF(String string) {
        this.tConsStatServ.setCUF(string);
        return this;
    }

    public TConsStatServ withXServ(String string) {
        this.tConsStatServ.setXServ(string);
        return this;
    }

    public TConsStatServ withVersao(String string) {
        this.tConsStatServ.setVersao(string);
        return this;
    }
}