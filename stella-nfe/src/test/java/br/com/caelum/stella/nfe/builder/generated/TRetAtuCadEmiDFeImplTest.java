package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TRetAtuCadEmiDFeImplTest {
    @org.junit.Test
    public void testTRetAtuCadEmiDFeInterface() {
        TRetAtuCadEmiDFe tRetAtuCadEmiDFe = new TRetAtuCadEmiDFeImpl().withInfRetAtuCadEmiDFe(
                new InfRetAtuCadEmiDFeImpl()).withSignature(new SignatureType()).withVersao("abc");
        assertModelWasFilled(tRetAtuCadEmiDFe);
    }

    private void assertModelWasFilled(final TRetAtuCadEmiDFe tRetAtuCadEmiDFe) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(tRetAtuCadEmiDFe).assertModelWasFilled();
    }
}