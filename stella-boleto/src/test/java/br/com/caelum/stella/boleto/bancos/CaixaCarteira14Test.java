package br.com.caelum.stella.boleto.bancos;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;

/**
 * Regressao do exemplo de cobranca registrada SIGCB da issue #172.
 *
 * @see <a href="https://github.com/caelum/caelum-stella/issues/172">Issue #172</a>
 */
public class CaixaCarteira14Test {

	private Boleto boleto;

	@Before
	public void setUp() {
		Beneficiario beneficiario = Beneficiario.novoBeneficiario()
				.comCarteira("14")
				.comCodigoBeneficiario("528178")
				.comDigitoCodigoBeneficiario("4")
				.comNossoNumero("14000000000000241");

		Datas datas = Datas.novasDatas().comVencimento(30, 7, 2015);

		boleto = Boleto.novoBoleto().comBanco(new Caixa())
				.comBeneficiario(beneficiario).comDatas(datas)
				.comValorBoleto("110.00");
	}

	@Test
	public void deveGerarCodigoDeBarrasDaCobrancaRegistradaDaIssue172() {
		// O exemplo inclui DV zero no campo livre, permitido pelo Anexo III do manual SIGCB.
		assertEquals("10499650500000110005281784000100040000002410",
				boleto.getCodigoDeBarras());
	}

	@Test
	public void deveGerarLinhaDigitavelDaCobrancaRegistradaDaIssue172() {
		assertEquals("10495.28175  84000.100044  00000.024109  9  65050000011000",
				boleto.getLinhaDigitavel());
	}
}
