package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class ICMSInterImplTest {
    @org.junit.Test
    public void testICMSInterInterface() {
        ICMSInter iCMSInter = new ICMSInterImpl().withVBCICMSSTDest(new BigDecimal("1")).withVICMSSTDest(
                new BigDecimal("1"));
        assertModelWasFilled(iCMSInter);
    }

    private void assertModelWasFilled(final ICMSInter iCMSInter) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(iCMSInter).assertModelWasFilled();
    }
}