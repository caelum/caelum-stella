package br.com.caelum.stella.nfe.builder.generated;

public final class TProcCancNFeImplTest {
    @org.junit.Test
    public void testTProcCancNFeInterface() {
        TProcCancNFe tProcCancNFe = new TProcCancNFeImpl().withCancNFe(new TCancNFeImpl()).withRetCancNFe(
                new TRetCancNFeImpl()).withVersao("abc");
        assertModelWasFilled(tProcCancNFe);
    }

    private void assertModelWasFilled(final TProcCancNFe tProcCancNFe) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(tProcCancNFe).assertModelWasFilled();
    }
}