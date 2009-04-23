package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.TUf;

public final class InfAtuCadEmiDFeImplTest {
    @org.junit.Test
    public void testInfAtuCadEmiDFeInterface() {
        InfAtuCadEmiDFe infAtuCadEmiDFe = new InfAtuCadEmiDFeImpl()
                                                                   .withUF(TUf.AC)
                                                                   .withInclui(new TEmissorImpl())
                                                                   .withExclui(new ExcluiImpl())
                                                                   .withId("abc");
        assertModelWasFilled(infAtuCadEmiDFe);
    }

    private void assertModelWasFilled(final InfAtuCadEmiDFe infAtuCadEmiDFe) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(infAtuCadEmiDFe).assertModelWasFilled();
    }
}