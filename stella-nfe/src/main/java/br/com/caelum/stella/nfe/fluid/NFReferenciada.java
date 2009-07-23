package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.RefNF.class)
public interface NFReferenciada<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("cuf")
    NFReferenciada<T> withCodigoUF(java.lang.String codigoUF);

    @net.vidageek.fluid.annotations.FluidField("aamm")
    NFReferenciada<T> withAAMM(java.lang.String AAMM);

    @net.vidageek.fluid.annotations.FluidField("cnpj")
    NFReferenciada<T> withCNPJ(java.lang.String CNPJ);

    @net.vidageek.fluid.annotations.FluidField("mod")
    NFReferenciada<T> withMod(java.lang.String mod);

    @net.vidageek.fluid.annotations.FluidField("serie")
    NFReferenciada<T> withSerie(java.lang.String serie);

    @net.vidageek.fluid.annotations.FluidField("nnf")
    NFReferenciada<T> withNumero(java.lang.String numero);

}