package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.InfRec.class)
public interface ReciboDoLote<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("nRec")
    ReciboDoLote<T> withNumeroDoRecibo(java.lang.String numeroDoRecibo);

    @net.vidageek.fluid.annotations.FluidField("dhRecbto")
    ReciboDoLote<T> withDataEHoraDoRecebimento(java.lang.String dataEHoraDoRecebimento);

    @net.vidageek.fluid.annotations.FluidField("tMed")
    ReciboDoLote<T> withTempoMedioDeResposta(java.lang.String tempoMedioDeResposta);

}