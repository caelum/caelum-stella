package br.com.caelum.stella.nfe.builder.generated;

public final class TConsReciNFeImpl implements TConsReciNFe, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TConsReciNFe tConsReciNFe;

    public TConsReciNFeImpl() {
        this.tConsReciNFe = new br.com.caelum.stella.nfe.modelo.TConsReciNFe();
    }

    public br.com.caelum.stella.nfe.modelo.TConsReciNFe getInstance() {
        return this.tConsReciNFe;
    }

    public TConsReciNFe withTpAmb(String string) {
        this.tConsReciNFe.setTpAmb(string);
        return this;
    }

    public TConsReciNFe withNRec(String string) {
        this.tConsReciNFe.setNRec(string);
        return this;
    }

    public TConsReciNFe withVersao(String string) {
        this.tConsReciNFe.setVersao(string);
        return this;
    }
}