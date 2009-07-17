package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class InfNFeImpl<T> implements InformacoesDaNFE<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.InfNFe infNFe;
    private final T parent;

    public InfNFeImpl(final T parent) {
        this.parent = parent;
        infNFe = new br.com.caelum.stella.nfe.modelo.InfNFe();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.infNFe;
    }

    public InformacoesDaNFE<T> withIde(final IdentificacaoDaNFE<?> ide) {
        infNFe.setIde((br.com.caelum.stella.nfe.modelo.Ide) ((ObjectCreator) ide).getInstance());
        return this;
    }

    public InformacoesDaNFE<T> withEmit(final Emitente<?> emit) {
        infNFe.setEmit((br.com.caelum.stella.nfe.modelo.Emit) ((ObjectCreator) emit).getInstance());
        return this;
    }

    public InformacoesDaNFE<T> withAvulsa(final Avulsa<?> avulsa) {
        infNFe.setAvulsa((br.com.caelum.stella.nfe.modelo.Avulsa) ((ObjectCreator) avulsa).getInstance());
        return this;
    }

    public InformacoesDaNFE<T> withDest(final Destinatario<?> dest) {
        infNFe.setDest((br.com.caelum.stella.nfe.modelo.Dest) ((ObjectCreator) dest).getInstance());
        return this;
    }

    public InformacoesDaNFE<T> withRetirada(final DadosDoLocal<?> tLocal) {
        infNFe.setRetirada((br.com.caelum.stella.nfe.modelo.TLocal) ((ObjectCreator) tLocal).getInstance());
        return this;
    }

    public InformacoesDaNFE<T> withEntrega(final DadosDoLocal<?> tLocal) {
        infNFe.setEntrega((br.com.caelum.stella.nfe.modelo.TLocal) ((ObjectCreator) tLocal).getInstance());
        return this;
    }

    public InformacoesDaNFE<T> withDet(final Detalhe<?>... det) {
        List<br.com.caelum.stella.nfe.modelo.Det> list = new ArrayList<br.com.caelum.stella.nfe.modelo.Det>();
        for (Detalhe<?> p : det) {
            list.add((br.com.caelum.stella.nfe.modelo.Det) ((ObjectCreator) p).getInstance());
        }
        infNFe.setDet(list);
        return this;
    }

    public InformacoesDaNFE<T> withTotal(final TotalNFE<?> total) {
        infNFe.setTotal((br.com.caelum.stella.nfe.modelo.Total) ((ObjectCreator) total).getInstance());
        return this;
    }

    public InformacoesDaNFE<T> withTransp(final Transporte<?> transp) {
        infNFe.setTransp((br.com.caelum.stella.nfe.modelo.Transp) ((ObjectCreator) transp).getInstance());
        return this;
    }

    public InformacoesDaNFE<T> withCobr(final Cobranca<?> cobr) {
        infNFe.setCobr((br.com.caelum.stella.nfe.modelo.Cobr) ((ObjectCreator) cobr).getInstance());
        return this;
    }

    public InformacoesDaNFE<T> withInfAdic(final InformacoesAdicionais<?> infAdic) {
        infNFe.setInfAdic((br.com.caelum.stella.nfe.modelo.InfAdic) ((ObjectCreator) infAdic).getInstance());
        return this;
    }

    public InformacoesDaNFE<T> withExporta(final Exportacao<?> exporta) {
        infNFe.setExporta((br.com.caelum.stella.nfe.modelo.Exporta) ((ObjectCreator) exporta).getInstance());
        return this;
    }

    public InformacoesDaNFE<T> withCompra(final Compra<?> compra) {
        infNFe.setCompra((br.com.caelum.stella.nfe.modelo.Compra) ((ObjectCreator) compra).getInstance());
        return this;
    }

    public InformacoesDaNFE<T> withVersao(final String string) {
        infNFe.setVersao(string);
        return this;
    }

    public InformacoesDaNFE<T> withId(final String string) {
        infNFe.setId(string);
        return this;
    }
}