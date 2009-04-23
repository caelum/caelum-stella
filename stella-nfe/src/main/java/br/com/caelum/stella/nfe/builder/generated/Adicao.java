package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public interface Adicao {
    public Adicao withNumeroDaAdicao(Integer integer);

    public Adicao withNumeroSequencialDoItemDaAdicao(Integer integer);

    public Adicao withCodigoDoFabricanteEstrangeiro(String string);

    public Adicao withValorDeDescontoDoItemDaDI(BigDecimal bigDecimal);
}