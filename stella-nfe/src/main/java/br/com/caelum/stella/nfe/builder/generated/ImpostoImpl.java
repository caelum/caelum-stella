package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.builder.II;
import br.com.caelum.stella.nfe.builder.icms.ICMS;

public final class ImpostoImpl implements Imposto, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Imposto imposto;

    public ImpostoImpl() {
        imposto = new br.com.caelum.stella.nfe.modelo.Imposto();
    }

    public br.com.caelum.stella.nfe.modelo.Imposto getInstance() {
        return imposto;
    }

    public Imposto withICMS(final ICMS iCMS) {
        imposto.setICMS((br.com.caelum.stella.nfe.modelo.ICMS) (((ObjectCreator) iCMS).getInstance()));
        return this;
    }

    public Imposto withIPI(final IPI iPI) {
        imposto.setIPI((br.com.caelum.stella.nfe.modelo.IPI) ((ObjectCreator) iPI).getInstance());
        return this;
    }

    public Imposto withII(final II iI) {
        imposto.setII((br.com.caelum.stella.nfe.modelo.II) ((ObjectCreator) iI).getInstance());
        return this;
    }

    public Imposto withPIS(final PIS pIS) {
        imposto.setPIS((br.com.caelum.stella.nfe.modelo.PIS) ((ObjectCreator) pIS).getInstance());
        return this;
    }

    public Imposto withPISST(final PISST pISST) {
        imposto.setPISST((br.com.caelum.stella.nfe.modelo.PISST) ((ObjectCreator) pISST).getInstance());
        return this;
    }

    public Imposto withCOFINS(final COFINS cOFINS) {
        imposto.setCOFINS((br.com.caelum.stella.nfe.modelo.COFINS) ((ObjectCreator) cOFINS).getInstance());
        return this;
    }

    public Imposto withCOFINSST(final COFINSST cOFINSST) {
        imposto.setCOFINSST((br.com.caelum.stella.nfe.modelo.COFINSST) ((ObjectCreator) cOFINSST).getInstance());
        return this;
    }

    public Imposto withISSQN(final ISSQN iSSQN) {
        imposto.setISSQN((br.com.caelum.stella.nfe.modelo.ISSQN) ((ObjectCreator) iSSQN).getInstance());
        return this;
    }
}