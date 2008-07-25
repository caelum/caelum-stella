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
	    codigoDeBarras.append(dvGenerator.geraDVLinhaDigitavel(emissor
		    .getAgenciaFormatado()
		    + getContaCorrenteDoEmissorFormatado(emissor)
		    + getCarteiraDoEmissorFormatado(emissor)
		    + getNossoNumeroDoEmissorFormatado(emissor)));
	}
	codigoDeBarras.append(emissor.getAgenciaFormatado());
	codigoDeBarras.append(getContaCorrenteDoEmissorFormatado(emissor));
	codigoDeBarras.append(emissor.getDvContaCorrente());
	codigoDeBarras.append("000");

	String result = codigoDeBarras.toString();

	if (result.length() != 44) {
	    throw new CriacaoBoletoException(
		    "Erro na geração do código de barras.");
	}

	return result;
    }

    public String geraLinhaDigitavelPara(Boleto boleto) {
	// TODO Auto-generated method stub
	return null;
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
