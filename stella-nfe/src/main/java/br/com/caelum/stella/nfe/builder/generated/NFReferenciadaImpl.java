package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.tinytype.CNPJ;

public final class NFReferenciadaImpl<T> implements NFReferenciada<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.RefNF refNF;
    private final T parent;

    public NFReferenciadaImpl(final T parent) {
        this.parent = parent;
        refNF = new br.com.caelum.stella.nfe.modelo.RefNF();
        refNF.setMod("01"); // This is a xml Fixed value
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.refNF;
    }

    public NFReferenciada<T> withCodigoUF(final String string) {
        refNF.setCUF(string);
        return this;
    }

    public NFReferenciada<T> withAAMM(final String string) {
        refNF.setAAMM(string);
        return this;
    }

    public NFReferenciada<T> withCNPJ(final CNPJ cnpj) {
        refNF.setCNPJ(cnpj.getNumero());
        return this;
    }

    public NFReferenciada<T> withSerie(final String string) {
        refNF.setSerie(string);
        return this;
    }

    public NFReferenciada<T> withNumero(final String string) {
        refNF.setNNF(string);
        return this;
    }
}