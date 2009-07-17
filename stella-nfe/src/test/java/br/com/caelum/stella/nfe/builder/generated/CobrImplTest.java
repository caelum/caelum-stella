package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class CobrImplTest {
    @org.junit.Test
    public void testCobrInterface() {
        Cobranca<Object> cobr = new CobrancaImpl<Object>(new Object())
                                                                      .withFatura(new FaturaImpl<Object>(new Object()))
                                                                      .withDuplicatas(
                                                                              new DuplicataImpl<Object>(new Object()));
        BuilderTestHelper.assertModelWasFilled(cobr);
    }

}