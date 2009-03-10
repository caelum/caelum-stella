package br.com.caelum.stella.nfe.builder.generated;

public final class InfNFeImplTest {
    @org.junit.Test
    public void testInfNFeInterface() {
        InformacoesDaNFE infNFe = new InfNFeImpl().withIde(new IdeImpl()).withEmit(new EmitImpl()).withAvulsa(new AvulsaImpl())
                .withDest(new DestImpl()).withRetirada(new DadosDoLocalImpl()).withEntrega(new DadosDoLocalImpl()).withDet(
                        new DetImpl()).withTotal(new TotalNFEImpl()).withTransp(new TransporteImpl()).withCobr(new CobrImpl())
                .withInfAdic(new InfAdicImpl()).withExporta(new ExportaImpl()).withCompra(new CompraImpl()).withVersao(
                        "abc").withId("abc");
        assertModelWasFilled(infNFe);
    }

    private void assertModelWasFilled(final InformacoesDaNFE infNFe) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(infNFe).assertModelWasFilled();
    }
}