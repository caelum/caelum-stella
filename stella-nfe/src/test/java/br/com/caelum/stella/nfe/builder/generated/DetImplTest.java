package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.builder.Impostos;

public final class DetImplTest {
    @org.junit.Test
    public void testDetInterface() {
        Detalhe<Object> det = new DetalheImpl<Object>(new Object())
                                                                   .withProduto(new ProdutoImpl<Object>(new Object()))
                                                                   .withImposto(new Impostos())
                                                                   .withInformacaoAdicionalDoProduto("abc")
                                                                   .withNumeroDoItemNaNF("abc");
        BuilderTestHelper.assertModelWasFilled(det);
    }

}