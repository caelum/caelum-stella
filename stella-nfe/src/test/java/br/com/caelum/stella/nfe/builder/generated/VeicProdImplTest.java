package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.generated.enums.CondicaoDoVeiculo;
import br.com.caelum.stella.nfe.builder.generated.enums.TipoOperacao;

public final class VeicProdImplTest {
    @org.junit.Test
    public void testVeicProdInterface() {
        VeicProd veicProd = new VeicProdImpl().withTpOp(TipoOperacao.FATURAMENTO_DIRETO).withChassi("abc").withCCor(
                "abc").withXCor("abc").withPot("abc").withCM3("abc").withPesoL("abc").withPesoB("abc")
                .withNSerie("abc").withTpComb("abc").withNMotor("abc").withCMKG("abc").withDist("abc").withRENAVAM(
                        "abc").withAnoMod("abc").withAnoFab("abc").withTpPint("abc").withTpVeic("abc").withEspVeic(
                        "abc").withVIN("abc").withCondVeic(CondicaoDoVeiculo.ACABADO).withCMod("abc");
        assertModelWasFilled(veicProd);
    }

    private void assertModelWasFilled(final VeicProd veicProd) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(veicProd).assertModelWasFilled();
    }
}