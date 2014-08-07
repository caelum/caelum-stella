package br.com.caelum.stella.boleto.bancos.gerador;

import br.com.caelum.stella.DigitoPara;

public class GeradorDeDigitoPadrao implements GeradorDeDigito {

	private static final long serialVersionUID = 1L;

	@Override
	public int geraDigitoMod11(String codigoDeBarras) {
		return geraDigitoMod(codigoDeBarras, 2, 9, 11);
	}

	@Override
	public int geraDigitoMod(String codigoDeBarras, int inicio, int fim, int numMOD) {
		return Integer.valueOf(new DigitoPara(codigoDeBarras)
					.comMultiplicadoresDeAte(inicio, fim)
					.complementarAoModulo()
					.trocandoPorSeEncontrar("1", 0, 1, 10, 11)
					.mod(numMOD)
					.calcula());
	}

	@Override
	public int geraDigitoMod10(String campo) {
		return Integer.valueOf(new DigitoPara(campo).comMultiplicadores(2, 1)
				.somandoIndividualmente().trocandoPorSeEncontrar("0", 10)
				.complementarAoModulo().mod(10).calcula());
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

	@Override
	public int geraDigitoMod11AceitandoRestoZero(String codigoDeBarras) {
		return geraDigitoModAceitandoRestoZero(codigoDeBarras, 2, 9, 11);
	}

	@Override
	public int geraDigitoModAceitandoRestoZero(String codigoDeBarras,
			int inicio, int fim, int numMod) {
		return Integer.valueOf(new DigitoPara(codigoDeBarras)
				.comMultiplicadoresDeAte(inicio, fim)
				.complementarAoModulo()
				.trocandoPorSeEncontrar("0", 0, 10, 11)
				.mod(numMod)
				.calcula());
	}

}
