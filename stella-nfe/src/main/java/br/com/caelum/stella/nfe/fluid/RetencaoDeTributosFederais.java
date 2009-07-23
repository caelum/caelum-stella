package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.RetTrib.class)
public interface RetencaoDeTributosFederais<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("vRetPIS")
    RetencaoDeTributosFederais<T> withValorRetencaoPIS(java.lang.String valorRetencaoPIS);

    @net.vidageek.fluid.annotations.FluidField("vRetCOFINS")
    RetencaoDeTributosFederais<T> withValorRetencaoCOFINS(java.lang.String valorRetencaoCOFINS);

    @net.vidageek.fluid.annotations.FluidField("vRetCSLL")
    RetencaoDeTributosFederais<T> withVRetCSLL(java.lang.String vRetCSLL);

    @net.vidageek.fluid.annotations.FluidField("vbcirrf")
    RetencaoDeTributosFederais<T> withVbcirrf(java.lang.String vbcirrf);

    @net.vidageek.fluid.annotations.FluidField("virrf")
    RetencaoDeTributosFederais<T> withVirrf(java.lang.String virrf);

    @net.vidageek.fluid.annotations.FluidField("vbcRetPrev")
    RetencaoDeTributosFederais<T> withVbcRetPrev(java.lang.String vbcRetPrev);

    @net.vidageek.fluid.annotations.FluidField("vRetPrev")
    RetencaoDeTributosFederais<T> withVRetPrev(java.lang.String vRetPrev);

}