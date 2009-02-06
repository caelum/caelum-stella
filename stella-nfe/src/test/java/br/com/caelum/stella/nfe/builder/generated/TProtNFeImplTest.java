package br.com.caelum.stella.nfe.builder.generated;

public final class TProtNFeImplTest {
    @org.junit.Test
    public void testTProtNFeInterface() {
        TProtNFe tProtNFe = new TProtNFeImpl().withInfProt(new InfProtImpl()).withVersao("abc");
        assertModelWasFilled(tProtNFe);
    }

    private void assertModelWasFilled(final TProtNFe tProtNFe) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(tProtNFe).assertModelWasFilled();
    }
}