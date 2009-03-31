package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

import br.com.caelum.stella.nfe.modelo.UF;

public final class DIImplTest {
    @org.junit.Test
    public void testDIInterface() {
        DeclaracaoDeImportacao dI = new DeclaracaoDeImportacaoImpl().withNumeroDoDocumentoDeImportacao("abc").withDataDaDeclaracaoDeImportacao(Calendar.getInstance()).withLocalDeDesenbaraco("abc").withUFDoDesembaraco(UF.AC)
                .withDataDoDeembaraco(Calendar.getInstance()).withCodigoDoExportador("abc").withAdicoes(new AdicoesImpl());
        assertModelWasFilled(dI);
    }

    private void assertModelWasFilled(final DeclaracaoDeImportacao dI) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(dI).assertModelWasFilled();
    }
}