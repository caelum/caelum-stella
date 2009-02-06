package br.com.caelum.stella.nfe.builder.generated;

public final class FatImpl implements Fat, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Fat fat;

    public FatImpl() {
        this.fat = new br.com.caelum.stella.nfe.modelo.Fat();
    }

    public br.com.caelum.stella.nfe.modelo.Fat getInstance() {
        return this.fat;
    }

    public Fat withNFat(String string) {
        this.fat.setNFat(string);
        return this;
    }

    public Fat withVOrig(String string) {
        this.fat.setVOrig(string);
        return this;
    }

    public Fat withVDesc(String string) {
        this.fat.setVDesc(string);
        return this;
    }

    public Fat withVLiq(String string) {
        this.fat.setVLiq(string);
        return this;
    }
}