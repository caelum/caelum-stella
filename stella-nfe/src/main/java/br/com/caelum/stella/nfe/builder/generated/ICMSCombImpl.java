package br.com.caelum.stella.nfe.builder.generated;

public final class ICMSCombImpl implements ICMSComb, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.ICMSComb iCMSComb;

    public ICMSCombImpl() {
        this.iCMSComb = new br.com.caelum.stella.nfe.modelo.ICMSComb();
    }

    public br.com.caelum.stella.nfe.modelo.ICMSComb getInstance() {
        return this.iCMSComb;
    }

    public ICMSComb withVBCICMS(String string) {
        this.iCMSComb.setVBCICMS(string);
        return this;
    }

    public ICMSComb withVICMS(String string) {
        this.iCMSComb.setVICMS(string);
        return this;
    }

    public ICMSComb withVBCICMSST(String string) {
        this.iCMSComb.setVBCICMSST(string);
        return this;
    }

    public ICMSComb withVICMSST(String string) {
        this.iCMSComb.setVICMSST(string);
        return this;
    }
}