package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.TUf;

public final class InfRetAtuCadEmiDFeImplTest {
    @org.junit.Test
    public void testInfRetAtuCadEmiDFeInterface() {
        InfRetAtuCadEmiDFe infRetAtuCadEmiDFe = new InfRetAtuCadEmiDFeImpl()
                                                                            .withUF(TUf.AC)
                                                                            .withCNPJ(new Object())
                                                                            .withOpe("abc")
                                                                            .withResOpe("abc")
                                                                            .withId("abc");
        assertModelWasFilled(infRetAtuCadEmiDFe);
    }

    private void assertModelWasFilled(final InfRetAtuCadEmiDFe infRetAtuCadEmiDFe) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(infRetAtuCadEmiDFe).assertModelWasFilled();
    }
}