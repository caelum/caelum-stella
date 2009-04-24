package br.com.caelum.stella.gateway;

import java.util.Calendar;

/**
 * Classe utilitaria apenas comparar certos atributos do Calendar. 
 * @author Alberto Pc
 *
 */
public class CalendarCompareHelper {

	public boolean compareCalendars(Calendar date1,Calendar date2){
		boolean comparacaoDia = date1.get(Calendar.DAY_OF_MONTH)==date2.get(Calendar.DAY_OF_MONTH);
		boolean comparacaoMes = date1.get(Calendar.MONTH)==date2.get(Calendar.MONTH);
		boolean comparacaoAno = date1.get(Calendar.YEAR)==date2.get(Calendar.YEAR);
		boolean comparacaoHora = date1.get(Calendar.HOUR_OF_DAY)==date2.get(Calendar.HOUR_OF_DAY);
		boolean comparacaoMinuto = date1.get(Calendar.MINUTE)==date2.get(Calendar.MINUTE);
		boolean comparacaoSegundo = date1.get(Calendar.SECOND)==date2.get(Calendar.SECOND);
		return comparacaoAno && comparacaoDia && comparacaoHora && comparacaoMes && comparacaoMinuto && comparacaoSegundo;
	}
}
