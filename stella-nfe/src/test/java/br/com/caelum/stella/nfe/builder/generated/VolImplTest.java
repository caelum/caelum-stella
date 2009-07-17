package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class VolImplTest {
    @org.junit.Test
    public void testVolInterface() {
        Volume<Object> vol = new VolumeImpl<Object>(new Object())
                                                                 .withQuantidade(1l)
                                                                 .withEspecie("abc")
                                                                 .withMarca("abc")
                                                                 .withNumeracao("abc")
                                                                 .withPesoLiquido("abc")
                                                                 .withPesoBruto("abc")
                                                                 .withLacres(new LacresImpl<Object>(new Object()));
        BuilderTestHelper.assertModelWasFilled(vol);
    }

}