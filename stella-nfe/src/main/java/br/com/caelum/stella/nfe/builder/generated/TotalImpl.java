package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class TotalImpl implements Total, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Total total;

    public TotalImpl() {
        total = new br.com.caelum.stella.nfe.modelo.Total();
    }

    public br.com.caelum.stella.nfe.modelo.Total getInstance() {
        return total;
    }

    public Total withICMSTot(final ICMSTot iCMSTot) {
        total.setICMSTot((br.com.caelum.stella.nfe.modelo.ICMSTot) ((ObjectCreator) iCMSTot).getInstance());
        return this;
    }

    public Total withISSQNtot(final ISSQNtot iSSQNtot) {
        total.setISSQNtot((br.com.caelum.stella.nfe.modelo.ISSQNtot) ((ObjectCreator) iSSQNtot).getInstance());
        return this;
    }

    public Total withRetTrib(final RetTrib retTrib) {
        total.setRetTrib((br.com.caelum.stella.nfe.modelo.RetTrib) ((ObjectCreator) retTrib).getInstance());
        return this;
    }
}