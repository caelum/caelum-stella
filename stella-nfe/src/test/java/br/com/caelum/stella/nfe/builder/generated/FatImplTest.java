package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class FatImplTest {
    @org.junit.Test
    public void testFatInterface() {
        Fat fat = new FatImpl().withNFat("abc").withVOrig(new BigDecimal("1")).withVDesc(new BigDecimal("1")).withVLiq(
                new BigDecimal("1"));
        assertModelWasFilled(fat);
    }

    private void assertModelWasFilled(final Fat fat) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(fat).assertModelWasFilled();
    }
}