package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.builder.generated.enums.ModalidadeDoFrete;

public final class TranspImplTest {
    @org.junit.Test
    public void testTranspInterface() {
        Transporte<Object> transp = new TransporteImpl<Object>(new Object())
                                                                            .withModalidadeDoFrete(
                                                                                    ModalidadeDoFrete.PAGO_PELO_DESTINATARIO)
                                                                            .withTransportador(
                                                                                    new TransportadorImpl<Object>(
                                                                                            new Object()))
                                                                            .withICMSRetidoPeloTransporte(
                                                                                    new ICMSRetidoPeloTransporteImpl<Object>(
                                                                                            new Object()))
                                                                            .withVeiculoUsado(
                                                                                    new VeiculoImpl<Object>(
                                                                                            new Object()))
                                                                            .withReboque(
                                                                                    new VeiculoImpl<Object>(
                                                                                            new Object()))
                                                                            .withVolume(
                                                                                    new VolumeImpl<Object>(new Object()));
        BuilderTestHelper.assertModelWasFilled(transp);
    }

}