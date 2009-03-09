package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.modelo.TUf;

public final class ICMSConsImpl implements ICMSCons, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.ICMSCons iCMSCons;

    public ICMSConsImpl() {
        iCMSCons = new br.com.caelum.stella.nfe.modelo.ICMSCons();
    }

    public br.com.caelum.stella.nfe.modelo.ICMSCons getInstance() {
        return iCMSCons;
    }

    public ICMSCons withVBCICMSSTCons(final BigDecimal string) {
        iCMSCons.setVBCICMSSTCons(string.toString());
        return this;
    }

    public ICMSCons withVICMSSTCons(final BigDecimal string) {
        iCMSCons.setVICMSSTCons(string.toString());
        return this;
    }

    public ICMSCons withUFCons(final TUf tUf) {
        iCMSCons.setUFCons(tUf);
        return this;
    }
}