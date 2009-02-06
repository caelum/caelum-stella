package br.com.caelum.stella.nfe.builder.generated;

public final class COFINSOutrImplTest {
    @org.junit.Test
    public void testCOFINSOutrInterface() {
        COFINSOutr cOFINSOutr = new COFINSOutrImpl().withCST("abc").withVBC("abc").withPCOFINS("abc")
                .withQbcProd("abc").withVAliqProd("abc").withVCOFINS("abc");
        assertModelWasFilled(cOFINSOutr);
    }

    private void assertModelWasFilled(COFINSOutr cOFINSOutr) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(cOFINSOutr).assertModelWasFilled();
    }
}