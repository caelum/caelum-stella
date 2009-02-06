package br.com.caelum.stella.nfe.builder.generated;

public final class COFINSSTImplTest {
    @org.junit.Test
    public void testCOFINSSTInterface() {
        COFINSST cOFINSST = new COFINSSTImpl().withVBC("abc").withPCOFINS("abc").withQBCProd("abc")
                .withVAliqProd("abc").withVCOFINS("abc");
        assertModelWasFilled(cOFINSST);
    }

    private void assertModelWasFilled(COFINSST cOFINSST) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(cOFINSST).assertModelWasFilled();
    }
}