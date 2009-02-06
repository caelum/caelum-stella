package br.com.caelum.stella.nfe.builder.generated;

public final class NFrefImplTest {
    @org.junit.Test
    public void testNFrefInterface() {
        NFref nFref = new NFrefImpl().withRefNFe("abc").withRefNF(new RefNFImpl());
        assertModelWasFilled(nFref);
    }

    private void assertModelWasFilled(final NFref nFref) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(nFref).assertModelWasFilled();
    }
}