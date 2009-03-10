package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;
import java.util.Calendar;

public interface Medicamento {
    public Medicamento withNLote(String string);

    public Medicamento withQLote(String string);

    public Medicamento withDFab(Calendar calendar);

    public Medicamento withDVal(Calendar calendar);

    public Medicamento withVPMC(BigDecimal string);
}