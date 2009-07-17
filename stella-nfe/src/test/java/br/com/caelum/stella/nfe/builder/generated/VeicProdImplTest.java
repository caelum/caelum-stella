package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.builder.generated.enums.CondicaoDoVeiculo;
import br.com.caelum.stella.nfe.builder.generated.enums.TipoDeOperacao;

public final class VeicProdImplTest {
    @org.junit.Test
    public void testVeicProdInterface() {
        VeiculoNovo<Object> veicProd = new VeiculoNovoImpl<Object>(new Object())
                                                                                .withTipoDeOperacao(
                                                                                        TipoDeOperacao.FATURAMENTO_DIRETO)
                                                                                .withChassi("abc")
                                                                                .withCodigoDaCor("abc")
                                                                                .withDescricaoDaCor("abc")
                                                                                .withPotenciaDoMotor("abc")
                                                                                .withCM3("abc")
                                                                                .withPesoLiquido("abc")
                                                                                .withPesoBruto("abc")
                                                                                .withNumeroDeSerie("abc")
                                                                                .withTipoDeCombustivel("abc")
                                                                                .withNumeroDoMotor("abc")
                                                                                .withCMKG("abc")
                                                                                .withDistanciaEntreEixos("abc")
                                                                                .withRENAVAM("abc")
                                                                                .withAnoDoModelo("abc")
                                                                                .withAnoDeFabricacao("abc")
                                                                                .withTipoDePintura("abc")
                                                                                .withTipoDeVeiculo("abc")
                                                                                .withEspecieDeVeiculo("abc")
                                                                                .withVehicleIdentificationNumber("abc")
                                                                                .withCondicaoDoVeiculo(
                                                                                        CondicaoDoVeiculo.ACABADO)
                                                                                .withCodigoDaMarcaDoModelo("abc");
        BuilderTestHelper.assertModelWasFilled(veicProd);
    }

}