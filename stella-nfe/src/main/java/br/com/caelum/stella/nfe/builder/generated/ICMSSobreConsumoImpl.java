package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.modelo.UF;

public final class ICMSSobreConsumoImpl implements ICMSSobreConsumo, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.ICMSCons iCMSCons;

    public ICMSSobreConsumoImpl() {
        iCMSCons = new br.com.caelum.stella.nfe.modelo.ICMSCons();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.iCMSCons;
    }

    public ICMSSobreConsumo withValorDaBaseDeCalculoDoICMSDeSubstituicaoTributariaSobreConsumo(final BigDecimal string) {
        iCMSCons.setVBCICMSSTCons(string.toString());
        return this;
    }

    public ICMSSobreConsumo withValorDoICMSSubstituicaoTributariaSobreConsumo(final BigDecimal string) {
        iCMSCons.setVICMSSTCons(string.toString());
        return this;
    }

    public ICMSSobreConsumo withUF(final UF tUf) {
        iCMSCons.setUFCons(tUf);
        return this;
    }
}