package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.generated.enums.CondicaoDoVeiculo;
import br.com.caelum.stella.nfe.builder.generated.enums.TipoDeOperacao;

public interface VeiculoNovo {
    public VeiculoNovo withTipoDeOperacao(TipoDeOperacao tipoOperacao);

    public VeiculoNovo withChassi(String string);

    public VeiculoNovo withCodigoDaCor(String string);

    public VeiculoNovo withDescricaoDaCor(String string);

    public VeiculoNovo withPotenciaDoMotor(String string);

    public VeiculoNovo withCM3(String string); // N‹o imagino o que seja isso

    public VeiculoNovo withPesoLiquido(String string);

    public VeiculoNovo withPesoBruto(String string);

    public VeiculoNovo withNumeroDeSerie(String string);

    public VeiculoNovo withTipoDeCombustivel(String string);

    public VeiculoNovo withNumeroDoMotor(String string);

    public VeiculoNovo withCMKG(String string);

    public VeiculoNovo withDistanciaEntreEixos(String string);

    public VeiculoNovo withRENAVAM(String string);

    public VeiculoNovo withAnoDoModelo(String string);

    public VeiculoNovo withAnoDeFabricacao(String string);

    public VeiculoNovo withTipoDePintura(String string);

    public VeiculoNovo withTipoDeVeiculo(String string);

    public VeiculoNovo withEspecieDeVeiculo(String string);

    public VeiculoNovo withVehicleIdentificationNumber(String string);

    public VeiculoNovo withCondicaoDoVeiculo(CondicaoDoVeiculo condicao);

    public VeiculoNovo withCodigoDaMarcaDoModelo(String string);
}