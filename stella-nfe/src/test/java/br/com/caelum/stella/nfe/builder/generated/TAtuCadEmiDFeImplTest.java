package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TAtuCadEmiDFeImplTest {
    @org.junit.Test
    public void testTAtuCadEmiDFeInterface() {
        TAtuCadEmiDFe tAtuCadEmiDFe = new TAtuCadEmiDFeImpl()
                                                             .withInfAtuCadEmiDFe(new InfAtuCadEmiDFeImpl())
                                                             .withSignature(new SignatureType())
                                                             .withVersao("abc");
        assertModelWasFilled(tAtuCadEmiDFe);
    }

    private void assertModelWasFilled(final TAtuCadEmiDFe tAtuCadEmiDFe) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(tAtuCadEmiDFe).assertModelWasFilled();
    }
}