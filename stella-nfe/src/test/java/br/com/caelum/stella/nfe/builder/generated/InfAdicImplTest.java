package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class InfAdicImplTest {
    @org.junit.Test
    public void testInfAdicInterface() {
        InformacoesAdicionais<Object> infAdic = new InformacoesAdicionaisImpl<Object>(new Object())
                                                                                                   .withInformacoesAdicionaisDeInteresseDoFisco(
                                                                                                           "abc")
                                                                                                   .withInformacoesComplementares(
                                                                                                           "abc")
                                                                                                   .withObservacoesDoContribuinte(
                                                                                                           new ObservacaoDoContribuinteImpl<Object>(
                                                                                                                   new Object()))
                                                                                                   .withObsFisco(
                                                                                                           new ObservacaoFiscoImpl<Object>(
                                                                                                                   new Object()))
                                                                                                   .withProcRef(
                                                                                                           new ProcessoReferenciadoImpl<Object>(
                                                                                                                   new Object()));
        BuilderTestHelper.assertModelWasFilled(infAdic);
    }

}