package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;
import java.util.Calendar;

public final class MedicamentoImpl implements Medicamento, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Med med;

    public MedicamentoImpl() {
        med = new br.com.caelum.stella.nfe.modelo.Med();
    }

    public br.com.caelum.stella.nfe.modelo.Med getInstance() {
        return med;
    }

    public Medicamento withNumeroDoLote(final String string) {
        med.setNLote(string);
        return this;
    }

    public Medicamento withQuantidadeDoLote(final String string) {
        med.setQLote(string);
        return this;
    }

    // Isso n‹o deveria estar usando o calendar
    public Medicamento withDataDeFabricacao(final Calendar calendar) {
        med.setDFab(new CalendarToStringConverter().convertDateToString(calendar));
        return this;
    }

    public Medicamento withDataDeValidade(final Calendar calendar) {
        med.setDVal(calendar);
        return this;
    }

    public Medicamento withPrecoMaximoAoConsumidor(final BigDecimal string) {
        med.setVPMC(string.toString());
        return this;
    }
}