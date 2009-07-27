package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.Ide.class)
public interface IdentificacaoDaNFE<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("cuf")
    IdentificacaoDaNFE<T> withCodigoUFDoEmitente(java.lang.String codigoUFDoEmitente);

    @net.vidageek.fluid.annotations.FluidField("cnf")
    IdentificacaoDaNFE<T> withCodigoDaNF(java.lang.Integer codigoDaNF);

    @net.vidageek.fluid.annotations.FluidField("natOp")
    IdentificacaoDaNFE<T> withDescricaoDaNaturezaDaOperacao(java.lang.String descricaoDaNaturezaDaOperacao);

    @net.vidageek.fluid.annotations.FluidField("indPag")
    IdentificacaoDaNFE<T> withFormaDePagamento(java.lang.String formaDePagamento);

    @net.vidageek.fluid.annotations.FluidField("mod")
    IdentificacaoDaNFE<T> withModeloDoDocumentoFiscal(java.lang.String modeloDoDocumentoFiscal);

    @net.vidageek.fluid.annotations.FluidField("serie")
    IdentificacaoDaNFE<T> withSerie(java.lang.String serie);

    @net.vidageek.fluid.annotations.FluidField("nnf")
    IdentificacaoDaNFE<T> withNumeroDoDocumentoFiscal(java.lang.String numeroDoDocumentoFiscal);

    @net.vidageek.fluid.annotations.FluidField("dEmi")
    IdentificacaoDaNFE<T> withDataDeEmissao(java.util.Calendar dataDeEmissao);

    @net.vidageek.fluid.annotations.FluidField("dSaiEnt")
    IdentificacaoDaNFE<T> withDataDeSaidaOuEntrada(java.util.Calendar dataDeSaidaOuEntrada);

    @net.vidageek.fluid.annotations.FluidField("tpNF")
    IdentificacaoDaNFE<T> withTipoDoDocumentoFiscal(java.lang.String tipoDoDocumentoFiscal);

    @net.vidageek.fluid.annotations.FluidField("cMunFG")
    IdentificacaoDaNFE<T> withCodigoDoMunicipioDeOcorrenciaDoFatoGerador(java.lang.String codigoDoMunicipioDeOcorrenciaDoFatoGerador);

    @net.vidageek.fluid.annotations.FluidField("nFref")
    InformacaoDaNFReferenciada<IdentificacaoDaNFE<T>> addInformacoesDaNFReferenciada();

    @net.vidageek.fluid.annotations.FluidField("tpImp")
    IdentificacaoDaNFE<T> withFormatoDeImpressao(java.lang.String formatoDeImpressao);

    @net.vidageek.fluid.annotations.FluidField("tpEmis")
    IdentificacaoDaNFE<T> withFormaDeEmissao(java.lang.String formaDeEmissao);

    @net.vidageek.fluid.annotations.FluidField("cdv")
    IdentificacaoDaNFE<T> withDigitoVerificadorDaChaveDeAcessoDaNFE(java.lang.String digitoVerificadorDaChaveDeAcessoDaNFE);

    @net.vidageek.fluid.annotations.FluidField("tpAmb")
    IdentificacaoDaNFE<T> withTipoDoAmbiente(br.com.caelum.stella.nfe.fluid.enums.TipoDoAmbiente tipoDoAmbiente);

    @net.vidageek.fluid.annotations.FluidField("finNFe")
    IdentificacaoDaNFE<T> withFinalidadeDaEmissaoDaNFE(java.lang.String finalidadeDaEmissaoDaNFE);

    @net.vidageek.fluid.annotations.FluidField("procEmi")
    IdentificacaoDaNFE<T> withProcessoDeEmissao(java.lang.String processoDeEmissao);

    @net.vidageek.fluid.annotations.FluidField("verProc")
    IdentificacaoDaNFE<T> withVersaoDoAplicativoUsadoNaEmissao(java.lang.String versaoDoAplicativoUsadoNaEmissao);

}