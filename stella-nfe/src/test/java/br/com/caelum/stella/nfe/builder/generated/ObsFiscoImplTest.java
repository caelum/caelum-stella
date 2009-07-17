package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class ObsFiscoImplTest {
    @org.junit.Test
    public void testObsFiscoInterface() {
        ObservacaoFisco<Object> obsFisco = new ObservacaoFiscoImpl<Object>(new Object())
                                                                                        .withDescricaoDoTexto("abc")
                                                                                        .withDescricaoDoCampo("abc");
        BuilderTestHelper.assertModelWasFilled(obsFisco);
    }

}