package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class AdicoesImpl implements Adicao, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Adi adi;

    public AdicoesImpl() {
        adi = new br.com.caelum.stella.nfe.modelo.Adi();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.adi;
    }

    public Adicao withNumeroDaAdicao(final Integer integer) {
        adi.setNAdicao(integer.toString());
        return this;
    }

    public Adicao withNumeroSequencialDoItemDaAdicao(final Integer integer) {
        adi.setNSeqAdic(integer.toString());
        return this;
    }

    public Adicao withCodigoDoFabricanteEstrangeiro(final String string) {
        adi.setCFabricante(string);
        return this;
    }

    public Adicao withValorDeDescontoDoItemDaDI(final BigDecimal bigDecimal) {
        adi.setVDescDI(bigDecimal.toString());
        return this;
    }
}