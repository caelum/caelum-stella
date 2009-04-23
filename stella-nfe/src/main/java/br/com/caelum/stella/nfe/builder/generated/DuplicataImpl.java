package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

public final class DuplicataImpl implements Duplicata, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Dup dup;

    public DuplicataImpl() {
        dup = new br.com.caelum.stella.nfe.modelo.Dup();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.dup;
    }

    public Duplicata withNumero(final String string) {
        dup.setNDup(string);
        return this;
    }

    public Duplicata withDataDeVencimento(final Calendar calendar) {
        dup.setDVenc(calendar);
        return this;
    }

    public Duplicata withValorDaDuplicata(final String string) {
        dup.setVDup(string);
        return this;
    }
}