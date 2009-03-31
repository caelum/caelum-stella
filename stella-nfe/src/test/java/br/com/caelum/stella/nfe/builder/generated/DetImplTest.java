package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.Impostos;

public final class DetImplTest {
    @org.junit.Test
    public void testDetInterface() {
        Detalhe det = new DetalheImpl().withProduto(new ProdutoImpl()).withImposto(new Impostos()).withInformacaoAdicionalDoProduto("abc").withNumeroDoItemNaNF(
                "abc");
        assertModelWasFilled(det);
    }

    private void assertModelWasFilled(final Detalhe det) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(det).assertModelWasFilled();
    }
}