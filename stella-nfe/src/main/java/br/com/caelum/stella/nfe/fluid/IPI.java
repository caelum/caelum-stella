package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.IPI.class)
public interface IPI<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("classeEnquadramento")
    IPI<T> withClasseEnquadramento(java.lang.String classeEnquadramento);

    @net.vidageek.fluid.annotations.FluidField("cnpjProdutor")
    IPI<T> withCnpjProdutor(java.lang.String cnpjProdutor);

    @net.vidageek.fluid.annotations.FluidField("codigoSelo")
    IPI<T> withCodigoSelo(java.lang.String codigoSelo);

    @net.vidageek.fluid.annotations.FluidField("quantidadeSelo")
    IPI<T> withQuantidadeSelo(java.lang.String quantidadeSelo);

    @net.vidageek.fluid.annotations.FluidField("codigoEnquadramento")
    IPI<T> withCodigoEnquadramento(java.lang.String codigoEnquadramento);

    @net.vidageek.fluid.annotations.FluidField("ipiTributacao")
    IPITrib<IPI<T>> withIpiTributacao();

    @net.vidageek.fluid.annotations.FluidField("ipint")
    IPINT<IPI<T>> withIpint();

}