package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.InfAdic.class)
public interface InformacoesAdicionais<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("infAdFisco")
    InformacoesAdicionais<T> withInformacoesAdicionaisDeInteresseDoFisco(java.lang.String InformacoesAdicionaisDeInteresseDoFisco);

    @net.vidageek.fluid.annotations.FluidField("infCpl")
    InformacoesAdicionais<T> withInformacoesComplementares(java.lang.String informacoesComplementares);

    @net.vidageek.fluid.annotations.FluidField("obsCont")
    ObservacaoDoContribuinte<InformacoesAdicionais<T>> addObservacoesDoContribuinte();

    @net.vidageek.fluid.annotations.FluidField("obsFisco")
    ObservacaoFisco<InformacoesAdicionais<T>> addObsFisco();

    @net.vidageek.fluid.annotations.FluidField("procRef")
    ProcessoReferenciado<InformacoesAdicionais<T>> addProcRef();

}