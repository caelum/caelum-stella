package br.com.caelum.stella.nfe.builder.generated;

public final class TConsSitNFeImpl implements TConsSitNFe, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TConsSitNFe tConsSitNFe;

    public TConsSitNFeImpl() {
        this.tConsSitNFe = new br.com.caelum.stella.nfe.modelo.TConsSitNFe();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.tConsSitNFe;
    }

    public TConsSitNFe withTpAmb(String string) {
        this.tConsSitNFe.setTpAmb(string);
        return this;
    }

    public TConsSitNFe withXServ(String string) {
        this.tConsSitNFe.setXServ(string);
        return this;
    }

    public TConsSitNFe withChNFe(String string) {
        this.tConsSitNFe.setChNFe(string);
        return this;
    }

    public TConsSitNFe withVersao(String string) {
        this.tConsSitNFe.setVersao(string);
        return this;
    }
}