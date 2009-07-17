package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.modelo.UF;

public final class DIImplTest {
    @org.junit.Test
    public void testDIInterface() {
        DeclaracaoDeImportacao<Object> dI = new DeclaracaoDeImportacaoImpl<Object>(new Object())
                                                                                                .withNumeroDoDocumentoDeImportacao(
                                                                                                        "abc")
                                                                                                .withDataDaDeclaracaoDeImportacao(
                                                                                                        Calendar
                                                                                                                .getInstance())
                                                                                                .withLocalDeDesenbaraco(
                                                                                                        "abc")
                                                                                                .withUFDoDesembaraco(
                                                                                                        UF.AC)
                                                                                                .withDataDoDeembaraco(
                                                                                                        Calendar
                                                                                                                .getInstance())
                                                                                                .withCodigoDoExportador(
                                                                                                        "abc")
                                                                                                .withAdicoes(
                                                                                                        new AdicoesImpl<Object>(
                                                                                                                new Object()));
        BuilderTestHelper.assertModelWasFilled(dI);
    }

}