package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.Imposto.class)
public interface Imposto<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("icms")
    ICMS<Imposto<T>> withIcms();

    @net.vidageek.fluid.annotations.FluidField("ipi")
    IPI<Imposto<T>> withIpi();

    @net.vidageek.fluid.annotations.FluidField("ii")
    II<Imposto<T>> withIi();

    @net.vidageek.fluid.annotations.FluidField("pis")
    PIS<Imposto<T>> withPis();

    @net.vidageek.fluid.annotations.FluidField("pisst")
    PISSubstituicaoTributaria<Imposto<T>> withPisst();

    @net.vidageek.fluid.annotations.FluidField("cofins")
    COFINS<Imposto<T>> withCofins();

    @net.vidageek.fluid.annotations.FluidField("cofinsst")
    COFINSSubstituicaoTributaria<Imposto<T>> withCofinsst();

    @net.vidageek.fluid.annotations.FluidField("issqn")
    ISSQN<Imposto<T>> withIssqn();

}