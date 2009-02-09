package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TNFeImplTest {
    @org.junit.Test
    public void testTNFeInterface() {
        TNFe tNFe = new TNFeImpl().withInfNFe(new InfNFeImpl()).withSignature(new SignatureType());
        assertModelWasFilled(tNFe);
    }

    private void assertModelWasFilled(final TNFe tNFe) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(tNFe).assertModelWasFilled();
    }
}