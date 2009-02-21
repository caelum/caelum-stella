package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.builder.Impostos;

public final class DetImpl implements Det, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Det det;

    public DetImpl() {
        det = new br.com.caelum.stella.nfe.modelo.Det();
    }

    public br.com.caelum.stella.nfe.modelo.Det getInstance() {
        return det;
    }

    public Det withProd(final Prod prod) {
        det.setProd((br.com.caelum.stella.nfe.modelo.Prod) ((ObjectCreator) prod).getInstance());
        return this;
    }

    public Det withImposto(final Impostos imposto) {
        det.setImposto((br.com.caelum.stella.nfe.modelo.Imposto) ((ObjectCreator) imposto).getInstance());
        return this;
    }

    public Det withInfAdProd(final String string) {
        det.setInfAdProd(string);
        return this;
    }

    public Det withNItem(final String string) {
        det.setNItem(string);
        return this;
    }
}