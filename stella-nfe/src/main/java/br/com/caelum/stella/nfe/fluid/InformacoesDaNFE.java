package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.InfNFe.class)
public interface InformacoesDaNFE<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("ide")
    IdentificacaoDaNFE<InformacoesDaNFE<T>> withIde();

    @net.vidageek.fluid.annotations.FluidField("emit")
    Emitente<InformacoesDaNFE<T>> withEmit();

    @net.vidageek.fluid.annotations.FluidField("avulsa")
    Avulsa<InformacoesDaNFE<T>> withAvulsa();

    @net.vidageek.fluid.annotations.FluidField("dest")
    Destinatario<InformacoesDaNFE<T>> withDest();

    @net.vidageek.fluid.annotations.FluidField("retirada")
    DadosDoLocal<InformacoesDaNFE<T>> withRetirada();

    @net.vidageek.fluid.annotations.FluidField("entrega")
    DadosDoLocal<InformacoesDaNFE<T>> withEntrega();

    @net.vidageek.fluid.annotations.FluidField("det")
    Detalhe<InformacoesDaNFE<T>> addDet();

    @net.vidageek.fluid.annotations.FluidField("total")
    TotalNFE<InformacoesDaNFE<T>> withTotal();

    @net.vidageek.fluid.annotations.FluidField("transp")
    Transporte<InformacoesDaNFE<T>> withTransp();

    @net.vidageek.fluid.annotations.FluidField("cobr")
    Cobranca<InformacoesDaNFE<T>> withCobr();

    @net.vidageek.fluid.annotations.FluidField("infAdic")
    InformacoesAdicionais<InformacoesDaNFE<T>> withInfAdic();

    @net.vidageek.fluid.annotations.FluidField("exporta")
    Exportacao<InformacoesDaNFE<T>> withExporta();

    @net.vidageek.fluid.annotations.FluidField("compra")
    Compra<InformacoesDaNFE<T>> withCompra();

    @net.vidageek.fluid.annotations.FluidField("versao")
    InformacoesDaNFE<T> withVersao(java.lang.String versao);

    @net.vidageek.fluid.annotations.FluidField("id")
    InformacoesDaNFE<T> withId(java.lang.String id);

}