package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class CabecMsgImplTest {
    @org.junit.Test
    public void testCabecMsgInterface() {
        Cabecalho<Object> cabecMsg = new CabecalhoImpl<Object>(new Object()).withVersaoDados("abc").withVersao("abc");
        BuilderTestHelper.assertModelWasFilled(cabecMsg);
    }
}