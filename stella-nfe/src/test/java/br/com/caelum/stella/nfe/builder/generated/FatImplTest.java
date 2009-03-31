package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class FatImplTest {
    @org.junit.Test
    public void testFatInterface() {
        Fatura fat = new FaturaImpl().withNumeroDaFatura("abc").withValorOriginal(new BigDecimal("1")).withValorDeDesconto(new BigDecimal("1")).withValorLiquido(
                new BigDecimal("1"));
        assertModelWasFilled(fat);
    }

    private void assertModelWasFilled(final Fatura fat) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(fat).assertModelWasFilled();
    }
}