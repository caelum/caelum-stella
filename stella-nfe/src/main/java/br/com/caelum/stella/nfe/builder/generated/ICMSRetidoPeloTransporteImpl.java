package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class ICMSRetidoPeloTransporteImpl implements ICMSRetidoPeloTransporte,
        br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.RetTransp retTransp;

    public ICMSRetidoPeloTransporteImpl() {
        retTransp = new br.com.caelum.stella.nfe.modelo.RetTransp();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.retTransp;
    }

    public ICMSRetidoPeloTransporte withValorDoServico(final BigDecimal string) {
        retTransp.setVServ(string.toString());
        return this;
    }

    public ICMSRetidoPeloTransporte withValorDaBaseDeCalculoDeRetencaoDoICMS(final BigDecimal string) {
        retTransp.setVBCRet(string.toString());
        return this;
    }

    public ICMSRetidoPeloTransporte withAliquotaDaRetencaoDoICMS(final BigDecimal aliquota) {
        retTransp.setPICMSRet(aliquota.toPlainString());
        return this;
    }

    public ICMSRetidoPeloTransporte withValorDoICMSRetido(final BigDecimal string) {
        retTransp.setVICMSRet(string.toString());
        return this;
    }

    public ICMSRetidoPeloTransporte withCodigoFiscalDeOperacoesEPrestacoes(final String string) {
        retTransp.setCFOP(string);
        return this;
    }

    public ICMSRetidoPeloTransporte withCodigoDoMunicipio(final String string) {
        retTransp.setCMunFG(string);
        return this;
    }
}