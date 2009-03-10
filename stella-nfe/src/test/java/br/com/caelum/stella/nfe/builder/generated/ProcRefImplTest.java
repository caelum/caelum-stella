package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.generated.enums.OrigemDoProcesso;

public final class ProcRefImplTest {
    @org.junit.Test
    public void testProcRefInterface() {
        ProcessoReferenciado procRef = new ProcessoReferenciadoImpl().withIdentificadorDoProcesso("abc")
                .withOrigemDoProcesso(OrigemDoProcesso.JUSTICA_ESTADUAL);
        assertModelWasFilled(procRef);
    }

    private void assertModelWasFilled(final ProcessoReferenciado procRef) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(procRef).assertModelWasFilled();
    }
}