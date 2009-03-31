package br.com.caelum.stella.nfe.builder.generated;

public interface InformacoesAdicionais {
    public InformacoesAdicionais withInformacoesAdicionaisDeInteresseDoFisco(String string);

    public InformacoesAdicionais withInformacoesComplementares(String string);

    public InformacoesAdicionais withObservacoesDoContribuinte(ObservacaoDoContribuinte... obsConts);

    public InformacoesAdicionais withObsFisco(ObservacaoFisco... obsFiscos);

    public InformacoesAdicionais withProcRef(ProcessoReferenciado... procRefs);
}