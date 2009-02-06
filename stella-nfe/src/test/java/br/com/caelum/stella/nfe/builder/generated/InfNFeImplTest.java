package br.com.caelum.stella.nfe.builder.generated;

public final class InfNFeImplTest {
    @org.junit.Test
    public void testInfNFeInterface() {
        InfNFe infNFe = new InfNFeImpl().withIde(new IdeImpl()).withEmit(new EmitImpl()).withAvulsa(new AvulsaImpl())
                .withDest(new DestImpl()).withRetirada(new TLocalImpl()).withEntrega(new TLocalImpl()).withDet(
                        new DetImpl()).withTotal(new TotalImpl()).withTransp(new TranspImpl()).withCobr(new CobrImpl())
                .withInfAdic(new InfAdicImpl()).withExporta(new ExportaImpl()).withCompra(new CompraImpl()).withVersao(
                        "abc").withId("abc");
        assertModelWasFilled(infNFe);
    }

    private void assertModelWasFilled(final InfNFe infNFe) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(infNFe).assertModelWasFilled();
    }
}