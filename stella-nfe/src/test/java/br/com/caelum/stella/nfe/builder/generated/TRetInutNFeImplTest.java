package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TRetInutNFeImplTest {
    @org.junit.Test
    public void testTRetInutNFeInterface() {
        TRetInutNFe tRetInutNFe = new TRetInutNFeImpl().withInfInut(new InfInutImpl()).withSignature(
                new SignatureType()).withVersao("abc");
        assertModelWasFilled(tRetInutNFe);
    }

    private void assertModelWasFilled(final TRetInutNFe tRetInutNFe) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(tRetInutNFe).assertModelWasFilled();
    }
}