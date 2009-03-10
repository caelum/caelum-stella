package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class PISOutrImplTest {
    @org.junit.Test
    public void testPISOutrInterface() {
        PISOutrasOperacoes pISOutr = new PISOutrasOperacoesImpl().withValorDaBaseDeCalculo(new BigDecimal(1)).withAliquota(
                new BigDecimal(1)).withQuantidadeVendida(new BigDecimal(1)).withAliquotaDoProduto(new BigDecimal(1)).withValor(
                new BigDecimal(1));
        assertModelWasFilled(pISOutr);
    }

    private void assertModelWasFilled(final PISOutrasOperacoes pISOutr) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(pISOutr).assertModelWasFilled();
    }
}