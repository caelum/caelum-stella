package br.com.caelum.stella.nfe.builder.generated;

public interface InformacoesDaNFE {
    public InformacoesDaNFE withIde(IdentificacaoDaNFE ide);

    public InformacoesDaNFE withEmit(Emitente emit);

    public InformacoesDaNFE withAvulsa(Avulsa avulsa);

    public InformacoesDaNFE withDest(Destinatario dest);

    public InformacoesDaNFE withRetirada(DadosDoLocal tLocal);

    public InformacoesDaNFE withEntrega(DadosDoLocal tLocal);

    public InformacoesDaNFE withDet(Detalhe... det);

    public InformacoesDaNFE withTotal(TotalNFE total);

    public InformacoesDaNFE withTransp(Transporte transp);

    public InformacoesDaNFE withCobr(Cobranca cobr);

    public InformacoesDaNFE withInfAdic(InformacoesAdicionais infAdic);

    public InformacoesDaNFE withExporta(Exportacao exporta);

    public InformacoesDaNFE withCompra(Compra compra);

    public InformacoesDaNFE withVersao(String string);

    public InformacoesDaNFE withId(String string);
}