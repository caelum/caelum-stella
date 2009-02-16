package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class AdiImplTest {
	@org.junit.Test
	public void testAdiInterface() {
		Adi adi = new AdiImpl().withNAdicao(123).withNSeqAdic(123)
				.withCFabricante("abc").withVDescDI(BigDecimal.ONE);
		assertModelWasFilled(adi);
	}

	private void assertModelWasFilled(Adi adi) {
		new br.com.caelum.stella.nfe.builder.BuilderTestHelper(adi)
				.assertModelWasFilled();
	}
}