package br.com.caelum.stella.nfe.builder.generated;

public final class RetTranspImplTest {
    @org.junit.Test
    public void testRetTranspInterface() {
        RetTransp retTransp = new RetTranspImpl().withVServ("abc").withVBCRet("abc").withPICMSRet("abc").withVICMSRet(
                "abc").withCFOP("abc").withCMunFG("abc");
        assertModelWasFilled(retTransp);
    }

    private void assertModelWasFilled(RetTransp retTransp) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(retTransp).assertModelWasFilled();
    }
}