package br.com.caelum.stella.boleto.bancos.gerador;

public class GeradorDeDigitoSantander extends GeradorDeDigitoPadrao {

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
}
