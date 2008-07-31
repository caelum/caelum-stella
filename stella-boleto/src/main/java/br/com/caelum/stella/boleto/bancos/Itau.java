package br.com.caelum.stella.boleto.bancos;

import java.net.URL;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.CriacaoBoletoException;
import br.com.caelum.stella.boleto.Emissor;

public class Itau implements Banco {

    private static final String NUMERO_ITAU = "341";

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
	codigoDeBarras.append(getCarteiraDoEmissorFormatado(emissor));
	codigoDeBarras.append(getNossoNumeroDoEmissorFormatado(emissor));
	if (emissor.getCarteira() == 126 || emissor.getCarteira() == 131
		|| emissor.getCarteira() == 146 || emissor.getCarteira() == 150
		|| emissor.getCarteira() == 168) {
	    codigoDeBarras
		    .append(dvGenerator
			    .geraDVLinhaDigitavel(getCarteiraDoEmissorFormatado(emissor)
				    + getNossoNumeroDoEmissorFormatado(emissor)));
	} else {
	    /*
	     * codigoDeBarras.append(dvGenerator.geraDVLinhaDigitavel(emissor
	     * .getAgenciaFormatado() +
	     * getContaCorrenteDoEmissorFormatado(emissor) +
	     * getCarteiraDoEmissorFormatado(emissor) +
	     * getNossoNumeroDoEmissorFormatado(emissor)));
	     */
	    codigoDeBarras.append("8");
	}
	codigoDeBarras.append(emissor.getAgenciaFormatado());
	codigoDeBarras.append(getContaCorrenteDoEmissorFormatado(emissor));
	codigoDeBarras.append(emissor.getDvContaCorrente());
	codigoDeBarras.append("000");

	codigoDeBarras.insert(4, dvGenerator
		.geraDVCodigoDeBarras(codigoDeBarras.toString()));

	String result = codigoDeBarras.toString();

	if (result.length() != 44) {
	    throw new CriacaoBoletoException(
		    "Erro na geração do código de barras.");
	}

	return result;
    }

    // TODO ver se está certo
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

    public String getCarteiraDoEmissorFormatado(Emissor emissor) {
	return String.format("%03d", emissor.getCarteira());
    }

    public String getContaCorrenteDoEmissorFormatado(Emissor emissor) {
	return String.format("%05d", emissor.getContaCorrente());
    }

    public URL getImage() {
	return getClass().getResource(
		String.format("/br/com/caelum/stella/boleto/img/%s.png",
			getNumeroFormatado()));
    }

    public String getNossoNumeroDoEmissorFormatado(Emissor emissor) {
	return String.format("%08d", emissor.getNossoNumero());
    }

    public String getNumeroFormatado() {
	return NUMERO_ITAU;
    }

}
