package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.modelo.UF;

public final class ICMSSobreConsumoImpl<T> implements ICMSSobreConsumo<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.ICMSCons iCMSCons;
    private final T parent;

    public ICMSSobreConsumoImpl(final T parent) {
        this.parent = parent;
        iCMSCons = new br.com.caelum.stella.nfe.modelo.ICMSCons();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.iCMSCons;
    }

    public ICMSSobreConsumo<T> withValorDaBaseDeCalculoDoICMSDeSubstituicaoTributariaSobreConsumo(
            final BigDecimal string) {
        iCMSCons.setVBCICMSSTCons(string.toString());
        return this;
    }

    public ICMSSobreConsumo<T> withValorDoICMSSubstituicaoTributariaSobreConsumo(final BigDecimal string) {
        iCMSCons.setVICMSSTCons(string.toString());
        return this;
    }

    public ICMSSobreConsumo<T> withUF(final UF tUf) {
        iCMSCons.setUFCons(tUf);
        return this;
    }
}