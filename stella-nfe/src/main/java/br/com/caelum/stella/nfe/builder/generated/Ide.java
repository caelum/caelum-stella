package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

public interface Ide {
    public Ide withCUF(String string);

    public Ide withCNF(String string);

    public Ide withNatOp(String string);

    public Ide withIndPag(String string);

    public Ide withMod(String string);

    public Ide withSerie(String string);

    public Ide withNNF(String string);

    public Ide withDEmi(Calendar calendar);

    public Ide withDSaiEnt(Calendar calendar);

    public Ide withTpNF(String string);

    public Ide withCMunFG(String string);

    public Ide withNFref(NFref... nfref);

    public Ide withTpImp(String string);

    public Ide withTpEmis(String string);

    public Ide withCDV(String string);

    public Ide withTpAmb(String string);

    public Ide withFinNFe(String string);

    public Ide withProcEmi(String string);

    public Ide withVerProc(String string);
}