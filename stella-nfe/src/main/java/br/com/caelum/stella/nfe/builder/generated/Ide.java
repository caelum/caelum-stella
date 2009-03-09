package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

import br.com.caelum.stella.nfe.builder.generated.enums.FormaDePagamento;
import br.com.caelum.stella.nfe.builder.generated.enums.TipoDocumentoFiscal;

public interface Ide {
    public Ide withCUF(String string);// TODO Isso Ž um TCodUFIBGE

    public Ide withCNF(Integer string);// TODO Deve ser autogerado

    public Ide withNatOp(String string);

    public Ide withIndPag(FormaDePagamento string);

    public Ide withMod(String string); // TODO Campo fixo

    public Ide withSerie(String string); // TODO TSerie

    public Ide withNNF(String string); // TODO TNF

    public Ide withDEmi(Calendar calendar);

    public Ide withDSaiEnt(Calendar calendar);

    public Ide withTpNF(TipoDocumentoFiscal string);

    public Ide withCMunFG(String string); // TODO TCodMunIBGE

    public Ide withNFref(NFref... nfref);

    public Ide withTpImp(String string);

    public Ide withTpEmis(String string);

    public Ide withCDV(String string);

    public Ide withTpAmb(String string);

    public Ide withFinNFe(String string);

    public Ide withProcEmi(String string);

    public Ide withVerProc(String string);
}