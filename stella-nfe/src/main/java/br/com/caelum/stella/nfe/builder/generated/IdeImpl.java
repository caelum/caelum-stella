package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.builder.generated.enums.FormaDePagamento;
import br.com.caelum.stella.nfe.builder.generated.enums.TipoDocumentoFiscal;

public final class IdeImpl implements Ide, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Ide ide;

    public IdeImpl() {
        ide = new br.com.caelum.stella.nfe.modelo.Ide();
    }

    public br.com.caelum.stella.nfe.modelo.Ide getInstance() {
        return ide;
    }

    public Ide withCUF(final String string) {
        ide.setCUF(string);
        return this;
    }

    public Ide withCNF(final Integer string) {
        ide.setCNF(string.toString());
        return this;
    }

    public Ide withNatOp(final String string) {
        ide.setNatOp(string);
        return this;
    }

    public Ide withIndPag(final FormaDePagamento string) {
        ide.setIndPag(string.getCode());
        return this;
    }

    public Ide withMod(final String string) {
        ide.setMod(string);
        return this;
    }

    public Ide withSerie(final String string) {
        ide.setSerie(string);
        return this;
    }

    public Ide withNNF(final String string) {
        ide.setNNF(string);
        return this;
    }

    public Ide withDEmi(final Calendar calendar) {
        ide.setDEmi(calendar);
        return this;
    }

    public Ide withDSaiEnt(final Calendar calendar) {
        ide.setDSaiEnt(calendar);
        return this;
    }

    public Ide withTpNF(final TipoDocumentoFiscal string) {
        ide.setTpNF(string.getCode());
        return this;
    }

    public Ide withCMunFG(final String string) {
        ide.setCMunFG(string);
        return this;
    }

    public Ide withNFref(final NFref... nfref) {
        List<br.com.caelum.stella.nfe.modelo.NFref> list = new ArrayList<br.com.caelum.stella.nfe.modelo.NFref>();
        for (NFref p : nfref) {
            list.add((br.com.caelum.stella.nfe.modelo.NFref) ((ObjectCreator) p).getInstance());
        }
        ide.setNFref(list);
        return this;
    }

    public Ide withTpImp(final String string) {
        ide.setTpImp(string);
        return this;
    }

    public Ide withTpEmis(final String string) {
        ide.setTpEmis(string);
        return this;
    }

    public Ide withCDV(final String string) {
        ide.setCDV(string);
        return this;
    }

    public Ide withTpAmb(final String string) {
        ide.setTpAmb(string);
        return this;
    }

    public Ide withFinNFe(final String string) {
        ide.setFinNFe(string);
        return this;
    }

    public Ide withProcEmi(final String string) {
        ide.setProcEmi(string);
        return this;
    }

    public Ide withVerProc(final String string) {
        ide.setVerProc(string);
        return this;
    }
}