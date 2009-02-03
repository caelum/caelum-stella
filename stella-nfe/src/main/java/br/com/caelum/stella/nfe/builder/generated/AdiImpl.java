package br.com.caelum.stella.nfe.builder.generated;

public final class AdiImpl implements Adi, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Adi adi;

    public AdiImpl() {
        this.adi = new br.com.caelum.stella.nfe.modelo.Adi();
    }

    public br.com.caelum.stella.nfe.modelo.Adi getInstance() {
        return this.adi;
    }

    public Adi withNAdicao(String string) {
        this.adi.setNAdicao(string);
        return this;
    }

    public Adi withNSeqAdic(String string) {
        this.adi.setNSeqAdic(string);
        return this;
    }

    public Adi withCFabricante(String string) {
        this.adi.setCFabricante(string);
        return this;
    }

    public Adi withVDescDI(String string) {
        this.adi.setVDescDI(string);
        return this;
    }
}