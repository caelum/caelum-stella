package br.com.caelum.stella.gateway.core;



/**
 * Interface que deve ser usada quando tiver a necessidade de criar os retornos
 * a partir da mesma entrada, só que de forma diferentes. Ex:br.com.caelum.stella.gateway.visa.VISASolicitacaoConferenciaViaHttp
 * @author Alberto
 *
 * @param <R> tipo do retorno do metodo
 * @param <T> tipo do parametro que ele vai receber
 * 
 */
public interface ReturnBuilder<R,T> {

	public R buildReturn(T source);
}
