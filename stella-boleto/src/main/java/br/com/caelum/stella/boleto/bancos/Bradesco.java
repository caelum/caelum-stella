package br.com.caelum.stella.boleto.bancos;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.CriacaoBoletoException;
import br.com.caelum.stella.boleto.Emissor;

/**
 * Gera dados de um boleto relativos ao Banco Bradesco.
 * 
 * @see <a *
 *      href="http://stella.caelum.com.br/boleto-setup.html">http://stella.caelum
 *      * .com.br/boleto-setup.html< /a>
 * 
 * @see <a * href=
 *      "http://www.bradesco.com.br/br/pj/conteudo/sol_rec/pdf/manualtecnico.pdf"
 *      >MANUAL * DO BLOQUETO DE COBRANÇA< /a>
 * 
 * @author Leonardo Bessa
 * 
 */
public class Bradesco implements Banco {

    private static final String NUMERO_BRADESCO = "237";

    private final DVGenerator dvGenerator = new DVGenerator();

    public String geraCodigoDeBarrasPara(Boleto boleto) {
	StringBuilder codigoDeBarras = new StringBuilder();
	codigoDeBarras.append(getNumeroFormatado());
	codigoDeBarras.append(String.valueOf(boleto.getCodEspecieMoeda()));
	// Digito Verificador sera inserido aqui.

	codigoDeBarras.append(boleto.getFatorVencimento());
	codigoDeBarras.append(boleto.getValorFormatado());

	// CAMPO LIVRE
	codigoDeBarras.append(boleto.getEmissor().getAgenciaFormatado());
	codigoDeBarras
		.append(getCarteiraDoEmissorFormatado(boleto.getEmissor()));
	codigoDeBarras.append(String.format("%011d", Integer.parseInt(boleto
		.getEmissor().getNossoNumero())));
	codigoDeBarras.append(getContaCorrenteDoEmissorFormatado(boleto
		.getEmissor()));
	codigoDeBarras.append("0");

	codigoDeBarras.insert(4, dvGenerator
		.geraDVCodigoDeBarras(codigoDeBarras.toString()));

	String result = codigoDeBarras.toString();

	if (result.length() != 44) {
	    throw new CriacaoBoletoException(
		    "Erro na geração do código de barras.");
	}

	return result;
    }

    public String geraLinhaDigitavelPara(Boleto boleto) {
	String codigoDeBarras = geraCodigoDeBarrasPara(boleto);

	StringBuilder bloco1 = new StringBuilder();
	bloco1.append(getNumeroFormatado());
	bloco1.append(String.valueOf(boleto.getCodEspecieMoeda()));
	bloco1.append(codigoDeBarras.substring(19, 24));
	bloco1.append(dvGenerator.geraDVLinhaDigitavel(bloco1.toString()));

	StringBuilder bloco2 = new StringBuilder();
	bloco2.append(codigoDeBarras.substring(24, 34));
	bloco2.append(dvGenerator.geraDVLinhaDigitavel(bloco2.toString()));

	StringBuilder bloco3 = new StringBuilder();
	bloco3.append(codigoDeBarras.substring(34, 44));
	bloco3.append(dvGenerator.geraDVLinhaDigitavel(bloco3.toString()));

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
	return NUMERO_BRADESCO;
    }

    public java.net.URL getImage() {
	return getClass().getResource(
		String.format("/br/com/caelum/stella/boleto/img/%s.png",
			getNumeroFormatado()));
    }

    public String getContaCorrenteDoEmissorFormatado(Emissor emissor) {
	return String.format("%07d", emissor.getContaCorrente());
    }

    public String getCarteiraDoEmissorFormatado(Emissor emissor) {
	return String.format("%02d", emissor.getCarteira());
    }

}
