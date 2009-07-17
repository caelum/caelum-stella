package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class AdicoesImpl<T> implements Adicao<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Adi adi;
    private final T parent;

    public AdicoesImpl(final T parent) {
        this.parent = parent;
        adi = new br.com.caelum.stella.nfe.modelo.Adi();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.adi;
    }

    public Adicao<T> withNumeroDaAdicao(final Integer integer) {
        adi.setNAdicao(integer.toString());
        return this;
    }

    public Adicao<T> withNumeroSequencialDoItemDaAdicao(final Integer integer) {
        adi.setNSeqAdic(integer.toString());
        return this;
    }

    public Adicao<T> withCodigoDoFabricanteEstrangeiro(final String string) {
        adi.setCFabricante(string);
        return this;
    }

    public Adicao<T> withValorDeDescontoDoItemDaDI(final BigDecimal bigDecimal) {
        adi.setVDescDI(bigDecimal.toString());
        return this;
    }
}