package br.com.caelum.stella.nfe.builder.generated;

public final class TEnviNFeImplTest {
    @org.junit.Test
    public void testTEnviNFeInterface() {
        PedidoDeAutorizacaoDaNFE tEnviNFe = new PedidoDeAutorizacaoDaNFEImpl().withIdDoLote("abc").withNFE(new NFEImpl()).withVersao("abc");
        assertModelWasFilled(tEnviNFe);
    }

    private void assertModelWasFilled(final PedidoDeAutorizacaoDaNFE tEnviNFe) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(tEnviNFe).assertModelWasFilled();
    }
}