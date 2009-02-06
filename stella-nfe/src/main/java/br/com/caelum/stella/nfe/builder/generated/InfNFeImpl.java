package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class InfNFeImpl implements InfNFe, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.InfNFe infNFe;

    public InfNFeImpl() {
        infNFe = new br.com.caelum.stella.nfe.modelo.InfNFe();
    }

    public br.com.caelum.stella.nfe.modelo.InfNFe getInstance() {
        return infNFe;
    }

    public InfNFe withIde(final Ide ide) {
        infNFe.setIde((br.com.caelum.stella.nfe.modelo.Ide) ((ObjectCreator) ide).getInstance());
        return this;
    }

    public InfNFe withEmit(final Emit emit) {
        infNFe.setEmit((br.com.caelum.stella.nfe.modelo.Emit) ((ObjectCreator) emit).getInstance());
        return this;
    }

    public InfNFe withAvulsa(final Avulsa avulsa) {
        infNFe.setAvulsa((br.com.caelum.stella.nfe.modelo.Avulsa) ((ObjectCreator) avulsa).getInstance());
        return this;
    }

    public InfNFe withDest(final Dest dest) {
        infNFe.setDest((br.com.caelum.stella.nfe.modelo.Dest) ((ObjectCreator) dest).getInstance());
        return this;
    }

    public InfNFe withRetirada(final TLocal tLocal) {
        infNFe.setRetirada((br.com.caelum.stella.nfe.modelo.TLocal) ((ObjectCreator) tLocal).getInstance());
        return this;
    }

    public InfNFe withEntrega(final TLocal tLocal) {
        infNFe.setEntrega((br.com.caelum.stella.nfe.modelo.TLocal) ((ObjectCreator) tLocal).getInstance());
        return this;
    }

    public InfNFe withDet(final Det... det) {
        List<br.com.caelum.stella.nfe.modelo.Det> list = new ArrayList<br.com.caelum.stella.nfe.modelo.Det>();
        for (Det p : det) {
            list.add((br.com.caelum.stella.nfe.modelo.Det) ((ObjectCreator) p).getInstance());
        }
        infNFe.setDet(list);
        return this;
    }

    public InfNFe withTotal(final Total total) {
        infNFe.setTotal((br.com.caelum.stella.nfe.modelo.Total) ((ObjectCreator) total).getInstance());
        return this;
    }

    public InfNFe withTransp(final Transp transp) {
        infNFe.setTransp((br.com.caelum.stella.nfe.modelo.Transp) ((ObjectCreator) transp).getInstance());
        return this;
    }

    public InfNFe withCobr(final Cobr cobr) {
        infNFe.setCobr((br.com.caelum.stella.nfe.modelo.Cobr) ((ObjectCreator) cobr).getInstance());
        return this;
    }

    public InfNFe withInfAdic(final InfAdic infAdic) {
        infNFe.setInfAdic((br.com.caelum.stella.nfe.modelo.InfAdic) ((ObjectCreator) infAdic).getInstance());
        return this;
    }

    public InfNFe withExporta(final Exporta exporta) {
        infNFe.setExporta((br.com.caelum.stella.nfe.modelo.Exporta) ((ObjectCreator) exporta).getInstance());
        return this;
    }

    public InfNFe withCompra(final Compra compra) {
        infNFe.setCompra((br.com.caelum.stella.nfe.modelo.Compra) ((ObjectCreator) compra).getInstance());
        return this;
    }

    public InfNFe withVersao(final String string) {
        infNFe.setVersao(string);
        return this;
    }

    public InfNFe withId(final String string) {
        infNFe.setId(string);
        return this;
    }
}