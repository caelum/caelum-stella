package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class COFINSImpl implements COFINS, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.COFINS cOFINS;

    public COFINSImpl() {
        cOFINS = new br.com.caelum.stella.nfe.modelo.COFINS();
    }

    public br.com.caelum.stella.nfe.modelo.COFINS getInstance() {
        return cOFINS;
    }

    public COFINS withCOFINSAliq(final COFINSAliq cOFINSAliq) {
        cOFINS.setCOFINSAliq((br.com.caelum.stella.nfe.modelo.COFINSAliq) ((ObjectCreator) cOFINSAliq).getInstance());
        return this;
    }

    public COFINS withCOFINSQtde(final COFINSQtde cOFINSQtde) {
        cOFINS.setCOFINSQtde((br.com.caelum.stella.nfe.modelo.COFINSQtde) ((ObjectCreator) cOFINSQtde).getInstance());
        return this;
    }

    public COFINS withCOFINSNT(final COFINSNT cOFINSNT) {
        cOFINS.setCOFINSNT((br.com.caelum.stella.nfe.modelo.COFINSNT) ((ObjectCreator) cOFINSNT).getInstance());
        return this;
    }

    public COFINS withCOFINSOutr(final COFINSOutr cOFINSOutr) {
        cOFINS.setCOFINSOutr((br.com.caelum.stella.nfe.modelo.COFINSOutr) ((ObjectCreator) cOFINSOutr).getInstance());
        return this;
    }
}