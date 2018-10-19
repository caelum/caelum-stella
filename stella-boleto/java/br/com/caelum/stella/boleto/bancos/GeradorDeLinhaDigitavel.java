package br.com.caelum.stella.boleto.bancos;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.bancos.gerador.GeradorDeDigito;

/**
 * Gera linha digitavel do boleto com base no codigo de barras.
 * 
 * @author Rodrigo Turini
 * @author Victor Harada
 *
 */
public class GeradorDeLinhaDigitavel {

	/**
	 * Gera a linha digitavel do boleto de acordo com normas 
	 * da carta circular n. 2926 do banco central do Brasil.
	 * Disponível para consulta em caelum.stella.boleto.doc
	 * 
	 * @param codigoDeBarras gerado pelo boleto
	 * @param banco banco para o qual estamos gerando o boleto.
	 * @return linha digitavel já formatada de acordo com padrao
	 */
	public String geraLinhaDigitavelPara(String codigoDeBarras, Banco banco) {
		
		if (codigoDeBarras.length()!= 44){
			throw new IllegalArgumentException("O código de barras" +
				" precisa ter 44 digitos");
		}
				
		GeradorDeDigito dvGenerator = banco.getGeradorDeDigito();

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
		
		return formata(builder).toString();
	}
	
	private StringBuilder formata(StringBuilder linhaDigitavel) {
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
