package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

public final class ReciboDoLoteImpl implements ReciboDoLote, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.InfRec infRec;

    public ReciboDoLoteImpl() {
        infRec = new br.com.caelum.stella.nfe.modelo.InfRec();
    }

    public br.com.caelum.stella.nfe.modelo.InfRec getInstance() {
        return infRec;
    }

    public ReciboDoLote withNumeroDoRecibo(final String string) {
        infRec.setNRec(string);
        return this;
    }

    public ReciboDoLote withDataEHoraDoRecebimento(final Calendar calendar) {
        infRec.setDhRecbto(calendar);
        return this;
    }

    public ReciboDoLote withTempoMedioDeResposta(final String string) {
        infRec.setTMed(string);
        return this;
    }
}