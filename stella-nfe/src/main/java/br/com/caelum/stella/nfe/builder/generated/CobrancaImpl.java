package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class CobrancaImpl<T> implements Cobranca<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Cobr cobr;
    private final T parent;

    public CobrancaImpl(final T parent) {
        this.parent = parent;
        cobr = new br.com.caelum.stella.nfe.modelo.Cobr();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.cobr;
    }

    public Cobranca<T> withFatura(final Fatura<?> fat) {
        cobr.setFat((br.com.caelum.stella.nfe.modelo.Fat) ((ObjectCreator) fat).getInstance());
        return this;
    }

    public Cobranca<T> withDuplicatas(final Duplicata<?>... dups) {
        List<br.com.caelum.stella.nfe.modelo.Dup> list = new ArrayList<br.com.caelum.stella.nfe.modelo.Dup>();
        for (Duplicata<?> p : dups) {
            list.add((br.com.caelum.stella.nfe.modelo.Dup) ((ObjectCreator) p).getInstance());
        }
        cobr.setDup(list);
        return this;
    }
}