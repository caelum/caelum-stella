package br.com.caelum.stella.nfe.builder.generated;

public final class TNfeProcImplTest {
    @org.junit.Test
    public void testTNfeProcInterface() {
        TNfeProc tNfeProc = new TNfeProcImpl().withNFe(new TNFeImpl()).withProtNFe(new TProtNFeImpl())
                .withVersao("abc");
        assertModelWasFilled(tNfeProc);
    }

    private void assertModelWasFilled(final TNfeProc tNfeProc) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(tNfeProc).assertModelWasFilled();
    }
}