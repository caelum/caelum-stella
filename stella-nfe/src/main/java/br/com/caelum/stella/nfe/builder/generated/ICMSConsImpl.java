package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.TUf;

public final class ICMSConsImpl implements ICMSCons, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.ICMSCons iCMSCons;

    public ICMSConsImpl() {
        this.iCMSCons = new br.com.caelum.stella.nfe.modelo.ICMSCons();
    }

    public br.com.caelum.stella.nfe.modelo.ICMSCons getInstance() {
        return this.iCMSCons;
    }

    public ICMSCons withVBCICMSSTCons(String string) {
        this.iCMSCons.setVBCICMSSTCons(string);
        return this;
    }

    public ICMSCons withVICMSSTCons(String string) {
        this.iCMSCons.setVICMSSTCons(string);
        return this;
    }

    public ICMSCons withUFCons(TUf tUf) {
        this.iCMSCons.setUFCons(tUf);
        return this;
    }
}