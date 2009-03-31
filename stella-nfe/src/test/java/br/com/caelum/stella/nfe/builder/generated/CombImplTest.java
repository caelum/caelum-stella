package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;
import java.math.BigInteger;

public final class CombImplTest {
    @org.junit.Test
    public void testCombInterface() {
        Combustivel comb = new CombustivelImpl().withCodigoDoProdutoNaANP(1).withCodigoDeAutorizacaoOuRegistroDoCODIF(new BigInteger("1")).withQuantidadeDeCombustivelFaturadaNaTemperaturaAmbiente(new BigDecimal("1"))
                .withCIDE(new CIDESobreCombustiveisImpl()).withICMS(new ICMSSobreCombustiveisImpl()).withICMSSobreOperacoesInterestaduais(new ICMSSobreOperacoesInterestaduaisImpl())
                .withICMSSobreConsumo(new ICMSSobreConsumoImpl());
        assertModelWasFilled(comb);
    }

    private void assertModelWasFilled(final Combustivel comb) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(comb).assertModelWasFilled();
    }
}