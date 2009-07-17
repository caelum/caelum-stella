package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class ICMSSobreOperacoesInterestaduaisImpl<T> implements ICMSSobreOperacoesInterestaduais<T>,
        br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.ICMSInter iCMSInter;
    private final T parent;

    public ICMSSobreOperacoesInterestaduaisImpl(final T parent) {
        this.parent = parent;
        iCMSInter = new br.com.caelum.stella.nfe.modelo.ICMSInter();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.iCMSInter;
    }

    public ICMSSobreOperacoesInterestaduais<T> withValorDaBaseDeCalculoDoICMSSubstituicaoTributariaDoDestino(
            final BigDecimal string) {
        iCMSInter.setVBCICMSSTDest(string.toString());
        return this;
    }

    public ICMSSobreOperacoesInterestaduais<T> withValorDoICMSSubstituicaoTributariaDoDestino(final BigDecimal string) {
        iCMSInter.setVICMSSTDest(string.toString());
        return this;
    }
}