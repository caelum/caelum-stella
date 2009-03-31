package br.com.caelum.stella.nfe.builder.generated;

public final class InfNFeImplTest {
    @org.junit.Test
    public void testInfNFeInterface() {
        InformacoesDaNFE infNFe = new InfNFeImpl().withIde(new IdentificacaoDaNFEImpl()).withEmit(new EmitenteImpl()).withAvulsa(new AvulsaImpl())
                .withDest(new DestinatarioImpl()).withRetirada(new DadosDoLocalImpl()).withEntrega(new DadosDoLocalImpl()).withDet(
                        new DetalheImpl()).withTotal(new TotalNFEImpl()).withTransp(new TransporteImpl()).withCobr(new CobrancaImpl())
                .withInfAdic(new InformacoesAdicionaisImpl()).withExporta(new ExportacaoImpl()).withCompra(new CompraImpl()).withVersao(
                        "abc").withId("abc");
        assertModelWasFilled(infNFe);
    }

    private void assertModelWasFilled(final InformacoesDaNFE infNFe) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(infNFe).assertModelWasFilled();
    }
}