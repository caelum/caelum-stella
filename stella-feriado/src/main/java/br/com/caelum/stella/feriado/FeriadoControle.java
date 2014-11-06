package br.com.caelum.stella.feriado;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.caelum.stella.feriado.entity.Feriado;
import br.com.caelum.stella.feriado.entity.FeriadosEstaduais;
import br.com.caelum.stella.feriado.entity.FeriadosMoveis;
import br.com.caelum.stella.feriado.entity.FeriadosNacionais;
import br.com.caelum.stella.feriado.enums.Lugares;
import br.com.caelum.stella.feriado.util.Ordernador;

public class FeriadoControle {

	
	private List<Feriado>  feriados = new ArrayList<Feriado>();
	
	public  List<Feriado> listarFeriados(){
		Collections.sort(feriados, Ordernador.DATA_CRESCENTE);
		return feriados;
	}
	
	public FeriadoControle feriadosMoveis(){
		feriados.addAll(FeriadosMoveis.doAno());
		return this;
	}
	
	public FeriadoControle feriadosMoveis(int ano){
		feriados.addAll(FeriadosMoveis.doAno(ano));
		return this;
	}
	
	public FeriadoControle feriadosNacionais(){
		feriados.addAll(FeriadosNacionais.doAno());
		return this;
	}
	
	public FeriadoControle feriadosNacionais(int ano){
		feriados.addAll(FeriadosNacionais.doAno(ano));
		return this;
	}
	
	public FeriadoControle feriadosEstaduais(Lugares...lugar){
		feriados.addAll(FeriadosEstaduais.de(lugar));
		return this;
	}
}
