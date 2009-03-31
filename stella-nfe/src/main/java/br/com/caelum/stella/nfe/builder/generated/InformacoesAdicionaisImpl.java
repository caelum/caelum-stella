package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class InformacoesAdicionaisImpl implements InformacoesAdicionais, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.InfAdic infAdic;

    public InformacoesAdicionaisImpl() {
        infAdic = new br.com.caelum.stella.nfe.modelo.InfAdic();
    }

    public br.com.caelum.stella.nfe.modelo.InfAdic getInstance() {
        return infAdic;
    }

    public InformacoesAdicionais withInformacoesAdicionaisDeInteresseDoFisco(final String string) {
        infAdic.setInfAdFisco(string);
        return this;
    }

    public InformacoesAdicionais withInformacoesComplementares(final String string) {
        infAdic.setInfCpl(string);
        return this;
    }

    public InformacoesAdicionais withObservacoesDoContribuinte(final ObservacaoDoContribuinte... obsConts) {
        List<br.com.caelum.stella.nfe.modelo.ObsCont> list = new ArrayList<br.com.caelum.stella.nfe.modelo.ObsCont>();
        for (ObservacaoDoContribuinte p : obsConts) {
            list.add((br.com.caelum.stella.nfe.modelo.ObsCont) ((ObjectCreator) p).getInstance());
        }
        infAdic.setObsCont(list);
        return this;
    }

    public InformacoesAdicionais withObsFisco(final ObservacaoFisco... obsFiscos) {
        List<br.com.caelum.stella.nfe.modelo.ObsFisco> list = new ArrayList<br.com.caelum.stella.nfe.modelo.ObsFisco>();
        for (ObservacaoFisco p : obsFiscos) {
            list.add((br.com.caelum.stella.nfe.modelo.ObsFisco) ((ObjectCreator) p).getInstance());
        }
        infAdic.setObsFisco(list);
        return this;
    }

    public InformacoesAdicionais withProcRef(final ProcessoReferenciado... procRef) {
        List<br.com.caelum.stella.nfe.modelo.ProcRef> list = new ArrayList<br.com.caelum.stella.nfe.modelo.ProcRef>();
        for (ProcessoReferenciado p : procRef) {
            list.add((br.com.caelum.stella.nfe.modelo.ProcRef) ((ObjectCreator) p).getInstance());
        }
        infAdic.setProcRef(list);
        return this;
    }
}