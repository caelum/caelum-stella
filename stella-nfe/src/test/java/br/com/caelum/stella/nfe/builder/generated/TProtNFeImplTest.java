package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TProtNFeImplTest {
    @org.junit.Test
    public void testTProtNFeInterface() {
        TProtNFe tProtNFe = new TProtNFeImpl()
                                .withInfProt(new InfProtImpl())
                                .withVersao("abc")
                                .withSignature(new SignatureType());
        assertModelWasFilled(tProtNFe);
    }

    private void assertModelWasFilled(final TProtNFe tProtNFe) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(tProtNFe).assertModelWasFilled();
    }
}