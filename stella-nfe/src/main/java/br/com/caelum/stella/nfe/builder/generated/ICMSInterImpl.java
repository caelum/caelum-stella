package br.com.caelum.stella.nfe.builder.generated;

public final class ICMSInterImpl implements ICMSInter, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.ICMSInter iCMSInter;

    public ICMSInterImpl() {
        this.iCMSInter = new br.com.caelum.stella.nfe.modelo.ICMSInter();
    }

    public br.com.caelum.stella.nfe.modelo.ICMSInter getInstance() {
        return this.iCMSInter;
    }

    public ICMSInter withVBCICMSSTDest(String string) {
        this.iCMSInter.setVBCICMSSTDest(string);
        return this;
    }

    public ICMSInter withVICMSSTDest(String string) {
        this.iCMSInter.setVICMSSTDest(string);
        return this;
    }
}