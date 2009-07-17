package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class PISNTImplTest {
    @org.junit.Test
    public void testPISNTInterface() {
        PISNaoTributado<Object> pISNT = new PISNaoTributadoImpl<Object>(new Object())
                                                                                     .withCodigoSituacaoTributaria("abc");
        BuilderTestHelper.assertModelWasFilled(pISNT);
    }

}