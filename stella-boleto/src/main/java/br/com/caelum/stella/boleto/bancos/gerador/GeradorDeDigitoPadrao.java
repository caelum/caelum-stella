package br.com.caelum.stella.boleto.bancos.gerador;

public class GeradorDeDigitoPadrao implements GeradorDeDigito {

	@Override
	public int geraDigitoMod11(String codigoDeBarras) {
		return geraDigitoMod(codigoDeBarras, 2, 9, 11);
	}

	@Override
	public int geraDigitoMod(String codigoDeBarras, int inicio, int fim, int numMOD) {

		int soma = 0;
		for (int i = codigoDeBarras.length() - 1, multiplicador = inicio; i >= 0; i--, multiplicador++) {
			if (multiplicador == fim + 1) {
				multiplicador = inicio;
			}
			soma += Integer.parseInt(String.valueOf(codigoDeBarras.charAt(i))) * multiplicador;
		}

		soma *= 10;

		int resto = soma % numMOD;

		if (resto == 10 || resto == 0) {
			return 1;
		} else {
			return resto;
		}

	}

	@Override
	public int geraDigitoMod10(String campo) {
		int soma = 0;
		for (int i = campo.length() - 1; i >= 0; i--) {
			int multiplicador = (campo.length() - i) % 2 + 1;
			int algarismoMultiplicado = Integer.parseInt(String.valueOf(campo.charAt(i))) * multiplicador;
			soma += (algarismoMultiplicado / 10) + (algarismoMultiplicado % 10);
		}

		int resto = soma % 10;
		int resultado = (10 - resto) % 10;
		return resultado;
	}

	@Override
	public int geraDigitoBloco1(String bloco) {
		return geraDigitoMod10(bloco);
	}

	@Override
	public int geraDigitoBloco2(String bloco) {
		return geraDigitoMod10(bloco);
	}

	@Override
	public int geraDigitoBloco3(String bloco) {
		return geraDigitoMod10(bloco);
	}

}
