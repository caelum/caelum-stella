package br.com.caelum.stella.feriado.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import br.com.caelum.stella.feriado.entity.Feriado;

public class DateUtil {

	public static final Locale LOCALE_BRAZIL = new Locale("pt","BR");
	public static final SimpleDateFormat formatterExtenso = new SimpleDateFormat("dd 'de' MMMMM 'de' yyyy");
	public static final SimpleDateFormat formatterDDMM = new SimpleDateFormat("dd/MM");
	public static final SimpleDateFormat formatterDDMMYYYY = new SimpleDateFormat("dd/MM/yyyy");
	private static Calendar calendar = Calendar.getInstance(LOCALE_BRAZIL);
	public static int getMes(Date data){
		calendar.setTime(data);
		return calendar.get(Calendar.MONTH)+1;
	}

	public static int getDiaDoMes(){
		return hoje().get(Calendar.DAY_OF_MONTH);
	}
	
	public static int getDiaDoMes(Date data){
		calendar.setTime(data);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	public static int getAno(Date data){
		calendar.setTime(data);
		return calendar.get(Calendar.YEAR);
	}
	
	public static int getAno(){
		return hoje().get(Calendar.YEAR);
	}
	

	public static boolean mesmoDia(Date d1, Date d2){
		Calendar c1 = zerarHora(d1);
		Calendar c2 = zerarHora(d2);
		return  (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)) && (c1.get(Calendar.DAY_OF_YEAR) == c2.get(Calendar.DAY_OF_YEAR));
	}
	
	public static Calendar hoje(){
		return zerarHora(Calendar.getInstance(LOCALE_BRAZIL));
	}
	
	public static List<Date> apenasDatas(List<Feriado> feriados){
		List<Date> datas = new ArrayList<Date>();
		Collections.sort(feriados, Ordernador.DATA_CRESCENTE);
		for(Feriado feriado : feriados){
			datas.add(feriado.getData());
		}
		return datas;
	}
	
	public static Calendar novaInstancia(int dia, int mes, int ano){
		Calendar c1 = hoje();
		c1.set(ano, mes-1, dia);
		return zerarHora(c1);
	}
	
	public static Calendar zerarHora(Calendar calendar){
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar;
	}
	public static Calendar zerarHora(Date data){
		Calendar c1 = Calendar.getInstance(LOCALE_BRAZIL);
		c1.setTime(data);
		return zerarHora(c1);
	}
}
