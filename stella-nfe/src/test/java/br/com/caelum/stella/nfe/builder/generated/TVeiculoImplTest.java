package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.TUf;

public final class TVeiculoImplTest {
    @org.junit.Test
    public void testTVeiculoInterface() {
        TVeiculo tVeiculo = new TVeiculoImpl().withPlaca("abc").withUF(TUf.AC).withRNTC("abc");
        assertModelWasFilled(tVeiculo);
    }

    private void assertModelWasFilled(final TVeiculo tVeiculo) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(tVeiculo).assertModelWasFilled();
    }
}