package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;
import java.math.BigInteger;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class CombustivelImpl implements Combustivel, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Comb comb;

    public CombustivelImpl() {
        comb = new br.com.caelum.stella.nfe.modelo.Comb();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.comb;
    }

    public Combustivel withCodigoDoProdutoNaANP(final Integer string) {
        comb.setCProdANP(string.toString());
        return this;
    }

    public Combustivel withCodigoDeAutorizacaoOuRegistroDoCODIF(final BigInteger string) {
        comb.setCODIF(string.toString());
        return this;
    }

    public Combustivel withQuantidadeDeCombustivelFaturadaNaTemperaturaAmbiente(final BigDecimal string) {
        comb.setQTemp(string.toString());
        return this;
    }

    public Combustivel withCIDE(final CIDESobreCombustiveis cIDE) {
        comb.setCIDE((br.com.caelum.stella.nfe.modelo.CIDE) ((ObjectCreator) cIDE).getInstance());
        return this;
    }

    public Combustivel withICMS(final ICMSSobreCombustiveis iCMSComb) {
        comb.setICMSComb((br.com.caelum.stella.nfe.modelo.ICMSComb) ((ObjectCreator) iCMSComb).getInstance());
        return this;
    }

    public Combustivel withICMSSobreOperacoesInterestaduais(final ICMSSobreOperacoesInterestaduais iCMSInter) {
        comb.setICMSInter((br.com.caelum.stella.nfe.modelo.ICMSInter) ((ObjectCreator) iCMSInter).getInstance());
        return this;
    }

    public Combustivel withICMSSobreConsumo(final ICMSSobreConsumo iCMSCons) {
        comb.setICMSCons((br.com.caelum.stella.nfe.modelo.ICMSCons) ((ObjectCreator) iCMSCons).getInstance());
        return this;
    }
}