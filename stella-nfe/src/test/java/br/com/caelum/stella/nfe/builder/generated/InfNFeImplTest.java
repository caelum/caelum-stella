package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class InfNFeImplTest {
    @org.junit.Test
    public void testInfNFeInterface() {
        InformacoesDaNFE<Object> infNFe = new InfNFeImpl<Object>(new Object())
                                                                              .withIde(
                                                                                      new IdentificacaoDaNFEImpl<Object>(
                                                                                              new Object()))
                                                                              .withEmit(
                                                                                      new EmitenteImpl<Object>(
                                                                                              new Object()))
                                                                              .withAvulsa(
                                                                                      new AvulsaImpl<Object>(
                                                                                              new Object()))
                                                                              .withDest(
                                                                                      new DestinatarioImpl<Object>(
                                                                                              new Object()))
                                                                              .withRetirada(
                                                                                      new DadosDoLocalImpl<Object>(
                                                                                              new Object()))
                                                                              .withEntrega(
                                                                                      new DadosDoLocalImpl<Object>(
                                                                                              new Object()))
                                                                              .withDet(
                                                                                      new DetalheImpl<Object>(
                                                                                              new Object()))
                                                                              .withTotal(
                                                                                      new TotalNFEImpl<Object>(
                                                                                              new Object()))
                                                                              .withTransp(
                                                                                      new TransporteImpl<Object>(
                                                                                              new Object()))
                                                                              .withCobr(
                                                                                      new CobrancaImpl<Object>(
                                                                                              new Object()))
                                                                              .withInfAdic(
                                                                                      new InformacoesAdicionaisImpl<Object>(
                                                                                              new Object()))
                                                                              .withExporta(
                                                                                      new ExportacaoImpl<Object>(
                                                                                              new Object()))
                                                                              .withCompra(
                                                                                      new CompraImpl<Object>(
                                                                                              new Object()))
                                                                              .withVersao("abc")
                                                                              .withId("abc");
        BuilderTestHelper.assertModelWasFilled(infNFe);
    }

}