package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TRetCancNFeImplTest {
    @org.junit.Test
    public void testTRetCancNFeInterface() {
        TRetCancNFe tRetCancNFe = new TRetCancNFeImpl().withInfCanc(new InfCancImpl()).withSignature(
                new SignatureType()).withVersao("abc");
        assertModelWasFilled(tRetCancNFe);
    }

    private void assertModelWasFilled(final TRetCancNFe tRetCancNFe) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(tRetCancNFe).assertModelWasFilled();
    }
}