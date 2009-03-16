package br.com.caelum.stella.nfe.builder.generated;

public interface InfAdic {
    public InfAdic withInfAdFisco(String string);

    public InfAdic withInfCpl(String string);

    public InfAdic withObsCont(ObservacoesDoContribuinte... obsConts);

    public InfAdic withObsFisco(ObservacaoFisco... obsFiscos);

    public InfAdic withProcRef(ProcessoReferenciado... procRefs);
}