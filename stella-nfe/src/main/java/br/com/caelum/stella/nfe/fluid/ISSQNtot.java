package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.ISSQNtot.class)
public interface ISSQNtot<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("vServ")
    ISSQNtot<T> withVServ(java.lang.String vServ);

    @net.vidageek.fluid.annotations.FluidField("vbc")
    ISSQNtot<T> withVbc(java.lang.String vbc);

    @net.vidageek.fluid.annotations.FluidField("viss")
    ISSQNtot<T> withViss(java.lang.String viss);

    @net.vidageek.fluid.annotations.FluidField("vpis")
    ISSQNtot<T> withVpis(java.lang.String vpis);

    @net.vidageek.fluid.annotations.FluidField("vcofins")
    ISSQNtot<T> withVcofins(java.lang.String vcofins);

}