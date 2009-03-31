package br.com.caelum.stella.nfe.builder.generated;

public final class InfAdicImplTest {
    @org.junit.Test
    public void testInfAdicInterface() {
        InformacoesAdicionais infAdic = new InformacoesAdicionaisImpl().withInformacoesAdicionaisDeInteresseDoFisco("abc").withInformacoesComplementares("abc").withObservacoesDoContribuinte(new ObservacaoDoContribuinteImpl())
                .withObsFisco(new ObservacaoFiscoImpl()).withProcRef(new ProcessoReferenciadoImpl());
        assertModelWasFilled(infAdic);
    }

    private void assertModelWasFilled(final InformacoesAdicionais infAdic) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(infAdic).assertModelWasFilled();
    }
}