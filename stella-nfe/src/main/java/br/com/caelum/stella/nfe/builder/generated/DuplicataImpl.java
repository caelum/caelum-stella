package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

public final class DuplicataImpl<T> implements Duplicata<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Dup dup;
    private final T parent;

    public DuplicataImpl(final T parent) {
        this.parent = parent;
        dup = new br.com.caelum.stella.nfe.modelo.Dup();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.dup;
    }

    public Duplicata<T> withNumero(final String string) {
        dup.setNDup(string);
        return this;
    }

    public Duplicata<T> withDataDeVencimento(final Calendar calendar) {
        dup.setDVenc(calendar);
        return this;
    }

    public Duplicata<T> withValorDaDuplicata(final String string) {
        dup.setVDup(string);
        return this;
    }
}