package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.nfe.builder.generated.enums.ModalidadeDoFrete;

public interface Transporte<T> extends NFeBuilder<T> {
    public Transporte<T> withModalidadeDoFrete(ModalidadeDoFrete string);

    public Transporte<T> withTransportador(Transportador<?> transporta);

    public Transporte<T> withICMSRetidoPeloTransporte(ICMSRetidoPeloTransporte<?> retTransp);

    public Transporte<T> withVeiculoUsado(Veiculo<?> veiculo);

    public Transporte<T> withReboque(Veiculo<?>... reboques);

    public Transporte<T> withVolume(Volume<?>... vols);
}