package br.com.caelum.stella.boleto.bancos.gerador;

import br.com.caelum.stella.DigitoPara;
import static br.com.caelum.stella.boleto.utils.StellaStringUtils.leftPadWithZeros;

public class GeradorDeDigitoSantander extends GeradorDeDigitoPadrao {

	private static final long serialVersionUID = 1L;

	@Override
	public int geraDigitoBloco1(String bloco) {
		return calculaDVBloco(bloco);
	}

	@Override
	public int geraDigitoBloco2(String bloco) {
		return calculaDVBloco(bloco);
	}

	@Override
	public int geraDigitoBloco3(String bloco) {
		return calculaDVBloco(bloco);
	}

	public int calculaDVBloco(String bloco) {
		int soma = 0;
		for (int i = bloco.length() - 1, multiplicador = 2; i >= 0; i--, multiplicador--) {
			if (multiplicador == 0) {
				multiplicador = 2;
			}
			int parcial = Integer.parseInt(String.valueOf(bloco.charAt(i))) * multiplicador;

			if (parcial > 9) {
				parcial = parcial - 9;
			}

			soma += parcial;
		}

		int resto = soma % 10;
		if (resto == 0) {
			return 0;
		} else {
			return 10 - resto;
		}
	}
	
	public String calculaDVNossoNumero(String nossoNumero) {
		if (nossoNumero == null ||  nossoNumero.length() > 12) {
			throw new IllegalArgumentException("Nosso Número inválido: " + nossoNumero);
		}
		DigitoPara digitoPara = new DigitoPara(leftPadWithZeros(nossoNumero, 12));
		int digito = Integer.parseInt(digitoPara.comMultiplicadoresDeAte(2,9)
							.mod(11)
							.trocandoPorSeEncontrar("0", 1)
							.trocandoPorSeEncontrar("1", 10)
							.calcula());
		
		if (digito > 1) {
			digito = 11-digito;
		}
		
		return String.valueOf(digito);
	}

}
