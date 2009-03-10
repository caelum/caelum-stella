package br.com.caelum.stella.nfe.builder.generated;

public final class TNfeProcImplTest {
    @org.junit.Test
    public void testTNfeProcInterface() {
        NFEProcessada tNfeProc = new NFEProcessadaImpl().withNFE(new NFEImpl()).withProtocoloDoResultadoDeProcessamento(new ProtocoloDoResultadoDeProcessamentoImpl())
                .withVersao("abc");
        assertModelWasFilled(tNfeProc);
    }

    private void assertModelWasFilled(final NFEProcessada tNfeProc) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(tNfeProc).assertModelWasFilled();
    }
}