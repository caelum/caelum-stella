package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class AdiImpl implements Adi, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Adi adi;

    public AdiImpl() {
        adi = new br.com.caelum.stella.nfe.modelo.Adi();
    }

    public br.com.caelum.stella.nfe.modelo.Adi getInstance() {
        return adi;
    }

    public Adi withNAdicao(final Integer integer) {
        adi.setNAdicao(integer.toString());
        return this;
    }

    public Adi withNSeqAdic(final Integer integer) {
        adi.setNSeqAdic(integer.toString());
        return this;
    }

    public Adi withCFabricante(final String string) {
        adi.setCFabricante(string);
        return this;
    }

    public Adi withVDescDI(final BigDecimal bigDecimal) {
        adi.setVDescDI(bigDecimal.toString());
        return this;
    }
}