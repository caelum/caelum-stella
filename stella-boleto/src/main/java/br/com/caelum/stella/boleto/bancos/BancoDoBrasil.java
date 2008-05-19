package br.com.caelum.stella.boleto.bancos;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;

/**
 * Gera dados de um boleto relativos ao Banco do Brasil.
 * 
 * @see <a
 *      href="http://stella.caelum.com.br/boleto-setup.html">http://stella.caelum.com.br/boleto-setup.html</a>
 * 
 * @author Cauê Guerra
 * @author Paulo Silveira
 * 
 */
public class BancoDoBrasil implements Banco {

	private static final String NUMERO_BB = "001";

	private final DVGenerator dvGenerator = new DVGenerator();

	public BancoDoBrasil() {

	}

	public String geraCodigoDeBarrasPara(Boleto boleto) {
		StringBuilder codigoDeBarras = new StringBuilder();
		codigoDeBarras.append(getNumeroFormatado());
		codigoDeBarras.append(String.valueOf(boleto.getCodEspecieMoeda()));
		codigoDeBarras.append(String.valueOf(boleto.getFatorVencimento()));
		codigoDeBarras.append(boleto.getValorFormatado());

		// CAMPO LIVRE
		codigoDeBarras.append("000000");
		codigoDeBarras.append(boleto.getEmissor().getNumConvenioFormatado());
		codigoDeBarras.append(boleto.getEmissor().getNossoNumeroFormatado());
		codigoDeBarras.append(boleto.getEmissor().getCarteira());

		codigoDeBarras.insert(4, this.dvGenerator
				.geraDVCodigoDeBarras(codigoDeBarras.toString()));

		return codigoDeBarras.toString();
	}

	public String geraLinhaDigitavelPara(Boleto boleto) {
		String codigoDeBarras = geraCodigoDeBarrasPara(boleto);

		StringBuilder bloco1 = new StringBuilder();
		bloco1.append(getNumeroFormatado());
		bloco1.append(String.valueOf(boleto.getCodEspecieMoeda()));
		bloco1.append(codigoDeBarras.substring(19, 24));
		bloco1.append(this.dvGenerator.geraDVLinhaDigitavel(bloco1.toString()));

		StringBuilder bloco2 = new StringBuilder();
		bloco2.append(codigoDeBarras.substring(24, 34));
		bloco2.append(this.dvGenerator.geraDVLinhaDigitavel(bloco2.toString()));

		StringBuilder bloco3 = new StringBuilder();
		bloco3.append(codigoDeBarras.substring(34, 44));
		bloco3.append(this.dvGenerator.geraDVLinhaDigitavel(bloco3.toString()));

		StringBuilder bloco4 = new StringBuilder();
		bloco4.append(codigoDeBarras.charAt(4));
		bloco4.append(codigoDeBarras.substring(5, 9));
		bloco4.append(boleto.getValorFormatado());

		StringBuilder linhaDigitavel = new StringBuilder();
		linhaDigitavel.append(bloco1);
		linhaDigitavel.append(bloco2);
		linhaDigitavel.append(bloco3);
		linhaDigitavel.append(bloco4);

		linhaDigitavel = linhaDigitavelFormater(linhaDigitavel);

		return linhaDigitavel.toString();
	}

	private StringBuilder linhaDigitavelFormater(StringBuilder linhaDigitavel) {
		linhaDigitavel.insert(5, '.');
		linhaDigitavel.insert(11, "  ");
		linhaDigitavel.insert(18, '.');
		linhaDigitavel.insert(25, "  ");
		linhaDigitavel.insert(32, '.');
		linhaDigitavel.insert(39, "  ");
		linhaDigitavel.insert(42, "  ");

		return linhaDigitavel;
	}

	public String getNumeroFormatado() {
		return NUMERO_BB;
	}

	public java.net.URL getImage() {
		return getClass().getResource(
				String.format("/br/com/caelum/stella/boleto/img/%s.png",
						getNumeroFormatado()));
	}

}
