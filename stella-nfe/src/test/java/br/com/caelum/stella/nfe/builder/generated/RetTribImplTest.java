package br.com.caelum.stella.nfe.builder.generated;

public final class RetTribImplTest {
    @org.junit.Test
    public void testRetTribInterface() {
        RetTrib retTrib = new RetTribImpl().withVRetPIS("abc").withVRetCOFINS("abc").withVRetCSLL("abc").withVBCIRRF(
                "abc").withVIRRF("abc").withVBCRetPrev("abc").withVRetPrev("abc");
        assertModelWasFilled(retTrib);
    }

    private void assertModelWasFilled(RetTrib retTrib) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(retTrib).assertModelWasFilled();
    }
}