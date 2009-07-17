package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

public final class ReciboDoLoteImpl<T> implements ReciboDoLote<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.InfRec infRec;
    private final T parent;

    public ReciboDoLoteImpl(final T parent) {
        this.parent = parent;
        infRec = new br.com.caelum.stella.nfe.modelo.InfRec();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.infRec;
    }

    public ReciboDoLote<T> withNumeroDoRecibo(final String string) {
        infRec.setNRec(string);
        return this;
    }

    public ReciboDoLote<T> withDataEHoraDoRecebimento(final Calendar calendar) {
        infRec.setDhRecbto(calendar);
        return this;
    }

    public ReciboDoLote<T> withTempoMedioDeResposta(final String string) {
        infRec.setTMed(string);
        return this;
    }
}