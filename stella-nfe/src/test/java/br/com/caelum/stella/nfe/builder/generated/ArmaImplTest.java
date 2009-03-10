package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.generated.enums.TipoDeArmamento;

public final class ArmaImplTest {
    @org.junit.Test
    public void testArmaInterface() {
        Armamento arma = new ArmamentoImpl()
        .withTipo(TipoDeArmamento.USO_PERMITIDO)
        .withNumeroDeSerie(new Integer(0))
        .withNumeroDeSerieDoCano(new Integer(0))
        .withDescricao("abc");
        assertModelWasFilled(arma);
    }

    private void assertModelWasFilled(Armamento arma) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(arma).assertModelWasFilled();
    }
}