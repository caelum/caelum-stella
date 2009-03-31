package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class ICMSSobreOperacoesInterestaduaisImpl implements ICMSSobreOperacoesInterestaduais,
        br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.ICMSInter iCMSInter;

    public ICMSSobreOperacoesInterestaduaisImpl() {
        iCMSInter = new br.com.caelum.stella.nfe.modelo.ICMSInter();
    }

    public br.com.caelum.stella.nfe.modelo.ICMSInter getInstance() {
        return iCMSInter;
    }

    public ICMSSobreOperacoesInterestaduais withValorDaBaseDeCalculoDoICMSSubstituicaoTributariaDoDestino(
            final BigDecimal string) {
        iCMSInter.setVBCICMSSTDest(string.toString());
        return this;
    }

    public ICMSSobreOperacoesInterestaduais withValorDoICMSSubstituicaoTributariaDoDestino(final BigDecimal string) {
        iCMSInter.setVICMSSTDest(string.toString());
        return this;
    }
}