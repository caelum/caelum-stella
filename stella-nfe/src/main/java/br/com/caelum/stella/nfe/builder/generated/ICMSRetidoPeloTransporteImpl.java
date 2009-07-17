package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class ICMSRetidoPeloTransporteImpl<T> implements ICMSRetidoPeloTransporte<T>,
        br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.RetTransp retTransp;
    private final T parent;

    public ICMSRetidoPeloTransporteImpl(final T parent) {
        this.parent = parent;
        retTransp = new br.com.caelum.stella.nfe.modelo.RetTransp();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.retTransp;
    }

    public ICMSRetidoPeloTransporte<T> withValorDoServico(final BigDecimal string) {
        retTransp.setVServ(string.toString());
        return this;
    }

    public ICMSRetidoPeloTransporte<T> withValorDaBaseDeCalculoDeRetencaoDoICMS(final BigDecimal string) {
        retTransp.setVBCRet(string.toString());
        return this;
    }

    public ICMSRetidoPeloTransporte<T> withAliquotaDaRetencaoDoICMS(final BigDecimal aliquota) {
        retTransp.setPICMSRet(aliquota.toPlainString());
        return this;
    }

    public ICMSRetidoPeloTransporte<T> withValorDoICMSRetido(final BigDecimal string) {
        retTransp.setVICMSRet(string.toString());
        return this;
    }

    public ICMSRetidoPeloTransporte<T> withCodigoFiscalDeOperacoesEPrestacoes(final String string) {
        retTransp.setCFOP(string);
        return this;
    }

    public ICMSRetidoPeloTransporte<T> withCodigoDoMunicipio(final String string) {
        retTransp.setCMunFG(string);
        return this;
    }
}