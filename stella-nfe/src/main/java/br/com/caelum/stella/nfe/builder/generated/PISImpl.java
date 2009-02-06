package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class PISImpl implements PIS, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.PIS pIS;

    public PISImpl() {
        pIS = new br.com.caelum.stella.nfe.modelo.PIS();
    }

    public br.com.caelum.stella.nfe.modelo.PIS getInstance() {
        return pIS;
    }

    public PIS withPISAliq(final PISAliq pISAliq) {
        pIS.setPISAliq((br.com.caelum.stella.nfe.modelo.PISAliq) ((ObjectCreator) pISAliq).getInstance());
        return this;
    }

    public PIS withPISQtde(final PISQtde pISQtde) {
        pIS.setPISQtde((br.com.caelum.stella.nfe.modelo.PISQtde) ((ObjectCreator) pISQtde).getInstance());
        return this;
    }

    public PIS withPISNT(final PISNT pISNT) {
        pIS.setPISNT((br.com.caelum.stella.nfe.modelo.PISNT) ((ObjectCreator) pISNT).getInstance());
        return this;
    }

    public PIS withPISOutr(final PISOutr pISOutr) {
        pIS.setPISOutr((br.com.caelum.stella.nfe.modelo.PISOutr) ((ObjectCreator) pISOutr).getInstance());
        return this;
    }
}