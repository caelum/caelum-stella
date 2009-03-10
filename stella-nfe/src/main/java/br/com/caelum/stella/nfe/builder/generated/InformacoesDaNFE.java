package br.com.caelum.stella.nfe.builder.generated;

public interface InformacoesDaNFE {
    public InformacoesDaNFE withIde(Ide ide);

    public InformacoesDaNFE withEmit(Emit emit);

    public InformacoesDaNFE withAvulsa(Avulsa avulsa);

    public InformacoesDaNFE withDest(Dest dest);

    public InformacoesDaNFE withRetirada(DadosDoLocal tLocal);

    public InformacoesDaNFE withEntrega(DadosDoLocal tLocal);

    public InformacoesDaNFE withDet(Det... det);

    public InformacoesDaNFE withTotal(TotalNFE total);

    public InformacoesDaNFE withTransp(Transporte transp);

    public InformacoesDaNFE withCobr(Cobr cobr);

    public InformacoesDaNFE withInfAdic(InfAdic infAdic);

    public InformacoesDaNFE withExporta(Exporta exporta);

    public InformacoesDaNFE withCompra(Compra compra);

    public InformacoesDaNFE withVersao(String string);

    public InformacoesDaNFE withId(String string);
}