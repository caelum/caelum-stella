package br.com.caelum.stella.nfe.builder.generated;

public final class PISSTImplTest {
    @org.junit.Test
    public void testPISSTInterface() {
        PISST pISST = new PISSTImpl().withVBC("abc").withPPIS("abc").withQBCProd("abc").withVAliqProd("abc").withVPIS(
                "abc");
        assertModelWasFilled(pISST);
    }

    private void assertModelWasFilled(PISST pISST) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(pISST).assertModelWasFilled();
    }
}