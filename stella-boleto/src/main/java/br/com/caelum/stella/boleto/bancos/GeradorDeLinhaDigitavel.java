package br.com.caelum.stella.boleto.bancos;

import br.com.caelum.stella.boleto.bancos.gerador.GeradorDeDigito;
import br.com.caelum.stella.boleto.bancos.gerador.GeradorDeDigitoPadrao;

/**
 * Gera linha digitavel do boleto com base no codigo de barras.
 * 
 * @author Rodrigo Turini
 * @author Victor Harada
 *
 */
public class GeradorDeLinhaDigitavel {

	private GeradorDeDigito dvGenerator = new GeradorDeDigitoPadrao();

	/**
	 * Gera a linha digitavel do boleto de acordo com as normas do 
	 * carta circular 2926 do banco central do Brasil.
	 * 
	 * @param codigoDeBarras gerado pelo boleto
	 * @return linha digitavel formatada
	 */
	public String geraLinhaDigitavelPara(String codigoDeBarras) {
				
		StringBuilder builder = new StringBuilder();
		builder.append(codigoDeBarras.substring(0, 3));
		builder.append(codigoDeBarras.substring(3, 4));
		builder.append(codigoDeBarras.substring(19, 24));
		builder.append(dvGenerator.geraDigitoMod10(builder.toString()));
		builder.append(codigoDeBarras.substring(24, 34));
		builder.append(dvGenerator.geraDigitoMod10(builder.substring(10, 20)));
		builder.append(codigoDeBarras.substring(34));
		builder.append(dvGenerator.geraDigitoMod10(builder.substring(21, 31)));
		builder.append(codigoDeBarras.substring(4, 5));
		builder.append(codigoDeBarras.substring(5, 9));
		builder.append(codigoDeBarras.substring(9, 19));
		
		return linhaDigitavelFormatter(builder).toString();
	}

	private StringBuilder linhaDigitavelFormatter(StringBuilder linhaDigitavel) {
		linhaDigitavel.insert(5, '.');
		linhaDigitavel.insert(11, "  ");
		linhaDigitavel.insert(18, '.');
		linhaDigitavel.insert(25, "  ");
		linhaDigitavel.insert(32, '.');
		linhaDigitavel.insert(39, "  ");
		linhaDigitavel.insert(42, "  ");

		return linhaDigitavel;
	}
}
