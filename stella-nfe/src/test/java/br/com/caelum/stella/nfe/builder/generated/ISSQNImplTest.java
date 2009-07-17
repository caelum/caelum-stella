package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.builder.ISS;
import br.com.caelum.stella.nfe.builder.impl.ISSQNImpl;

public final class ISSQNImplTest {
    @org.junit.Test
    public void testISSQNInterface() {
        ISS<Object> iSSQN = new ISSQNImpl<Object>(new Object())
                                                               .withValorDaBaseDeCalculo(new BigDecimal(1))
                                                               .withAliquota(new BigDecimal("1"))
                                                               .withValor(new BigDecimal("1"))
                                                               .withCodigoMunicipio(1)
                                                               .withCodigoListaServicos(1);
        BuilderTestHelper.assertModelWasFilled(iSSQN);
    }

}