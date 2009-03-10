package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.UF;

public final class ExportaImplTest {
    @org.junit.Test
    public void testExportaInterface() {
        Exporta exporta = new ExportaImpl().withUFEmbarq(UF.AC).withXLocEmbarq("abc");
        assertModelWasFilled(exporta);
    }

    private void assertModelWasFilled(final Exporta exporta) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(exporta).assertModelWasFilled();
    }
}