package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;
import java.math.BigInteger;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class CombustivelImpl<T> implements Combustivel<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Comb comb;
    private final T parent;

    public CombustivelImpl(final T parent) {
        this.parent = parent;
        comb = new br.com.caelum.stella.nfe.modelo.Comb();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.comb;
    }

    public Combustivel<T> withCodigoDoProdutoNaANP(final Integer string) {
        comb.setCProdANP(string.toString());
        return this;
    }

    public Combustivel<T> withCodigoDeAutorizacaoOuRegistroDoCODIF(final BigInteger string) {
        comb.setCODIF(string.toString());
        return this;
    }

    public Combustivel<T> withQuantidadeDeCombustivelFaturadaNaTemperaturaAmbiente(final BigDecimal string) {
        comb.setQTemp(string.toString());
        return this;
    }

    public Combustivel<T> withCIDE(final CIDESobreCombustiveis<?> cIDE) {
        comb.setCIDE((br.com.caelum.stella.nfe.modelo.CIDE) ((ObjectCreator) cIDE).getInstance());
        return this;
    }

    public Combustivel<T> withICMS(final ICMSSobreCombustiveis<?> iCMSComb) {
        comb.setICMSComb((br.com.caelum.stella.nfe.modelo.ICMSComb) ((ObjectCreator) iCMSComb).getInstance());
        return this;
    }

    public Combustivel<T> withICMSSobreOperacoesInterestaduais(final ICMSSobreOperacoesInterestaduais<?> iCMSInter) {
        comb.setICMSInter((br.com.caelum.stella.nfe.modelo.ICMSInter) ((ObjectCreator) iCMSInter).getInstance());
        return this;
    }

    public Combustivel<T> withICMSSobreConsumo(final ICMSSobreConsumo<?> iCMSCons) {
        comb.setICMSCons((br.com.caelum.stella.nfe.modelo.ICMSCons) ((ObjectCreator) iCMSCons).getInstance());
        return this;
    }
}