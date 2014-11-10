package br.com.caelum.stella.feriado;

import br.com.caelum.stella.feriado.entity.Feriado;
import br.com.caelum.stella.feriado.enums.Lugares;

public class Test {
	public static void main(String[] args) {
			for(Feriado f: new FeriadoControle().feriadosNacionais(2014).feriadosEstaduais(Lugares.RJ).listarFeriados()){
				System.out.println(f);
			}
	}
}