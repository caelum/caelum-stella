package br.com.caelum.stella.boleto;

import java.util.Calendar;

public interface Datas {

	Calendar getDataDeVencimento();

	Calendar getDataDoDocumento();

	Calendar getDataDoProcessamento();

}