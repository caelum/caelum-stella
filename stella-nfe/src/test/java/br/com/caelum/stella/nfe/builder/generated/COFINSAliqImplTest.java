package br.com.caelum.stella.nfe.builder.generated;

public final class COFINSAliqImplTest {
    @org.junit.Test
    public void testCOFINSAliqInterface() {
        COFINSAliq cOFINSAliq = new COFINSAliqImpl().withCST("abc").withVBC("abc").withPCOFINS("abc")
                .withVCOFINS("abc");
        assertModelWasFilled(cOFINSAliq);
    }

    private void assertModelWasFilled(COFINSAliq cOFINSAliq) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(cOFINSAliq).assertModelWasFilled();
    }
}