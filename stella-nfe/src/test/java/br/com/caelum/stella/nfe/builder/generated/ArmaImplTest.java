package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.builder.generated.enums.TipoDeArmamento;

public final class ArmaImplTest {
    @org.junit.Test
    public void testArmaInterface() {
        Armamento<Object> arma = new ArmamentoImpl<Object>(new Object())
                                                                        .withTipo(TipoDeArmamento.USO_PERMITIDO)
                                                                        .withNumeroDeSerie(new Integer(0))
                                                                        .withNumeroDeSerieDoCano(new Integer(0))
                                                                        .withDescricao("abc");
        BuilderTestHelper.assertModelWasFilled(arma);
    }

}