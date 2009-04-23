package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.TUf;

public final class ExcluiImplTest {
    @org.junit.Test
    public void testExcluiInterface() {
        Exclui exclui = new ExcluiImpl().withUF(TUf.AC).withCNPJ(new Object());
        assertModelWasFilled(exclui);
    }

    private void assertModelWasFilled(final Exclui exclui) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(exclui).assertModelWasFilled();
    }
}