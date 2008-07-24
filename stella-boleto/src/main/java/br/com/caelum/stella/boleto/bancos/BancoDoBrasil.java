package br.com.caelum.stella.boleto.bancos;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.CriacaoBoletoException;
import br.com.caelum.stella.boleto.Emissor;

/**
 * Gera dados de um boleto relativos ao Banco do Brasil.
 * 
 * @see <a *
 *      href="http://stella.caelum.com.br/boleto-setup.html">http://stella.caelum
 *      * .com.br/boleto-setup.html< /a>
 * 
 * @author Cauê Guerra
 * @author Paulo Silveira
 * 
 */
public class BancoDoBrasil implements Banco {

    private static final String NUMERO_BB = "001";

    private final DVGenerator dvGenerator = new DVGenerator();

    public String geraCodigoDeBarrasPara(Boleto boleto) {
	StringBuilder codigoDeBarras = new StringBuilder();
	codigoDeBarras.append(getNumeroFormatado());
	codigoDeBarras.append(String.valueOf(boleto.getCodEspecieMoeda()));
	// Digito Verificador sera inserido aqui.

	codigoDeBarras.append(boleto.getFatorVencimento());
	codigoDeBarras.append(boleto.getValorFormatado());

	Emissor emissor = boleto.getEmissor();
	// CAMPO LIVRE
	if (emissor.getNumConvenio() < 1000000) {
	    if (emissor.getCarteira() == 16 || emissor.getCarteira() == 18) {
		codigoDeBarras
			.append(getNumConvenioDoEmissorFormatado(emissor));
		codigoDeBarras
			.append(getNossoNumeroDoEmissorFormatado(emissor));
		codigoDeBarras.append("21");
	    } else {
		codigoDeBarras
			.append(getNossoNumeroDoEmissorFormatado(emissor));
		codigoDeBarras.append(emissor.getAgenciaFormatado());
		codigoDeBarras.append(emissor.getCedente());
		codigoDeBarras.append(boleto.getBanco()
			.getCarteiraDoEmissorFormatado(emissor));
	    }
	} else if (emissor.getCarteira() == 17 || emissor.getCarteira() == 18) {
	    codigoDeBarras.append("000000");
	    codigoDeBarras.append(getNumConvenioDoEmissorFormatado(emissor));
	    codigoDeBarras.append(getNossoNumeroDoEmissorFormatado(emissor)
		    .substring(7));
	    codigoDeBarras.append(boleto.getBanco()
		    .getCarteiraDoEmissorFormatado(emissor));
	} else {
	    throw new CriacaoBoletoException(
		    "Erro na geração do código de barras.");
	}

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
	return NUMERO_BB;
    }

    public java.net.URL getImage() {
	return getClass().getResource(
		String.format("/br/com/caelum/stella/boleto/img/%s.png",
			getNumeroFormatado()));
    }

    public String getNumConvenioDoEmissorFormatado(Emissor emissor) {
	if (emissor.getNumConvenio() < 1000000) {
	    return String.format("%06d", emissor.getNumConvenio());
	} else {
	    return String.format("%07d", emissor.getNumConvenio());
	}
    }

    public String getContaCorrenteDoEmissorFormatado(Emissor emissor) {
	return String.format("%08d", emissor.getContaCorrente());
    }

    public String getCarteiraDoEmissorFormatado(Emissor emissor) {
	return String.format("%02d", emissor.getCarteira());
    }

    public String getNossoNumeroDoEmissorFormatado(Emissor emissor) {
	if (emissor.getCarteira() == 18) {
	    return String.format("%017d", emissor.getNossoNumero());
	} else {
	    return String.format("%011d", emissor.getNossoNumero());
	}
    }

}
