package br.com.caelum.stella.nfe.builder.generated;

public final class DestImplTest {
    @org.junit.Test
    public void testDestInterface() {
        Dest dest = new DestImpl().withCNPJ("abc").withCPF("abc").withXNome("abc").withEnderDest(new TEnderecoImpl())
                .withIE("abc").withISUF("abc");
        assertModelWasFilled(dest);
    }

    private void assertModelWasFilled(final Dest dest) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(dest).assertModelWasFilled();
    }
}