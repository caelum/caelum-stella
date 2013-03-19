package br.com.caelum.stella.boleto.bancos.gerador;

import java.util.ArrayList;
import java.util.List;

public class DigitoPara {

	private List<Integer> numero;
	private int inicio;
	private int fim;

	public DigitoPara(String trecho) {
		this.numero = new ArrayList<Integer>();
		char[] digitos = trecho.toCharArray();
		for (char digito : digitos) {
			this.numero.add(Character.getNumericValue(digito));
		}
	}

	public DigitoPara comMultiplicadoresDeAte(int inicio, int fim) {
		this.inicio = inicio;
		this.fim = fim;
		return this;
	}

	public int mod(int modulo) {
		int soma = 0;
		for (int i = numero.size() - 1, multiplicador = inicio; i >= 0; i--, multiplicador++) {
			if (multiplicador > fim)
				multiplicador = inicio;
			soma += numero.get(i) * multiplicador;
		}
		return modulo - (soma % modulo);
	}
	
}
