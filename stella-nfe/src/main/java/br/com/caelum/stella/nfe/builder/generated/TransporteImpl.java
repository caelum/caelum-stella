package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.builder.generated.enums.ModalidadeDoFrete;

public final class TransporteImpl implements Transporte, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Transp transp;

    public TransporteImpl() {
        transp = new br.com.caelum.stella.nfe.modelo.Transp();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.transp;
    }

    public Transporte withModalidadeDoFrete(final ModalidadeDoFrete modalidadeDoFrete) {
        transp.setModFrete(modalidadeDoFrete.getCode());
        return this;
    }

    public Transporte withTransportador(final Transportador transporta) {
        transp.setTransporta((br.com.caelum.stella.nfe.modelo.Transporta) ((ObjectCreator) transporta).getInstance());
        return this;
    }

    public Transporte withICMSRetidoPeloTransporte(final ICMSRetidoPeloTransporte retTransp) {
        transp.setRetTransp((br.com.caelum.stella.nfe.modelo.RetTransp) ((ObjectCreator) retTransp).getInstance());
        return this;
    }

    public Transporte withVeiculoUsado(final Veiculo tVeiculo) {
        transp.setVeicTransp((br.com.caelum.stella.nfe.modelo.TVeiculo) ((ObjectCreator) tVeiculo).getInstance());
        return this;
    }

    public Transporte withReboque(final Veiculo... reboques) {
        List<br.com.caelum.stella.nfe.modelo.TVeiculo> list = new ArrayList<br.com.caelum.stella.nfe.modelo.TVeiculo>();
        for (Veiculo p : reboques) {
            list.add((br.com.caelum.stella.nfe.modelo.TVeiculo) ((ObjectCreator) p).getInstance());
        }
        transp.setReboques(list);
        return this;
    }

    public Transporte withVolume(final Volume... vol) {
        List<br.com.caelum.stella.nfe.modelo.Vol> list = new ArrayList<br.com.caelum.stella.nfe.modelo.Vol>();
        for (Volume p : vol) {
            list.add((br.com.caelum.stella.nfe.modelo.Vol) ((ObjectCreator) p).getInstance());
        }
        transp.setVol(list);
        return this;
    }
}