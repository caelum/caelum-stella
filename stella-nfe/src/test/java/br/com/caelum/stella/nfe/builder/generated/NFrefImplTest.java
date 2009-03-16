package br.com.caelum.stella.nfe.builder.generated;

public final class NFrefImplTest {
    @org.junit.Test
    public void testNFrefInterface() {
        InformacoesDaNFReferenciada nFref = new InformacoesDaNFReferenciadaImpl().withChaveDeAcessoDaNFReferenciada("abc").withNFReferenciada(new NFReferenciadaImpl());
        assertModelWasFilled(nFref);
    }

    private void assertModelWasFilled(final InformacoesDaNFReferenciada nFref) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(nFref).assertModelWasFilled();
    }
}