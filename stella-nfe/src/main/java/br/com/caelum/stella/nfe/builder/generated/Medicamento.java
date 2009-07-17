package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface Medicamento<T> extends NFeBuilder<T> {
    public Medicamento<T> withNumeroDoLote(String string);

    public Medicamento<T> withQuantidadeDoLote(String string);

    public Medicamento<T> withDataDeFabricacao(Calendar calendar);

    public Medicamento<T> withDataDeValidade(Calendar calendar);

    public Medicamento<T> withPrecoMaximoAoConsumidor(BigDecimal string);
}