package br.com.caelum.stella.nfe.builder.generated;

public final class AdiImplTest {
	@org.junit.Test
	public void testAdiInterface() {
		Adi adi = new AdiImpl().withNAdicao("").withNSeqAdic("")
				.withCFabricante("").withVDescDI("");
		assertModelWasFilled(adi);
	}

	private void assertModelWasFilled(Adi adi) {
		new br.com.caelum.stella.nfe.builder.BuilderTestHelper(adi)
				.assertModelWasFilled();
	}
}