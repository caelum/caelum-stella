package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TInutNFeImplTest {
    @org.junit.Test
    public void testTInutNFeInterface() {
        TInutNFe tInutNFe = new TInutNFeImpl()
                                              .withInfInut(new InfInutImpl())
                                              .withSignature(new SignatureType())
                                              .withVersao("abc");
        assertModelWasFilled(tInutNFe);
    }

    private void assertModelWasFilled(final TInutNFe tInutNFe) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(tInutNFe).assertModelWasFilled();
    }
}