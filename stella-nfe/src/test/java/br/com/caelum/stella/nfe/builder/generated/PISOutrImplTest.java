package br.com.caelum.stella.nfe.builder.generated;

public final class PISOutrImplTest {
    @org.junit.Test
    public void testPISOutrInterface() {
        PISOutr pISOutr = new PISOutrImpl().withCST("abc").withVBC("abc").withPPIS("abc").withQBCProd("abc")
                .withVAliqProd("abc").withVPIS("abc");
        assertModelWasFilled(pISOutr);
    }

    private void assertModelWasFilled(PISOutr pISOutr) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(pISOutr).assertModelWasFilled();
    }
}