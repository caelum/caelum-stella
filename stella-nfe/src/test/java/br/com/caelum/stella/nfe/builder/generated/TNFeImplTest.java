package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TNFeImplTest {
    @org.junit.Test
    public void testTNFeInterface() {
        NFE tNFe = new NFEImpl().withInformacoesDaNFE(new InfNFeImpl()).withSignature(new SignatureType());
        assertModelWasFilled(tNFe);
    }

    private void assertModelWasFilled(final NFE tNFe) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(tNFe).assertModelWasFilled();
    }
}