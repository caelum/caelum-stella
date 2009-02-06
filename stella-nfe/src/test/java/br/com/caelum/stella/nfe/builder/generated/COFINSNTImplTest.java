package br.com.caelum.stella.nfe.builder.generated;

public final class COFINSNTImplTest {
    @org.junit.Test
    public void testCOFINSNTInterface() {
        COFINSNT cOFINSNT = new COFINSNTImpl().withCST("abc");
        assertModelWasFilled(cOFINSNT);
    }

    private void assertModelWasFilled(COFINSNT cOFINSNT) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(cOFINSNT).assertModelWasFilled();
    }
}