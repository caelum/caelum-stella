package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;
import java.util.Calendar;

public interface Med {
    public Med withNLote(String string);

    public Med withQLote(String string);

    public Med withDFab(Calendar calendar);

    public Med withDVal(Calendar calendar);

    public Med withVPMC(BigDecimal string);
}