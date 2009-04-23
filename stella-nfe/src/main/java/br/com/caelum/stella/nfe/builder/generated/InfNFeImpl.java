package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class InfNFeImpl implements InformacoesDaNFE, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.InfNFe infNFe;

    public InfNFeImpl() {
        infNFe = new br.com.caelum.stella.nfe.modelo.InfNFe();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.infNFe;
    }

    public InformacoesDaNFE withIde(final IdentificacaoDaNFE ide) {
        infNFe.setIde((br.com.caelum.stella.nfe.modelo.Ide) ((ObjectCreator) ide).getInstance());
        return this;
    }

    public InformacoesDaNFE withEmit(final Emitente emit) {
        infNFe.setEmit((br.com.caelum.stella.nfe.modelo.Emit) ((ObjectCreator) emit).getInstance());
        return this;
    }

    public InformacoesDaNFE withAvulsa(final Avulsa avulsa) {
        infNFe.setAvulsa((br.com.caelum.stella.nfe.modelo.Avulsa) ((ObjectCreator) avulsa).getInstance());
        return this;
    }

    public InformacoesDaNFE withDest(final Destinatario dest) {
        infNFe.setDest((br.com.caelum.stella.nfe.modelo.Dest) ((ObjectCreator) dest).getInstance());
        return this;
    }

    public InformacoesDaNFE withRetirada(final DadosDoLocal tLocal) {
        infNFe.setRetirada((br.com.caelum.stella.nfe.modelo.TLocal) ((ObjectCreator) tLocal).getInstance());
        return this;
    }

    public InformacoesDaNFE withEntrega(final DadosDoLocal tLocal) {
        infNFe.setEntrega((br.com.caelum.stella.nfe.modelo.TLocal) ((ObjectCreator) tLocal).getInstance());
        return this;
    }

    public InformacoesDaNFE withDet(final Detalhe... det) {
        List<br.com.caelum.stella.nfe.modelo.Det> list = new ArrayList<br.com.caelum.stella.nfe.modelo.Det>();
        for (Detalhe p : det) {
            list.add((br.com.caelum.stella.nfe.modelo.Det) ((ObjectCreator) p).getInstance());
        }
        infNFe.setDet(list);
        return this;
    }

    public InformacoesDaNFE withTotal(final TotalNFE total) {
        infNFe.setTotal((br.com.caelum.stella.nfe.modelo.Total) ((ObjectCreator) total).getInstance());
        return this;
    }

    public InformacoesDaNFE withTransp(final Transporte transp) {
        infNFe.setTransp((br.com.caelum.stella.nfe.modelo.Transp) ((ObjectCreator) transp).getInstance());
        return this;
    }

    public InformacoesDaNFE withCobr(final Cobranca cobr) {
        infNFe.setCobr((br.com.caelum.stella.nfe.modelo.Cobr) ((ObjectCreator) cobr).getInstance());
        return this;
    }

    public InformacoesDaNFE withInfAdic(final InformacoesAdicionais infAdic) {
        infNFe.setInfAdic((br.com.caelum.stella.nfe.modelo.InfAdic) ((ObjectCreator) infAdic).getInstance());
        return this;
    }

    public InformacoesDaNFE withExporta(final Exportacao exporta) {
        infNFe.setExporta((br.com.caelum.stella.nfe.modelo.Exporta) ((ObjectCreator) exporta).getInstance());
        return this;
    }

    public InformacoesDaNFE withCompra(final Compra compra) {
        infNFe.setCompra((br.com.caelum.stella.nfe.modelo.Compra) ((ObjectCreator) compra).getInstance());
        return this;
    }

    public InformacoesDaNFE withVersao(final String string) {
        infNFe.setVersao(string);
        return this;
    }

    public InformacoesDaNFE withId(final String string) {
        infNFe.setId(string);
        return this;
    }
}