package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class TEnviNFeImplTest {
    @org.junit.Test
    public void testTEnviNFeInterface() {
        PedidoDeAutorizacaoDaNFE<Object> tEnviNFe = new PedidoDeAutorizacaoDaNFEImpl<Object>(new Object())
                                                                                                          .withIdDoLote(
                                                                                                                  "abc")
                                                                                                          .withNFE(
                                                                                                                  new NFEImpl<Object>(
                                                                                                                          new Object()))
                                                                                                          .withVersao(
                                                                                                                  "abc");
        BuilderTestHelper.assertModelWasFilled(tEnviNFe);
    }

}