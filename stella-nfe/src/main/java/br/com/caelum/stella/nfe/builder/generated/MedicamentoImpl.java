package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;
import java.util.Calendar;

public final class MedicamentoImpl<T> implements Medicamento<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Med med;
    private final T parent;

    public MedicamentoImpl(final T parent) {
        this.parent = parent;
        med = new br.com.caelum.stella.nfe.modelo.Med();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.med;
    }

    public Medicamento<T> withNumeroDoLote(final String string) {
        med.setNLote(string);
        return this;
    }

    public Medicamento<T> withQuantidadeDoLote(final String string) {
        med.setQLote(string);
        return this;
    }

    // Isso n�o deveria estar usando o calendar
    public Medicamento<T> withDataDeFabricacao(final Calendar calendar) {
        med.setDFab(new CalendarToStringConverter().convertDateToString(calendar));
        return this;
    }

    public Medicamento<T> withDataDeValidade(final Calendar calendar) {
        med.setDVal(calendar);
        return this;
    }

    public Medicamento<T> withPrecoMaximoAoConsumidor(final BigDecimal string) {
        med.setVPMC(string.toString());
        return this;
    }
}