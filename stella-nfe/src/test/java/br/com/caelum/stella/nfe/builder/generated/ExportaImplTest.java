package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.TUf;

public final class ExportaImplTest {
    @org.junit.Test
    public void testExportaInterface() {
        Exporta exporta = new ExportaImpl().withUFEmbarq(TUf.AC).withXLocEmbarq("abc");
        assertModelWasFilled(exporta);
    }

    private void assertModelWasFilled(final Exporta exporta) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(exporta).assertModelWasFilled();
    }
}