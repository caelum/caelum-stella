package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class CompraImplTest {
    @org.junit.Test
    public void testCompraInterface() {
        Compra<Object> compra = new CompraImpl<Object>(new Object()).withInformacoesDaNotaDeEmpenhoDeComprasPublicas(
                "abc").withInformacaoDoPedido("abc").withInformacaoDoContrato("abc");
        BuilderTestHelper.assertModelWasFilled(compra);
    }

}