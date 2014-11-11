package br.com.caelum.stella.feriado.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import br.com.caelum.stella.feriado.enums.Tipo;
import br.com.caelum.stella.feriado.util.DateUtil;
import br.com.caelum.stella.feriado.util.Ordernador;

public class FeriadosMoveis {

	public static Date pascoa(int ano){
		int a = ano % 19;
		int b = ano / 100;
		int c = ano % 100;
		int d = b / 4;
		int e = b % 4;
		int f = (b + 8) / 25;
		int g = (b - f + 1) / 3;
		int h = (19 * a + b - d - g + 15) % 30;
		int i = c / 4;
		int k = c % 4;
		int L = (32 + 2 * e + 2 * i - h - k) % 7;
		int m = (a + 11 * h + 22 * L) / 451;
		int mes = (h + L - 7 * m + 114)  /31;
		int dia = ((h + L - 7 * m + 114) % 31) + 1;
		Calendar calendar = DateUtil.hoje();
		calendar.set(ano, mes-1, dia, 0, 0, 0);
		return calendar.getTime();
	}

	public static Date corpusChristi(int ano){
		Calendar calendar = DateUtil.hoje();
		calendar.setTime(pascoa(ano));
		calendar.add(Calendar.DAY_OF_YEAR, 60);
		return calendar.getTime();
	}

	public static Date sextaFeiraSanta(int ano){
		Calendar calendar = DateUtil.hoje();
		calendar.setTime(pascoa(ano));
		calendar.add(Calendar.DAY_OF_YEAR, -2);
		return calendar.getTime();
	}

	public static Date tercaDeCarnaval(int ano){
		Calendar calendar = DateUtil.hoje();
		calendar.setTime(pascoa(ano));
		calendar.add(Calendar.DAY_OF_YEAR, -47);
		return calendar.getTime();
	}
	
	public static Date segundaDeCarnaval(int ano){
		Calendar calendar = DateUtil.hoje();
		calendar.setTime(pascoa(ano));
		calendar.add(Calendar.DAY_OF_YEAR, -48);
		return calendar.getTime();
	}

	public static Date diaDosPais(int ano){
		return getSegundoDomingo(Calendar.AUGUST, ano);
	}

	public static Date diaDasMaes(int ano){
		return getSegundoDomingo(Calendar.MAY, ano);
	}

	public static List<Feriado> doAno(int ano){
		List<Feriado> feriados = new ArrayList<Feriado>();
		feriados.add(new Feriado("SEGUNDA_CARNAVAL",segundaDeCarnaval(ano),Tipo.NACIONAL,"Brasil"));
		feriados.add(new Feriado("TERCA_CARNAVAL",tercaDeCarnaval(ano),Tipo.NACIONAL,"Brasil"));
		feriados.add(new Feriado("SEXTA_SANTA",sextaFeiraSanta(ano),Tipo.NACIONAL,"Brasil"));
		feriados.add(new Feriado("PASCOA",pascoa(ano),Tipo.NACIONAL,"Brasil"));
		feriados.add(new Feriado("CORPUS_CHRISTI",corpusChristi(ano),Tipo.NACIONAL,"Brasil"));
		feriados.add(new Feriado("DIA_MAES",diaDasMaes(ano),Tipo.NACIONAL,"Brasil"));
		feriados.add(new Feriado("DIA_PAIS",diaDosPais(ano),Tipo.NACIONAL,"Brasil"));
		if(ano % 2 == 0){
			feriados.add(new Feriado("PRI_TURNO_ELEICOES",primeiroTurnoDasEleicoes(ano),Tipo.NACIONAL,"Brasil"));
			feriados.add(new Feriado("SEG_TURNO_ELEICOES",segundoTurnoDasEleicoes(ano),Tipo.NACIONAL,"Brasil"));
		}
		Collections.sort(feriados, Ordernador.DATA_CRESCENTE);
		return feriados;
	}

	public static List<Feriado> doAno(){
		return doAno(DateUtil.getAno(DateUtil.hoje().getTime()));
	}

	private static Date getSegundoDomingo(int mes,int ano){
		Calendar calendar = DateUtil.hoje();
		calendar.set(ano, mes, 0,0,0,0); 
		int contadorDeDomingos = 0;
		for(int i = 1;i<=15;i++){
			calendar.set(Calendar.DAY_OF_MONTH, i);
			if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
				if(++contadorDeDomingos == 2){
					return calendar.getTime();
				}
			}
		}
		return null;
	}

	public static Date primeiroTurnoDasEleicoes(){
		Calendar calendar = DateUtil.hoje();
		if(DateUtil.getAno(calendar.getTime()) % 2 != 0){
			calendar.add(Calendar.YEAR, 1);
		}
		calendar.set(Calendar.MONTH, Calendar.OCTOBER);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		for(int i = 1; i < 8;i++){
			calendar.set(Calendar.DAY_OF_MONTH, i);
			if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
				return calendar.getTime();
			}
		}
		return null;
	}

	public static Date primeiroTurnoDasEleicoes(int ano){
		Calendar calendar = DateUtil.hoje();
		ano = ano % 2 == 0? ano: ++ano;
		calendar.set(Calendar.YEAR, ano);
		calendar.set(Calendar.MONTH, Calendar.OCTOBER);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		for(int i = 1; i < 8;i++){
			calendar.set(Calendar.DAY_OF_MONTH, i);
			if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
				return calendar.getTime();
			}
		}
		return null;
	}

	public static Date segundoTurnoDasEleicoes(int ano){
		Calendar calendar = DateUtil.hoje();
		ano = ano % 2 == 0? ano: ++ano;
		calendar.set(Calendar.YEAR, ano);
		calendar.set(Calendar.MONTH, Calendar.OCTOBER);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		for(int i = calendar.get(Calendar.DAY_OF_MONTH); i > 23;i--){
			calendar.set(Calendar.DAY_OF_MONTH, i);
			if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
				return calendar.getTime();
			}
		}
		return null;
	}

	public static Date segundoTurnoDasEleicoes(){
		Calendar calendar = DateUtil.hoje();
		if(DateUtil.getAno(calendar.getTime()) % 2 != 0){
			calendar.add(Calendar.YEAR, 1);
		}
		calendar.set(Calendar.MONTH, Calendar.OCTOBER);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		for(int i = calendar.get(Calendar.DAY_OF_MONTH); i > 23;i--){
			calendar.set(Calendar.DAY_OF_MONTH, i);
			if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
				return calendar.getTime();
			}
		}
		return null;
	}

	public static boolean ehFeriado(Date data){
		int ano = DateUtil.getAno(data);
		for(Feriado f : doAno(ano)){
			if(DateUtil.mesmoDia(data, f.getData())){
				return true;
			}	
		}
		return false;
	}
}
