package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.InfProt;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TRetConsSitNFeImplTest {
    @org.junit.Test
    public void testTRetConsSitNFeInterface() {
        TRetConsSitNFe tRetConsSitNFe = new TRetConsSitNFeImpl().withInfProt(new InfProt()).withSignature(
                new SignatureType()).withVersao("abc");
        assertModelWasFilled(tRetConsSitNFe);
    }

    private void assertModelWasFilled(final TRetConsSitNFe tRetConsSitNFe) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(tRetConsSitNFe).assertModelWasFilled();
    }
}