package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface ReciboDoLote<T> extends NFeBuilder<T> {
    public ReciboDoLote<T> withNumeroDoRecibo(String string);

    public ReciboDoLote<T> withDataEHoraDoRecebimento(Calendar calendar);

    public ReciboDoLote<T> withTempoMedioDeResposta(String string);
}