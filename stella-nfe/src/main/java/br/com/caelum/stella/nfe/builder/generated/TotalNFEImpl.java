package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class TotalNFEImpl implements TotalNFE, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Total total;

    public TotalNFEImpl() {
        total = new br.com.caelum.stella.nfe.modelo.Total();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.total;
    }

    public TotalNFE withICMSTotal(final ICMSTotal iCMSTot) {
        total.setICMSTot((br.com.caelum.stella.nfe.modelo.ICMSTot) ((ObjectCreator) iCMSTot).getInstance());
        return this;
    }

    public TotalNFE withISSQNTotal(final ISSQNTotal iSSQNtot) {
        total.setISSQNtot((br.com.caelum.stella.nfe.modelo.ISSQNtot) ((ObjectCreator) iSSQNtot).getInstance());
        return this;
    }

    public TotalNFE withRetencaoDeTributosFederais(final RetencaoDeTributosFederais retTrib) {
        total.setRetTrib((br.com.caelum.stella.nfe.modelo.RetTrib) ((ObjectCreator) retTrib).getInstance());
        return this;
    }
}