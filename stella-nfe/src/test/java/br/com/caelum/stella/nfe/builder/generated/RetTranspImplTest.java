package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class RetTranspImplTest {
    @org.junit.Test
    public void testRetTranspInterface() {
        RetTransp retTransp = new RetTranspImpl().withVServ("abc").withVBCRet("abc").withPICMSRet(new BigDecimal(1))
        .withVICMSRet("abc").withCFOP("abc").withCMunFG("abc");
        assertModelWasFilled(retTransp);
    }

    private void assertModelWasFilled(RetTransp retTransp) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(retTransp).assertModelWasFilled();
    }
}