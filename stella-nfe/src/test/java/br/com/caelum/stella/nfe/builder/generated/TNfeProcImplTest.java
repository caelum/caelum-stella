package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class TNfeProcImplTest {
    @org.junit.Test
    public void testTNfeProcInterface() {
        NFEProcessada<Object> tNfeProc = new NFEProcessadaImpl<Object>(new Object()).withNFE(
                new NFEImpl<Object>(new Object())).withProtocoloDoResultadoDeProcessamento(
                new ProtocoloDoResultadoDeProcessamentoImpl<Object>(new Object())).withVersao("abc");
        BuilderTestHelper.assertModelWasFilled(tNfeProc);
    }

}