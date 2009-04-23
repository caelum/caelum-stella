package br.com.caelum.stella.nfe.builder.generated;

public final class TProcInutNFeImplTest {
    @org.junit.Test
    public void testTProcInutNFeInterface() {
        TProcInutNFe tProcInutNFe = new TProcInutNFeImpl().withInutNFe(new TInutNFeImpl()).withRetInutNFe(
                new TRetInutNFeImpl()).withVersao("abc");
        assertModelWasFilled(tProcInutNFe);
    }

    private void assertModelWasFilled(final TProcInutNFe tProcInutNFe) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(tProcInutNFe).assertModelWasFilled();
    }
}