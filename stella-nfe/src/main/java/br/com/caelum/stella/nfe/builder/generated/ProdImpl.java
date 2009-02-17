package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class ProdImpl implements Prod, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Prod prod;

    public ProdImpl() {
        prod = new br.com.caelum.stella.nfe.modelo.Prod();
    }

    public br.com.caelum.stella.nfe.modelo.Prod getInstance() {
        return prod;
    }

    public Prod withCProd(final String string) {
        prod.setCProd(string);
        return this;
    }

    public Prod withCEAN(final String string) {
        prod.setCEAN(string);
        return this;
    }

    public Prod withXProd(final String string) {
        prod.setXProd(string);
        return this;
    }

    public Prod withNCM(final String string) {
        prod.setNCM(string);
        return this;
    }

    public Prod withEXTIPI(final String string) {
        prod.setEXTIPI(string);
        return this;
    }

    public Prod withGenero(final String string) {
        prod.setGenero(string);
        return this;
    }

    public Prod withCFOP(final String string) {
        prod.setCFOP(string);
        return this;
    }

    public Prod withUCom(final String string) {
        prod.setUCom(string);
        return this;
    }

    public Prod withQCom(final String string) {
        prod.setQCom(string);
        return this;
    }

    public Prod withVUnCom(final String string) {
        prod.setVUnCom(string);
        return this;
    }

    public Prod withVProd(final String string) {
        prod.setVProd(string);
        return this;
    }

    public Prod withCEANTrib(final String string) {
        prod.setCEANTrib(string);
        return this;
    }

    public Prod withUTrib(final String string) {
        prod.setUTrib(string);
        return this;
    }

    public Prod withQTrib(final String string) {
        prod.setQTrib(string);
        return this;
    }

    public Prod withVUnTrib(final String string) {
        prod.setVUnTrib(string);
        return this;
    }

    public Prod withVFrete(final String string) {
        prod.setVFrete(string);
        return this;
    }

    public Prod withVSeg(final String string) {
        prod.setVSeg(string);
        return this;
    }

    public Prod withVDesc(final String string) {
        prod.setVDesc(string);
        return this;
    }

    public Prod withDI(final DI... di) {
        List<br.com.caelum.stella.nfe.modelo.DI> list = new ArrayList<br.com.caelum.stella.nfe.modelo.DI>();
        for (DI p : di) {
            list.add((br.com.caelum.stella.nfe.modelo.DI) ((ObjectCreator) p).getInstance());
        }
        prod.setDI(list);
        return this;
    }

    public Prod withVeicProd(final VeicProd veicProd) {
        prod.setVeicProd((br.com.caelum.stella.nfe.modelo.VeicProd) ((ObjectCreator) veicProd).getInstance());
        return this;
    }

    public Prod withMed(final Med... meds) {
        List<br.com.caelum.stella.nfe.modelo.Med> list = new ArrayList<br.com.caelum.stella.nfe.modelo.Med>();
        for (Med p : meds) {
            list.add((br.com.caelum.stella.nfe.modelo.Med) ((ObjectCreator) p).getInstance());
        }
        prod.setMed(list);
        return this;
    }

    public Prod withArma(final Armamento... armas) {
        List<br.com.caelum.stella.nfe.modelo.Arma> list = new ArrayList<br.com.caelum.stella.nfe.modelo.Arma>();
        for (Armamento p : armas) {
            list.add((br.com.caelum.stella.nfe.modelo.Arma) ((ObjectCreator) p).getInstance());
        }
        prod.setArma(list);
        return this;
    }

    public Prod withComb(final Comb comb) {
        prod.setComb((br.com.caelum.stella.nfe.modelo.Comb) ((ObjectCreator) comb).getInstance());
        return this;
    }
}