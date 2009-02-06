package br.com.caelum.stella.nfe.builder.generated;

public final class RefNFImplTest {
    @org.junit.Test
    public void testRefNFInterface() {
        RefNF refNF = new RefNFImpl().withCUF("abc").withAAMM("abc").withCNPJ("abc").withMod("abc").withSerie("abc")
                .withNNF("abc");
        assertModelWasFilled(refNF);
    }

    private void assertModelWasFilled(RefNF refNF) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(refNF).assertModelWasFilled();
    }
}