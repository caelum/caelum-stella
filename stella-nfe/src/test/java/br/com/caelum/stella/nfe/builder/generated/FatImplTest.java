package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class FatImplTest {
    @org.junit.Test
    public void testFatInterface() {
        Fatura<Object> fat = new FaturaImpl<Object>(new Object()).withNumeroDaFatura("abc").withValorOriginal(
                new BigDecimal("1")).withValorDeDesconto(new BigDecimal("1")).withValorLiquido(new BigDecimal("1"));
        BuilderTestHelper.assertModelWasFilled(fat);
    }

}