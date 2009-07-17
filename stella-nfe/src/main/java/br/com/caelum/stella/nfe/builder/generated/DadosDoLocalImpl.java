package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.UF;
import br.com.caelum.stella.tinytype.CNPJ;

public final class DadosDoLocalImpl<T> implements DadosDoLocal<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TLocal tLocal;
    private final T parent;

    public DadosDoLocalImpl(final T parent) {
        this.parent = parent;
        tLocal = new br.com.caelum.stella.nfe.modelo.TLocal();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.tLocal;
    }

    public DadosDoLocal<T> withCNPJ(final CNPJ cnpj) {
        tLocal.setCNPJ(cnpj.getNumero());
        return this;
    }

    public DadosDoLocal<T> withLogradouro(final String string) {
        tLocal.setXLgr(string);
        return this;
    }

    public DadosDoLocal<T> withNumero(final String string) {
        tLocal.setNro(string);
        return this;
    }

    public DadosDoLocal<T> withComplemento(final String string) {
        tLocal.setXCpl(string);
        return this;
    }

    public DadosDoLocal<T> withBairro(final String string) {
        tLocal.setXBairro(string);
        return this;
    }

    public DadosDoLocal<T> withCodigoDoMunicipio(final String string) {
        tLocal.setCMun(string);
        return this;
    }

    public DadosDoLocal<T> withNomeDoMunicipio(final String string) {
        tLocal.setXMun(string);
        return this;
    }

    public DadosDoLocal<T> withUF(final UF tUf) {
        tLocal.setUF(tUf);
        return this;
    }
}