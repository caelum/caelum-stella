package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface InformacoesDaNFE<T> extends NFeBuilder<T> {
    public InformacoesDaNFE<T> withIde(IdentificacaoDaNFE<?> ide);

    public InformacoesDaNFE<T> withEmit(Emitente<?> emit);

    public InformacoesDaNFE<T> withAvulsa(Avulsa<?> avulsa);

    public InformacoesDaNFE<T> withDest(Destinatario<?> dest);

    public InformacoesDaNFE<T> withRetirada(DadosDoLocal<?> tLocal);

    public InformacoesDaNFE<T> withEntrega(DadosDoLocal<?> tLocal);

    public InformacoesDaNFE<T> withDet(Detalhe<?>... det);

    public InformacoesDaNFE<T> withTotal(TotalNFE<?> total);

    public InformacoesDaNFE<T> withTransp(Transporte<?> transp);

    public InformacoesDaNFE<T> withCobr(Cobranca<?> cobr);

    public InformacoesDaNFE<T> withInfAdic(InformacoesAdicionais<?> infAdic);

    public InformacoesDaNFE<T> withExporta(Exportacao<?> exporta);

    public InformacoesDaNFE<T> withCompra(Compra<?> compra);

    public InformacoesDaNFE<T> withVersao(String string);

    public InformacoesDaNFE<T> withId(String string);
}