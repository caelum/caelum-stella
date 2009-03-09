package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class RetTranspImplTest {
    @org.junit.Test
    public void testRetTranspInterface() {
        RetTransp retTransp = new RetTranspImpl().withVServ(new BigDecimal(1)).withVBCRet(new BigDecimal(1))
                .withPICMSRet(new BigDecimal(1)).withVICMSRet(new BigDecimal(1)).withCFOP("abc").withCMunFG("abc");
        assertModelWasFilled(retTransp);
    }

    private void assertModelWasFilled(final RetTransp retTransp) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(retTransp).assertModelWasFilled();
    }
}