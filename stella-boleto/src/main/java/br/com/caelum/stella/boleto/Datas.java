package br.com.caelum.stella.boleto;

import java.util.Calendar;

public interface Datas {

	Calendar getVencimento();

	Calendar getDocumento();

	Calendar getProcessamento();

}