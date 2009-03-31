package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class ICMSCombImplTest {
    @org.junit.Test
    public void testICMSCombInterface() {
        ICMSSobreCombustiveis iCMSComb = new ICMSSobreCombustiveisImpl().withValorDaBaseDeCalculo(new BigDecimal("1")).withValor(new BigDecimal("1"))
                .withValorDaBaseDeCalculoDaSubstituicaoTributaria(new BigDecimal("1")).withValorDoICMSDaSubstituicaoTributaria(new BigDecimal("1"));
        assertModelWasFilled(iCMSComb);
    }

    private void assertModelWasFilled(final ICMSSobreCombustiveis iCMSComb) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(iCMSComb).assertModelWasFilled();
    }
}