package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.ISSQN.class)
public interface ISSQN<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("valorDaBaseDeCalculo")
    ISSQN<T> withValorDaBaseDeCalculo(java.lang.String valorDaBaseDeCalculo);

    @net.vidageek.fluid.annotations.FluidField("aliquota")
    ISSQN<T> withAliquota(java.lang.String aliquota);

    @net.vidageek.fluid.annotations.FluidField("valorISSQN")
    ISSQN<T> withValorISSQN(java.lang.String valorISSQN);

    @net.vidageek.fluid.annotations.FluidField("codigoMunicipio")
    ISSQN<T> withCodigoMunicipio(java.lang.String codigoMunicipio);

    @net.vidageek.fluid.annotations.FluidField("codigoListaServicos")
    ISSQN<T> withCodigoListaServicos(java.lang.String codigoListaServicos);

}