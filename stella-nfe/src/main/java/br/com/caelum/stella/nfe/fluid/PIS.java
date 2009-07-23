package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.PIS.class)
public interface PIS<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("pisAliq")
    PISTributadoPelaAliquota<PIS<T>> withPISTributadoPelaAliquota();

    @net.vidageek.fluid.annotations.FluidField("pisQtde")
    PISTributadoPorQuantidade<PIS<T>> withPISTributadoPorQuantidade();

    @net.vidageek.fluid.annotations.FluidField("pisnt")
    PISNaoTributado<PIS<T>> withPISNaoTributado();

    @net.vidageek.fluid.annotations.FluidField("pisOutr")
    PISOutrasOperacoes<PIS<T>> withPISOutrasOperacoes();

}