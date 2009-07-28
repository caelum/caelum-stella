package br.com.caelum.stella.gateway.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarFormatter {

	/**
	 * 
	 * @param data
	 * @return data no formato yyyymmdd
	 */
	public String calendarToString(Calendar data){
		return calendarToString(data,"%1$tY%1$tm%1$td");
	}
	
	/**
	 * 
	 * @param data
	 * @param pattern padrao de formatacao. Ex:%1$td%1$tm%1$tY
	 * @return
	 */
	public String calendarToString(Calendar data,String pattern){
		return String.format(pattern,data);
	}
	
	
	/**
	 * 
	 * @param dataDesformatada no formato yyyymmdd
	 * @return
	 */
	public  Calendar stringToCalendar(String dataDesformatada){
		return stringToCalendar(dataDesformatada,"yyyyMMdd");		
	}
	
	/**
	 * 
	 * @param dataDesformatada 
	 * @param pattern padrão para conversão da data para Calendar. Ex: yyyymmdd 
	 * @return
	 */
	public Calendar stringToCalendar(String dataDesformatada,String pattern){		
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		Calendar dataAutorizacao = Calendar.getInstance();
		try {
			dataAutorizacao.setTime(formatter.parse(dataDesformatada));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new IntegrationFailedException("A conversão da data "+dataDesformatada+" falhou",e);
		}		
		return dataAutorizacao;		
	}	
}
