package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

public interface ReciboDoLote {
    public ReciboDoLote withNumeroDoRecibo(String string);

    public ReciboDoLote withDataEHoraDoRecebimento(Calendar calendar);

    public ReciboDoLote withTempoMedioDeResposta(String string);
}