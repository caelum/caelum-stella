package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;
import java.util.Calendar;

public final class MedImpl implements Medicamento, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Med med;

    public MedImpl() {
        med = new br.com.caelum.stella.nfe.modelo.Med();
    }

    public br.com.caelum.stella.nfe.modelo.Med getInstance() {
        return med;
    }

    public Medicamento withNLote(final String string) {
        med.setNLote(string);
        return this;
    }

    public Medicamento withQLote(final String string) {
        med.setQLote(string);
        return this;
    }

    // Isso n‹o deveria estar usando o calendar
    public Medicamento withDFab(final Calendar calendar) {
        med.setDFab(new CalendarToStringConverter().convertDateToString(calendar));
        return this;
    }

    public Medicamento withDVal(final Calendar calendar) {
        med.setDVal(calendar);
        return this;
    }

    public Medicamento withVPMC(final BigDecimal string) {
        med.setVPMC(string.toString());
        return this;
    }
}