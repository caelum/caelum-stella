package br.com.caelum.stella.boleto.transformer;

import java.io.InputStream;

import br.com.caelum.stella.boleto.Boleto;

public interface BoletoWriter {

	/**
	 * Escreve as informacoes do boleto no writer.
	 * 
	 * @param boleto
	 */
	void write(Boleto boleto);

	/**
	 * Grava num InputStream
	 * 
	 * @return
	 */
	InputStream toInputStream();

	/**
	 * Cria uma nova pagina no documento de saida.
	 * 
	 * @return <code>true</code> se uma nova pagina foi criada
	 */
	public boolean newPage();
}
