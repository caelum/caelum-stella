package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class ICMSCombImplTest {
    @org.junit.Test
    public void testICMSCombInterface() {
        ICMSComb iCMSComb = new ICMSCombImpl().withVBCICMS(new BigDecimal("1")).withVICMS(new BigDecimal("1"))
                .withVBCICMSST(new BigDecimal("1")).withVICMSST(new BigDecimal("1"));
        assertModelWasFilled(iCMSComb);
    }

    private void assertModelWasFilled(final ICMSComb iCMSComb) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(iCMSComb).assertModelWasFilled();
    }
}