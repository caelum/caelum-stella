package br.com.caelum.stella.nfe.builder.generated;

public final class TEnviNFeImplTest {
    @org.junit.Test
    public void testTEnviNFeInterface() {
        TEnviNFe tEnviNFe = new TEnviNFeImpl().withIdLote("abc").withNFe(new TNFeImpl()).withVersao("abc");
        assertModelWasFilled(tEnviNFe);
    }

    private void assertModelWasFilled(final TEnviNFe tEnviNFe) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(tEnviNFe).assertModelWasFilled();
    }
}