package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.Cobr.class)
public interface Cobranca<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("fat")
    Fatura<Cobranca<T>> withFatura();

    @net.vidageek.fluid.annotations.FluidField("dup")
    Cobranca<T> addDuplicata();

}