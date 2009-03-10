package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.generated.enums.ModalidadeDoFrete;

public final class TranspImplTest {
    @org.junit.Test
    public void testTranspInterface() {
        Transporte transp = new TransporteImpl().withModalidadeDoFrete(ModalidadeDoFrete.PAGO_PELO_DESTINATARIO)
                .withTransportador(new TransportadorImpl()).withICMSRetidoPeloTransporte(new ICMSRetidoPeloTransporteImpl()).withVeiculoUsado(
                        new VeiculoImpl()).withReboque(new VeiculoImpl()).withVolume(new VolumeImpl());
        assertModelWasFilled(transp);
    }

    private void assertModelWasFilled(final Transporte transp) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(transp).assertModelWasFilled();
    }
}