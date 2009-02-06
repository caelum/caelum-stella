package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class TranspImpl implements Transp, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Transp transp;

    public TranspImpl() {
        transp = new br.com.caelum.stella.nfe.modelo.Transp();
    }

    public br.com.caelum.stella.nfe.modelo.Transp getInstance() {
        return transp;
    }

    public Transp withModFrete(final String string) {
        transp.setModFrete(string);
        return this;
    }

    public Transp withTransporta(final Transporta transporta) {
        transp.setTransporta((br.com.caelum.stella.nfe.modelo.Transporta) ((ObjectCreator) transporta).getInstance());
        return this;
    }

    public Transp withRetTransp(final RetTransp retTransp) {
        transp.setRetTransp((br.com.caelum.stella.nfe.modelo.RetTransp) ((ObjectCreator) retTransp).getInstance());
        return this;
    }

    public Transp withVeicTransp(final TVeiculo tVeiculo) {
        transp.setVeicTransp((br.com.caelum.stella.nfe.modelo.TVeiculo) ((ObjectCreator) tVeiculo).getInstance());
        return this;
    }

    public Transp withReboque(final TVeiculo... reboques) {
        List<br.com.caelum.stella.nfe.modelo.TVeiculo> list = new ArrayList<br.com.caelum.stella.nfe.modelo.TVeiculo>();
        for (TVeiculo p : reboques) {
            list.add((br.com.caelum.stella.nfe.modelo.TVeiculo) ((ObjectCreator) p).getInstance());
        }
        transp.setReboques(list);
        return this;
    }

    public Transp withVol(final Vol... vol) {
        List<br.com.caelum.stella.nfe.modelo.Vol> list = new ArrayList<br.com.caelum.stella.nfe.modelo.Vol>();
        for (Vol p : vol) {
            list.add((br.com.caelum.stella.nfe.modelo.Vol) ((ObjectCreator) p).getInstance());
        }
        transp.setVol(list);
        return this;
    }
}