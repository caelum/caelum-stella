package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class PISSTImplTest {
    @org.junit.Test
    public void testPISSTInterface() {
        PISSubstituicaoTributaria pISST = new PISSubstituicaoTributariaImpl().withValorDaBaseDeCalculo(new BigDecimal(1)).withAliquotaDaSubstituicaoTributaria(new BigDecimal(1)).withQuantidadeVendida(
                new BigDecimal(1)).withAliquota(new BigDecimal(1)).withValor(new BigDecimal(1));
        assertModelWasFilled(pISST);
    }

    private void assertModelWasFilled(final PISSubstituicaoTributaria pISST) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(pISST).assertModelWasFilled();
    }
}