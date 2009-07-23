package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.InfProt.class)
public interface Protocolo<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("tpAmb")
    Protocolo<T> withTipoDoAmbiente(java.lang.String tipoDoAmbiente);

    @net.vidageek.fluid.annotations.FluidField("verAplic")
    Protocolo<T> withVersaoDoAplicativo(java.lang.String versaoDoAplicativo);

    @net.vidageek.fluid.annotations.FluidField("chNFe")
    Protocolo<T> withChaveDeAcessoDaNFE(java.lang.String chaveDeAcessoDaNFE);

    @net.vidageek.fluid.annotations.FluidField("dhRecbto")
    Protocolo<T> withDataEHoraDoProcessamento(java.lang.String dataEHoraDoProcessamento);

    @net.vidageek.fluid.annotations.FluidField("nProt")
    Protocolo<T> withNumeroDoProtocoloDeStatusDaNFE(java.lang.String numeroDoProtocoloDeStatusDaNFE);

    @net.vidageek.fluid.annotations.FluidField("digVal")
    Protocolo<T> withDigestValue(byte[] digestValue);

    @net.vidageek.fluid.annotations.FluidField("cStat")
    Protocolo<T> withCodigoDeStatus(java.lang.String codigoDeStatus);

    @net.vidageek.fluid.annotations.FluidField("xMotivo")
    Protocolo<T> withDescricaoDoMotivo(java.lang.String descricaoDoMotivo);

    @net.vidageek.fluid.annotations.FluidField("id")
    Protocolo<T> withId(java.lang.String id);

}