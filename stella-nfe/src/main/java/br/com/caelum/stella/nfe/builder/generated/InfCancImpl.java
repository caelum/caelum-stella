package br.com.caelum.stella.nfe.builder.generated;

public final class InfCancImpl implements InfCanc, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.InfCanc infCanc;

    public InfCancImpl() {
        this.infCanc = new br.com.caelum.stella.nfe.modelo.InfCanc();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.infCanc;
    }

    public InfCanc withTpAmb(String string) {
        this.infCanc.setTpAmb(string);
        return this;
    }

    public InfCanc withXServ(String string) {
        this.infCanc.setXServ(string);
        return this;
    }

    public InfCanc withChNFe(String string) {
        this.infCanc.setChNFe(string);
        return this;
    }

    public InfCanc withNProt(String string) {
        this.infCanc.setNProt(string);
        return this;
    }

    public InfCanc withXJust(String string) {
        this.infCanc.setXJust(string);
        return this;
    }

    public InfCanc withId(String string) {
        this.infCanc.setId(string);
        return this;
    }
}