package br.com.caelum.stella.nfe.builder.generated;

public final class VeicProdImplTest {
    @org.junit.Test
    public void testVeicProdInterface() {
        VeicProd veicProd = new VeicProdImpl().withTpOp("abc").withChassi("abc").withCCor("abc").withXCor("abc")
                .withPot("abc").withCM3("abc").withPesoL("abc").withPesoB("abc").withNSerie("abc").withTpComb("abc")
                .withNMotor("abc").withCMKG("abc").withDist("abc").withRENAVAM("abc").withAnoMod("abc").withAnoFab(
                        "abc").withTpPint("abc").withTpVeic("abc").withEspVeic("abc").withVIN("abc")
                .withCondVeic("abc").withCMod("abc");
        assertModelWasFilled(veicProd);
    }

    private void assertModelWasFilled(VeicProd veicProd) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(veicProd).assertModelWasFilled();
    }
}