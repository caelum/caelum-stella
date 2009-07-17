package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class ObsContImplTest {
    @org.junit.Test
    public void testObsContInterface() {
        ObservacaoDoContribuinte<Object> obsCont = new ObservacaoDoContribuinteImpl<Object>(new Object())
                                                                                                         .withTextoDeDescricao(
                                                                                                                 "abc")
                                                                                                         .withDescricaoDoCampo(
                                                                                                                 "abc");
        BuilderTestHelper.assertModelWasFilled(obsCont);
    }

}