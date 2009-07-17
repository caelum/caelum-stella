package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.modelo.UF;

public final class TVeiculoImplTest {
    @org.junit.Test
    public void testTVeiculoInterface() {
        Veiculo<Object> tVeiculo = new VeiculoImpl<Object>(new Object())
                                                                        .withPlaca("abc")
                                                                        .withUF(UF.AC)
                                                                        .withRegistroNacionalDoTransportadorDeCarga(
                                                                                "abc");
        BuilderTestHelper.assertModelWasFilled(tVeiculo);
    }

}