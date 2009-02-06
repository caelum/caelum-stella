package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

public final class DupImpl implements Dup, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Dup dup;

    public DupImpl() {
        this.dup = new br.com.caelum.stella.nfe.modelo.Dup();
    }

    public br.com.caelum.stella.nfe.modelo.Dup getInstance() {
        return this.dup;
    }

    public Dup withNDup(String string) {
        this.dup.setNDup(string);
        return this;
    }

    public Dup withDVenc(Calendar calendar) {
        this.dup.setDVenc(calendar);
        return this;
    }

    public Dup withVDup(String string) {
        this.dup.setVDup(string);
        return this;
    }
}