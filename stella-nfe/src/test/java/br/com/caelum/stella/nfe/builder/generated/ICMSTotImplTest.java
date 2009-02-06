package br.com.caelum.stella.nfe.builder.generated;

public final class ICMSTotImplTest {
    @org.junit.Test
    public void testICMSTotInterface() {
        ICMSTot iCMSTot = new ICMSTotImpl().withVBC("abc").withVICMS("abc").withVBCST("abc").withVST("abc").withVProd(
                "abc").withVFrete("abc").withVSeg("abc").withVDesc("abc").withVII("abc").withVIPI("abc")
                .withVPIS("abc").withVCOFINS("abc").withVOutro("abc").withVNF("abc");
        assertModelWasFilled(iCMSTot);
    }

    private void assertModelWasFilled(ICMSTot iCMSTot) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(iCMSTot).assertModelWasFilled();
    }
}