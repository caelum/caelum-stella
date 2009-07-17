package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface InformacoesAdicionais<T> extends NFeBuilder<T> {
    public InformacoesAdicionais<T> withInformacoesAdicionaisDeInteresseDoFisco(String string);

    public InformacoesAdicionais<T> withInformacoesComplementares(String string);

    public InformacoesAdicionais<T> withObservacoesDoContribuinte(ObservacaoDoContribuinte<?>... obsConts);

    public InformacoesAdicionais<T> withObsFisco(ObservacaoFisco<?>... obsFiscos);

    public InformacoesAdicionais<T> withProcRef(ProcessoReferenciado<?>... procRefs);
}