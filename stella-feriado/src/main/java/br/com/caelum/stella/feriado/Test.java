package br.com.caelum.stella.feriado;

import br.com.caelum.stella.feriado.entity.Feriado;
import br.com.caelum.stella.feriado.enums.Lugares;
import br.com.caelum.stella.feriado.util.Ordernador;

public class Test {
	public static void main(String[] args) {
			for(Feriado f: new FeriadoControle().feriadosEstaduais(Lugares.RJ).ordenadoPor(Ordernador.LUGAR).listarFeriados()){
				System.out.println(f);
			}
	}
}