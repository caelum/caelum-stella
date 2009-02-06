package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.ICMSBuilder;
import br.com.caelum.stella.nfe.builder.impl.IIImpl;

public final class ImpostoImplTest {
    @org.junit.Test
    public void testImpostoInterface() {
        Imposto imposto = new ImpostoImpl().withICMS(new ICMSBuilder().cobradoAnteriormentePorSubstituicao()).withIPI(
                new IPIImpl()).withII(new IIImpl()).withPIS(new PISImpl()).withPISST(new PISSTImpl()).withCOFINS(
                new COFINSImpl()).withCOFINSST(new COFINSSTImpl()).withISSQN(new ISSQNImpl());
        assertModelWasFilled(imposto);
    }

    private void assertModelWasFilled(final Imposto imposto) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(imposto).assertModelWasFilled();
    }
}