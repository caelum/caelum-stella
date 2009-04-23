package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TCadEmiDFeImplTest {
    @org.junit.Test
    public void testTCadEmiDFeInterface() {
        TCadEmiDFe tCadEmiDFe = new TCadEmiDFeImpl().withInfCadEmiDFe(new InfCadEmiDFeImpl()).withSignature(
                new SignatureType()).withVersao("abc");
        assertModelWasFilled(tCadEmiDFe);
    }

    private void assertModelWasFilled(final TCadEmiDFe tCadEmiDFe) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(tCadEmiDFe).assertModelWasFilled();
    }
}