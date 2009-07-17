package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class COFINSNTImplTest {
    @org.junit.Test
    public void testCOFINSNTInterface() {
        COFINSNaoTributado<Object> cOFINSNT = new COFINSNaoTributadoImpl<Object>(new Object())
                                                                                              .withCodigoSituacaoTributaria("abc");
        BuilderTestHelper.assertModelWasFilled(cOFINSNT);
    }

}