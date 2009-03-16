package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;
import java.util.Calendar;

public interface Medicamento {
    public Medicamento withNumeroDoLote(String string);

    public Medicamento withQuantidadeDoLote(String string);

    public Medicamento withDataDeFabricacao(Calendar calendar);

    public Medicamento withDataDeValidade(Calendar calendar);

    public Medicamento withPrecoMaximoAoConsumidor(BigDecimal string);
}