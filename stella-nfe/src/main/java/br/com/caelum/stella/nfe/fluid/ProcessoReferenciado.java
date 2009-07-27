package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.ProcRef.class)
public interface ProcessoReferenciado<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("nProc")
    ProcessoReferenciado<T> withIdentificadorDoProcesso(java.lang.String identificadorDoProcesso);

    @net.vidageek.fluid.annotations.FluidField("indProc")
    ProcessoReferenciado<T> withOrigemDoProcesso(br.com.caelum.stella.nfe.fluid.enums.OrigemDoProcesso origemDoProcesso);

}