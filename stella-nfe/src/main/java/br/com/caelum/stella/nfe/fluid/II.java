package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.II.class)
public interface II<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("valorDaBaseDeCalculo")
    II<T> withValorDaBaseDeCalculo(java.lang.String valorDaBaseDeCalculo);

    @net.vidageek.fluid.annotations.FluidField("valorDespesaAduaneira")
    II<T> withValorDespesaAduaneira(java.lang.String valorDespesaAduaneira);

    @net.vidageek.fluid.annotations.FluidField("valorImpostoImportacao")
    II<T> withValorImpostoImportacao(java.lang.String valorImpostoImportacao);

    @net.vidageek.fluid.annotations.FluidField("valorImpostoSobreOperacoesFinanceiras")
    II<T> withValorImpostoSobreOperacoesFinanceiras(java.lang.String valorImpostoSobreOperacoesFinanceiras);

}