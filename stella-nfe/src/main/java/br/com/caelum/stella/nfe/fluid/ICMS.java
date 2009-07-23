package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.ICMS.class)
public interface ICMS<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("icms00")
    ICMS00<ICMS<T>> withIcms00();

    @net.vidageek.fluid.annotations.FluidField("icms10")
    ICMS10<ICMS<T>> withIcms10();

    @net.vidageek.fluid.annotations.FluidField("icms20")
    ICMS20<ICMS<T>> withIcms20();

    @net.vidageek.fluid.annotations.FluidField("icms30")
    ICMS30<ICMS<T>> withIcms30();

    @net.vidageek.fluid.annotations.FluidField("icms40")
    ICMS40<ICMS<T>> withIcms40();

    @net.vidageek.fluid.annotations.FluidField("icms51")
    ICMS51<ICMS<T>> withIcms51();

    @net.vidageek.fluid.annotations.FluidField("icms60")
    ICMS60<ICMS<T>> withIcms60();

    @net.vidageek.fluid.annotations.FluidField("icms70")
    ICMS70<ICMS<T>> withIcms70();

    @net.vidageek.fluid.annotations.FluidField("icms90")
    ICMS90<ICMS<T>> withIcms90();

}