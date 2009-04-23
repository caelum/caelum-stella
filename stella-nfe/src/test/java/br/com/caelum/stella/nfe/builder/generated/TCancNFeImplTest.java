package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TCancNFeImplTest {
    @org.junit.Test
    public void testTCancNFeInterface() {
        TCancNFe tCancNFe = new TCancNFeImpl()
                                              .withInfCanc(new InfCancImpl())
                                              .withSignature(new SignatureType())
                                              .withVersao("abc");
        assertModelWasFilled(tCancNFe);
    }

    private void assertModelWasFilled(final TCancNFe tCancNFe) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(tCancNFe).assertModelWasFilled();
    }
}