package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.UF;

public final class ExportaImplTest {
    @org.junit.Test
    public void testExportaInterface() {
        Exportacao exporta = new ExportacaoImpl().withUFDoEmbarque(UF.AC).withLocalDoEmbarque("abc");
        assertModelWasFilled(exporta);
    }

    private void assertModelWasFilled(final Exportacao exporta) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(exporta).assertModelWasFilled();
    }
}