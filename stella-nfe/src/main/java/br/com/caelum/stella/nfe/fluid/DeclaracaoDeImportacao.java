package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.DI.class)
public interface DeclaracaoDeImportacao<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("ndi")
    DeclaracaoDeImportacao<T> withNumeroDoDocumentoDeImportacao(java.lang.String numeroDoDocumentoDeImportacao);

    @net.vidageek.fluid.annotations.FluidField("ddi")
    DeclaracaoDeImportacao<T> withDataDaDeclaracaoDeImportacao(java.util.Calendar dataDaDeclaracaoDeImportacao);

    @net.vidageek.fluid.annotations.FluidField("xLocDesemb")
    DeclaracaoDeImportacao<T> withLocalDeDesenbaraco(java.lang.String localDeDesenbaraco);

    @net.vidageek.fluid.annotations.FluidField("ufDesemb")
    DeclaracaoDeImportacao<T> withUFDoDesembaraco(br.com.caelum.stella.nfe.modelo.UF UFDoDesembaraco);

    @net.vidageek.fluid.annotations.FluidField("dDesemb")
    DeclaracaoDeImportacao<T> withDataDoDeembaraco(java.util.Calendar dataDoDeembaraco);

    @net.vidageek.fluid.annotations.FluidField("cExportador")
    DeclaracaoDeImportacao<T> withCodigoDoExportador(java.lang.String codigoDoExportador);

    @net.vidageek.fluid.annotations.FluidField("adi")
    Adicao<DeclaracaoDeImportacao<T>> addAdicao();

}