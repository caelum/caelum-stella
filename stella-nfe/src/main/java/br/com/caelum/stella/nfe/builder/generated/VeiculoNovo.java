package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.nfe.builder.generated.enums.CondicaoDoVeiculo;
import br.com.caelum.stella.nfe.builder.generated.enums.TipoDeOperacao;

public interface VeiculoNovo<T> extends NFeBuilder<T> {
    public VeiculoNovo<T> withTipoDeOperacao(TipoDeOperacao tipoOperacao);

    public VeiculoNovo<T> withChassi(String string);

    public VeiculoNovo<T> withCodigoDaCor(String string);

    public VeiculoNovo<T> withDescricaoDaCor(String string);

    public VeiculoNovo<T> withPotenciaDoMotor(String string);

    public VeiculoNovo<T> withCM3(String string); // N�o imagino o que seja isso

    public VeiculoNovo<T> withPesoLiquido(String string);

    public VeiculoNovo<T> withPesoBruto(String string);

    public VeiculoNovo<T> withNumeroDeSerie(String string);

    public VeiculoNovo<T> withTipoDeCombustivel(String string);

    public VeiculoNovo<T> withNumeroDoMotor(String string);

    public VeiculoNovo<T> withCMKG(String string);

    public VeiculoNovo<T> withDistanciaEntreEixos(String string);

    public VeiculoNovo<T> withRENAVAM(String string);

    public VeiculoNovo<T> withAnoDoModelo(String string);

    public VeiculoNovo<T> withAnoDeFabricacao(String string);

    public VeiculoNovo<T> withTipoDePintura(String string);

    public VeiculoNovo<T> withTipoDeVeiculo(String string);

    public VeiculoNovo<T> withEspecieDeVeiculo(String string);

    public VeiculoNovo<T> withVehicleIdentificationNumber(String string);

    public VeiculoNovo<T> withCondicaoDoVeiculo(CondicaoDoVeiculo condicao);

    public VeiculoNovo<T> withCodigoDaMarcaDoModelo(String string);
}