package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class AdiImplTest {
	@org.junit.Test
	public void testAdiInterface() {
		Adicao adi = new AdicoesImpl().withNumeroDaAdicao(123).withNumeroSequencialDoItemDaAdicao(123)
				.withCodigoDoFabricanteEstrangeiro("abc").withValorDeDescontoDoItemDaDI(BigDecimal.ONE);
		assertModelWasFilled(adi);
	}

	private void assertModelWasFilled(Adicao adi) {
		new br.com.caelum.stella.nfe.builder.BuilderTestHelper(adi)
				.assertModelWasFilled();
	}
}