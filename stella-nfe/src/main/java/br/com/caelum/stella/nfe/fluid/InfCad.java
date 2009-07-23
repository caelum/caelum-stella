package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.InfCad.class)
public interface InfCad<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("ie")
    InfCad<T> withIe(java.lang.String ie);

    @net.vidageek.fluid.annotations.FluidField("cnpj")
    InfCad<T> withCnpj(java.lang.String cnpj);

    @net.vidageek.fluid.annotations.FluidField("cpf")
    InfCad<T> withCpf(java.lang.String cpf);

    @net.vidageek.fluid.annotations.FluidField("uf")
    InfCad<T> withUf(br.com.caelum.stella.nfe.modelo.TUf uf);

    @net.vidageek.fluid.annotations.FluidField("cSit")
    InfCad<T> withCSit(java.lang.String cSit);

    @net.vidageek.fluid.annotations.FluidField("xNome")
    InfCad<T> withXNome(java.lang.String xNome);

    @net.vidageek.fluid.annotations.FluidField("xFant")
    InfCad<T> withXFant(java.lang.String xFant);

    @net.vidageek.fluid.annotations.FluidField("xRegApur")
    InfCad<T> withXRegApur(java.lang.String xRegApur);

    @net.vidageek.fluid.annotations.FluidField("cnae")
    InfCad<T> withCnae(java.lang.String cnae);

    @net.vidageek.fluid.annotations.FluidField("dIniAtiv")
    InfCad<T> withDIniAtiv(java.lang.String dIniAtiv);

    @net.vidageek.fluid.annotations.FluidField("dUltSit")
    InfCad<T> withDUltSit(java.lang.String dUltSit);

    @net.vidageek.fluid.annotations.FluidField("dBaixa")
    InfCad<T> withDBaixa(java.lang.String dBaixa);

    @net.vidageek.fluid.annotations.FluidField("ieUnica")
    InfCad<T> withIeUnica(java.lang.String ieUnica);

    @net.vidageek.fluid.annotations.FluidField("ieAtual")
    InfCad<T> withIeAtual(java.lang.String ieAtual);

    @net.vidageek.fluid.annotations.FluidField("ender")
    Endereco<InfCad<T>> withEnder();

}