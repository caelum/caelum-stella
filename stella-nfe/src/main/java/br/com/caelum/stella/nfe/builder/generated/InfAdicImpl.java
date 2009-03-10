package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class InfAdicImpl implements InfAdic, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.InfAdic infAdic;

    public InfAdicImpl() {
        infAdic = new br.com.caelum.stella.nfe.modelo.InfAdic();
    }

    public br.com.caelum.stella.nfe.modelo.InfAdic getInstance() {
        return infAdic;
    }

    public InfAdic withInfAdFisco(final String string) {
        infAdic.setInfAdFisco(string);
        return this;
    }

    public InfAdic withInfCpl(final String string) {
        infAdic.setInfCpl(string);
        return this;
    }

    public InfAdic withObsCont(final ObsCont... obsConts) {
        List<br.com.caelum.stella.nfe.modelo.ObsCont> list = new ArrayList<br.com.caelum.stella.nfe.modelo.ObsCont>();
        for (ObsCont p : obsConts) {
            list.add((br.com.caelum.stella.nfe.modelo.ObsCont) ((ObjectCreator) p).getInstance());
        }
        infAdic.setObsCont(list);
        return this;
    }

    public InfAdic withObsFisco(final ObsFisco... obsFiscos) {
        List<br.com.caelum.stella.nfe.modelo.ObsFisco> list = new ArrayList<br.com.caelum.stella.nfe.modelo.ObsFisco>();
        for (ObsFisco p : obsFiscos) {
            list.add((br.com.caelum.stella.nfe.modelo.ObsFisco) ((ObjectCreator) p).getInstance());
        }
        infAdic.setObsFisco(list);
        return this;
    }

    public InfAdic withProcRef(final ProcessoReferenciado... procRef) {
        List<br.com.caelum.stella.nfe.modelo.ProcRef> list = new ArrayList<br.com.caelum.stella.nfe.modelo.ProcRef>();
        for (ProcessoReferenciado p : procRef) {
            list.add((br.com.caelum.stella.nfe.modelo.ProcRef) ((ObjectCreator) p).getInstance());
        }
        infAdic.setProcRef(list);
        return this;
    }
}