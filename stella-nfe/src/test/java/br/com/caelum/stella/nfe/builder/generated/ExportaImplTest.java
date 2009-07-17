package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.modelo.UF;

public final class ExportaImplTest {
    @org.junit.Test
    public void testExportaInterface() {
        Exportacao<Object> exporta = new ExportacaoImpl<Object>(new Object())
                                                                             .withUFDoEmbarque(UF.AC)
                                                                             .withLocalDoEmbarque("abc");
        BuilderTestHelper.assertModelWasFilled(exporta);
    }

}