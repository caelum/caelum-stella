package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;
import java.math.BigInteger;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class CombImplTest {
    @org.junit.Test
    public void testCombInterface() {
        Combustivel<Object> comb = new CombustivelImpl<Object>(new Object())
                                                                            .withCodigoDoProdutoNaANP(1)
                                                                            .withCodigoDeAutorizacaoOuRegistroDoCODIF(
                                                                                    new BigInteger("1"))
                                                                            .withQuantidadeDeCombustivelFaturadaNaTemperaturaAmbiente(
                                                                                    new BigDecimal("1"))
                                                                            .withCIDE(
                                                                                    new CIDESobreCombustiveisImpl<Object>(
                                                                                            new Object()))
                                                                            .withICMS(
                                                                                    new ICMSSobreCombustiveisImpl<Object>(
                                                                                            new Object()))
                                                                            .withICMSSobreOperacoesInterestaduais(
                                                                                    new ICMSSobreOperacoesInterestaduaisImpl<Object>(
                                                                                            new Object()))
                                                                            .withICMSSobreConsumo(
                                                                                    new ICMSSobreConsumoImpl<Object>(
                                                                                            new Object()));
        BuilderTestHelper.assertModelWasFilled(comb);
    }

}