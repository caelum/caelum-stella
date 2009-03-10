package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

public final class InfRecImpl implements ReciboDoLote, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.InfRec infRec;

    public InfRecImpl() {
        this.infRec = new br.com.caelum.stella.nfe.modelo.InfRec();
    }

    public br.com.caelum.stella.nfe.modelo.InfRec getInstance() {
        return this.infRec;
    }

    public ReciboDoLote withNRec(String string) {
        this.infRec.setNRec(string);
        return this;
    }

    public ReciboDoLote withDhRecbto(Calendar calendar) {
        this.infRec.setDhRecbto(calendar);
        return this;
    }

    public ReciboDoLote withTMed(String string) {
        this.infRec.setTMed(string);
        return this;
    }
}