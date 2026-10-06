package br.com.caelum.stella.boleto;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.caelum.stella.boleto.bancos.CodigoDeBarrasBuilder;
import br.com.caelum.stella.boleto.bancos.Itau;

/**
 * Garante que o {@link CodigoDeBarrasBuilder} pode ser usado de fora do pacote
 * {@code br.com.caelum.stella.boleto.bancos}, permitindo criar suporte a novos
 * bancos sem alterar a biblioteca (issue #184).
 */
public class CodigoDeBarrasBuilderAcessoPublicoTest {

	@Test
	public void devePermitirMontarCodigoDeBarrasForaDoPacoteBancos() {
		Boleto boleto = Boleto.novoBoleto()
				.comDatas(Datas.novasDatas().comVencimento(1, 4, 2013))
				.comBanco(new Itau())
				.comValorBoleto(2680.16);

		String codigo = new CodigoDeBarrasBuilder(boleto)
				.comCampoLivre(new StringBuilder("0000000000000000000000000"));

		assertEquals(44, codigo.length());
		assertEquals("2", codigo.substring(4, 5));
	}
}
