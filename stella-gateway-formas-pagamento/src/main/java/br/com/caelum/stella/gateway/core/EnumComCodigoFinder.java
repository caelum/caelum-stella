package br.com.caelum.stella.gateway.core;

import java.util.Collection;

/**
 * Descobre o tipo de transação pelo codigo
 * @author Alberto Pc
 * @param <T> tipo do retorno
 */
public class EnumComCodigoFinder<T extends DefinedByCode> {



	/**
	 * Retorna a Enum baseada no codigo passado como parametro. A mesma deve implementar 
	 * a Interface DefinedByCode
	 * @param enumClass 
	 * @param codigo que serve de base para a busca
	 * @return Enum descoberta
	 */
	@SuppressWarnings("unchecked")
	public T descobreAEnumPeloCodigo(Class<T> enumClass,String codigo){
		if(!enumClass.isEnum()){
			throw new IllegalArgumentException("O tipo "+enumClass+", deveria ser uma Enum");
		}
		Collection<DefinedByCode> definedByCodes;
		try {
			definedByCodes = (Collection<DefinedByCode>) enumClass.getMethod("values").invoke(enumClass);
			for(DefinedByCode definedByCode : definedByCodes){
				if(definedByCode.getCodigo().equals(codigo)){
					return (T)definedByCode;
				}
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

		throw new IntegrationFailedException("O parametro codigo não foi encontrado("+codigo+")");
	}
}
