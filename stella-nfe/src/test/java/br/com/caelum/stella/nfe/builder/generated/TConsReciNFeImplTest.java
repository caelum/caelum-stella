package br.com.caelum.stella.nfe.builder.generated;

public final class TConsReciNFeImplTest {
    @org.junit.Test
    public void testTConsReciNFeInterface() {
        TConsReciNFe tConsReciNFe = new TConsReciNFeImpl().withTpAmb("abc").withNRec("abc").withVersao("abc");
        assertModelWasFilled(tConsReciNFe);
    }

    private void assertModelWasFilled(TConsReciNFe tConsReciNFe) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(tConsReciNFe).assertModelWasFilled();
    }
}