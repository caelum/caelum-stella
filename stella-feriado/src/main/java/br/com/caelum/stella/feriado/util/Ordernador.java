package br.com.caelum.stella.feriado.util;

import java.util.Comparator;

import br.com.caelum.stella.feriado.entity.Feriado;

public class Ordernador {


	public static final Comparator<Feriado> DATA_CRESCENTE = new Comparator<Feriado>() {
		@Override
		public int compare(Feriado f1, Feriado f2) {
			return f1.getData().compareTo(f2.getData());
		}
	};

	public static final Comparator<Feriado> DATA_DECRESCENTE = new Comparator<Feriado>() {
		@Override
		public int compare(Feriado f1, Feriado f2) {
			return f2.getData().compareTo(f1.getData());
		}
	};

	
	public static final Comparator<Feriado> LUGAR = new Comparator<Feriado>() {
		@Override
		public int compare(Feriado f1, Feriado f2) {
			return f1.getLocal().compareTo(f2.getLocal());
		}
	};
	
	public static final Comparator<Feriado> NOME_CRESCENTE = new Comparator<Feriado>() {
		@Override
		public int compare(Feriado f1, Feriado f2) {
			return f1.getNome().compareTo(f2.getNome());
		}
	};

	public static final Comparator<Feriado> NOME_DECRESCENTE = new Comparator<Feriado>() {
		@Override
		public int compare(Feriado f1, Feriado f2) {
			return f2.getNome().compareTo(f1.getNome());
		}
	};
}
