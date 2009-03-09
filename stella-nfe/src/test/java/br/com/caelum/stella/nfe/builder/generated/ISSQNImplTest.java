package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.ISS;
import br.com.caelum.stella.nfe.builder.impl.ISSQNImpl;

public final class ISSQNImplTest {
    @org.junit.Test
    public void testISSQNInterface() {
        ISS iSSQN = new ISSQNImpl().withValorDaBaseDeCalculo(new BigDecimal(1)).withAliquota(new BigDecimal("1"))
                .withValor(new BigDecimal("1")).withCodigoMunicipio(1).withCodigoListaServicos(1);
        assertModelWasFilled(iSSQN);
    }

    private void assertModelWasFilled(final ISS iSSQN) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(iSSQN).assertModelWasFilled();
    }
}