package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.builder.generated.enums.OrigemDoProcesso;

public final class ProcRefImplTest {
    @org.junit.Test
    public void testProcRefInterface() {
        ProcessoReferenciado<Object> procRef = new ProcessoReferenciadoImpl<Object>(new Object())
                                                                                                 .withIdentificadorDoProcesso(
                                                                                                         "abc")
                                                                                                 .withOrigemDoProcesso(
                                                                                                         OrigemDoProcesso.JUSTICA_ESTADUAL);
        BuilderTestHelper.assertModelWasFilled(procRef);
    }

}