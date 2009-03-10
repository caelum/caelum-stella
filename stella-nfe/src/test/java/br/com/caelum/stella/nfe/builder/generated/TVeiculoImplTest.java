package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.UF;

public final class TVeiculoImplTest {
    @org.junit.Test
    public void testTVeiculoInterface() {
        Veiculo tVeiculo = new VeiculoImpl().withPlaca("abc").withUF(UF.AC).withRegistroNacionalDoTransportadorDeCarga("abc");
        assertModelWasFilled(tVeiculo);
    }

    private void assertModelWasFilled(final Veiculo tVeiculo) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(tVeiculo).assertModelWasFilled();
    }
}