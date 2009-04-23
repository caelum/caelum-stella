package br.com.caelum.stella.nfe.builder.generated;

public final class DFeImpl implements DFe, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.DFe dFe;

    public DFeImpl() {
        this.dFe = new br.com.caelum.stella.nfe.modelo.DFe();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.dFe;
    }

    public DFe withMod(String string) {
        this.dFe.setMod(string);
        return this;
    }

    public DFe withSit(String string) {
        this.dFe.setSit(string);
        return this;
    }
}