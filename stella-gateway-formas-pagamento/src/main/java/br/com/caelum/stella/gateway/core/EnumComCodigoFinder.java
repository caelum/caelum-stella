package br.com.caelum.stella.gateway.core;

import net.vidageek.mirror.Mirror;

/**
 * 
 * 
 * @author Alberto Pc
 * @param <T>
 *            tipo do retorno
 */
public class EnumComCodigoFinder {

	/**
	 * Retorna a Enum baseada no codigo passado como parametro. A mesma deve
	 * implementar a Interface DefinedByCode
	 * 
	 * @param enumClass
	 * @param codigo
	 *            que serve de base para a busca
	 * @return Enum descoberta
	 */
	@SuppressWarnings("unchecked")
	public <T extends DefinedByCode> T descobreAEnumPeloCodigo(
			Class<T> enumClass, String codigo) {
		if (!enumClass.isEnum()) {
			throw new IllegalArgumentException("O tipo " + enumClass
					+ ", deveria ser uma Enum");
		}

		DefinedByCode[] definedByCodes = (DefinedByCode[]) Mirror.on(enumClass)
				.invoke().method("values").withoutArgs();
		for (DefinedByCode definedByCode : definedByCodes) {
			if (definedByCode.getCodigo().equals(codigo)) {
				return (T) definedByCode;
			}
		}

		throw new IntegrationFailedException(
				"O parametro codigo não foi encontrado(" + codigo + ")");
	}
}
