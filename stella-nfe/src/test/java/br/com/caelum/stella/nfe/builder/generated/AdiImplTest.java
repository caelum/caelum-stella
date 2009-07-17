package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class AdiImplTest {
    @org.junit.Test
    public void testAdiInterface() {
        Adicao<Object> adi = new AdicoesImpl<Object>(new Object())
                                                                  .withNumeroDaAdicao(123)
                                                                  .withNumeroSequencialDoItemDaAdicao(123)
                                                                  .withCodigoDoFabricanteEstrangeiro("abc")
                                                                  .withValorDeDescontoDoItemDaDI(BigDecimal.ONE);
        BuilderTestHelper.assertModelWasFilled(adi);
    }

}