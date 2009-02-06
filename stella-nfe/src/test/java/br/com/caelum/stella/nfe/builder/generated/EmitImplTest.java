package br.com.caelum.stella.nfe.builder.generated;

public final class EmitImplTest {
    @org.junit.Test
    public void testEmitInterface() {
        Emit emit = new EmitImpl().withCNPJ("abc").withCPF("abc").withXNome("abc").withXFant("abc").withEnderEmit(
                new TEnderecoImpl()).withIE("abc").withIEST("abc").withIM("abc").withCNAE("abc");
        assertModelWasFilled(emit);
    }

    private void assertModelWasFilled(final Emit emit) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(emit).assertModelWasFilled();
    }
}