package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.tinytype.CNPJ;

public final class NFReferenciadaImpl implements NFReferenciada, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.RefNF refNF;

    public NFReferenciadaImpl() {
        refNF = new br.com.caelum.stella.nfe.modelo.RefNF();
        refNF.setMod("01"); // This is a xml Fixed value
    }

    public br.com.caelum.stella.nfe.modelo.RefNF getInstance() {
        return refNF;
    }

    public NFReferenciada withCodigoUF(final String string) {
        refNF.setCUF(string);
        return this;
    }

    public NFReferenciada withAAMM(final String string) {
        refNF.setAAMM(string);
        return this;
    }

    public NFReferenciada withCNPJ(final CNPJ cnpj) {
        refNF.setCNPJ(cnpj.getNumero());
        return this;
    }

    public NFReferenciada withSerie(final String string) {
        refNF.setSerie(string);
        return this;
    }

    public NFReferenciada withNumero(final String string) {
        refNF.setNNF(string);
        return this;
    }
}