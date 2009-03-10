package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.generated.enums.ModalidadeDoFrete;

public interface Transporte {
    public Transporte withModalidadeDoFrete(ModalidadeDoFrete string);

    public Transporte withTransportador(Transportador transporta);

    public Transporte withICMSRetidoPeloTransporte(ICMSRetidoPeloTransporte retTransp);

    public Transporte withVeiculoUsado(Veiculo veiculo);

    public Transporte withReboque(Veiculo... reboques);

    public Transporte withVolume(Volume... vols);
}