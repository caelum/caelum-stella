package br.com.caelum.stella.boleto;

import java.util.Calendar;

public interface Datas {

	public abstract Calendar getDataVencimento();

	public abstract Calendar getDataDocumento();

	public abstract Calendar getDataProcessamento();

}