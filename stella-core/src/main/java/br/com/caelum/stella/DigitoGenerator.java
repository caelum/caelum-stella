package br.com.caelum.stella;

import java.util.Random;

public class DigitoGenerator {
	private static final Random RANDOM = new Random();

	public String generate(int quantidade) {
		final StringBuilder digitos = new StringBuilder();
		for (int i = 0; i < quantidade; i++) {
			digitos.append(RANDOM.nextInt(10));
		}
		return digitos.toString();
	}
}
