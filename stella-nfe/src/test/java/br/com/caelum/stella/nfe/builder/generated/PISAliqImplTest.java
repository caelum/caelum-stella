package br.com.caelum.stella.nfe.builder.generated;

public final class PISAliqImplTest {
    @org.junit.Test
    public void testPISAliqInterface() {
        PISAliq pISAliq = new PISAliqImpl().withCodigoSituacaoTributaria("abc").withVBC("abc").withPPIS("abc").withVPIS("abc");
        assertModelWasFilled(pISAliq);
    }

    private void assertModelWasFilled(PISAliq pISAliq) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(pISAliq).assertModelWasFilled();
    }
}